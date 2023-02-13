package fr.agregio.salesapp.offer.service;

import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.offer.model.Offer;

import java.util.List;

public interface OfferService {
    Offer createNewOffer(Offer newOffer);

    List<Offer> findAllByMarketType(MarketType marketType);
}
