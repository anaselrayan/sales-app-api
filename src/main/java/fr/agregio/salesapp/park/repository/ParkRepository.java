package fr.agregio.salesapp.park.repository;

import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.park.model.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ParkRepository extends JpaRepository<Park, UUID> {

    @Query("SELECT p FROM Park p JOIN p.offers o WHERE o.marketType = :marketType ")
    List<Park> findAllByMarketType(@Param("marketType") MarketType marketType);
}
