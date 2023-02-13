package fr.agregio.salesapp.park.service;


import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.offer.model.Offer;
import fr.agregio.salesapp.park.dto.ParkCreateRequestDto;
import fr.agregio.salesapp.park.dto.ParkDto;
import fr.agregio.salesapp.park.model.Park;

import java.util.List;
import java.util.UUID;

public interface ParkService {
    ParkDto createNewPark(ParkCreateRequestDto parkCreateRequestDto);

    List<ParkDto> findAllByMarketType(MarketType marketType);

    boolean addOfferToPark(Offer offer, Park park);

    Park getParkById(UUID parkId);
}
