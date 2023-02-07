package fr.agregio.salesapp.offer.dto;

import fr.agregio.salesapp.offer.model.Offer;
import fr.agregio.salesapp.park.dto.ParkMapper;
import fr.agregio.salesapp.timebloc.dto.TimeBlocMapper;

public class OfferMapper {

    public static OfferDto toOfferDto(Offer offer) {
        return new OfferDto(offer.getId(),
                            offer.getMarketType(),
                            offer.getPrice(),
                            offer.getBlocs()
                                 .stream()
                                 .map(TimeBlocMapper::toTimeBlocDto)
                                 .toList(),
                            offer.getParks()
                                 .stream()
                                 .map(ParkMapper::toParkDto)
                                 .toList());
    }
}
