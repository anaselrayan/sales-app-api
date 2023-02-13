package fr.agregio.salesapp.offer.service;

import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.offer.model.Offer;
import fr.agregio.salesapp.offer.repository.OfferRepository;
import fr.agregio.salesapp.park.service.ParkService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ParkService parkService;

    @Transactional
    @Override
    public Offer createNewOffer(Offer newOffer) {
        log.info("Create new offer: {}", newOffer);

        Offer savedOffer = offerRepository.save(newOffer);

        savedOffer.getParks().forEach(park -> parkService.addOfferToPark(savedOffer, park));

        return savedOffer;
    }

    @Override
    public List<Offer> findAllByMarketType(MarketType marketType) {
        return offerRepository.findAllByMarketType(marketType);
    }
}
