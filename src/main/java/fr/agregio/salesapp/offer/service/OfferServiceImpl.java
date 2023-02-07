package fr.agregio.salesapp.offer.service;

import fr.agregio.salesapp.offer.dto.OfferCreateRequestDto;
import fr.agregio.salesapp.offer.dto.OfferDto;
import fr.agregio.salesapp.offer.dto.OfferMapper;
import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.offer.model.Offer;
import fr.agregio.salesapp.offer.repository.OfferRepository;
import fr.agregio.salesapp.park.service.ParkService;
import fr.agregio.salesapp.timebloc.service.TimeBlocService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final TimeBlocService timeBlocService;
    private final ParkService parkService;

    @Override
    public OfferDto createNewOffer(OfferCreateRequestDto offerCreateRequestDto) {
        Offer newOffer = offerRepository.save(new Offer(offerCreateRequestDto.marketType(),
                                                        offerCreateRequestDto.price()));

        offerCreateRequestDto.blocs()
                             .stream()
                             .map(timeBlocService::getTimeBlocById)
                             .forEach(newOffer::addTimeBloc);

        offerCreateRequestDto.parks()
                             .forEach(parkId -> parkService.addOfferToPark(newOffer, parkId));

        return OfferMapper.toOfferDto(newOffer);
    }

    @Override
    public List<OfferDto> findAllByMarketType(MarketType marketType) {
        return offerRepository.findAllByMarketType(marketType)
                              .stream()
                              .map(OfferMapper::toOfferDto)
                              .toList();
    }
}
