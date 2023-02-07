package fr.agregio.salesapp.offer.repository;

import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.offer.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, UUID> {
    List<Offer> findAllByMarketType(MarketType marketType);
}
