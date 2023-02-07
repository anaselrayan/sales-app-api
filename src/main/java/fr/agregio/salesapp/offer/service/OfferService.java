package fr.agregio.salesapp.offer.service;

import fr.agregio.salesapp.offer.dto.OfferCreateRequestDto;
import fr.agregio.salesapp.offer.dto.OfferDto;
import fr.agregio.salesapp.offer.model.MarketType;

import java.util.List;

public interface OfferService {
    OfferDto createNewOffer(OfferCreateRequestDto offerCreateRequestDto);

    List<OfferDto> findAllByMarketType(MarketType marketType);
}
