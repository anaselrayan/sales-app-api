package fr.agregio.salesapp.park.service;

import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.offer.model.Offer;
import fr.agregio.salesapp.park.exception.ParkNotFoundException;
import fr.agregio.salesapp.park.model.Park;
import fr.agregio.salesapp.park.repository.ParkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ParkServiceImpl implements ParkService {
    private final ParkRepository parkRepository;

    @Override
    public Park createNewPark(Park newPark) {
        log.info("Create new park: {}", newPark);
        return parkRepository.save(newPark);
    }

    @Override
    public List<Park> findAllByMarketType(MarketType marketType) {
        return parkRepository.findAllByMarketType(marketType);
    }

    @Override
    public boolean addOfferToPark(Offer offer, Park park) {
        return getParkById(park.getId()).addOffer(offer);
    }

    @Override
    public Park getParkById(UUID parkId) {
        return parkRepository.findById(parkId).orElseThrow(() -> new ParkNotFoundException(parkId));
    }

}
