package fr.agregio.salesapp.park.service;

import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.offer.model.Offer;
import fr.agregio.salesapp.park.dto.ParkCreateRequestDto;
import fr.agregio.salesapp.park.dto.ParkDto;
import fr.agregio.salesapp.park.dto.ParkMapper;
import fr.agregio.salesapp.park.exception.ParkNotFoundException;
import fr.agregio.salesapp.park.model.Park;
import fr.agregio.salesapp.park.repository.ParkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ParkServiceImpl implements ParkService {
    private final ParkRepository parkRepository;

    @Override
    public ParkDto createNewPark(ParkCreateRequestDto parkCreateRequestDto) {
        Park park = ParkMapper.fromParkCreateRequestDto(parkCreateRequestDto);
        return ParkMapper.toParkDto(parkRepository.save(park));
    }

    @Override
    public List<ParkDto> findAllByMarketType(MarketType marketType) {
        return parkRepository.findAllByMarketType(marketType)
                             .stream()
                             .map(ParkMapper::toParkDto)
                             .toList();
    }

    @Override
    public boolean addOfferToPark(Offer offer, UUID parkId) {
        return parkRepository.findById(parkId)
                             .orElseThrow(() -> new ParkNotFoundException(parkId))
                             .addOffer(offer);
    }

}
