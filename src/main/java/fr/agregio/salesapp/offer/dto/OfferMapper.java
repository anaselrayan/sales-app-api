package fr.agregio.salesapp.offer.dto;

import fr.agregio.salesapp.offer.model.Offer;
import fr.agregio.salesapp.park.dto.ParkMapper;
import fr.agregio.salesapp.park.dto.ParkResponseDto;
import fr.agregio.salesapp.park.model.Park;
import fr.agregio.salesapp.park.service.ParkService;
import fr.agregio.salesapp.timebloc.dto.TimeBlocDto;
import fr.agregio.salesapp.timebloc.dto.TimeBlocMapper;
import fr.agregio.salesapp.timebloc.model.TimeBloc;
import fr.agregio.salesapp.timebloc.service.TimeBlocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class OfferMapper {

    private final TimeBlocService timeBlocService;
    private final ParkService parkService;
    private final ParkMapper parkMapper;


    public OfferResponseDto toOfferResponseDto(Offer offer) {
        List<TimeBlocDto> blocs = offer.getBlocs().stream().map(TimeBlocMapper::toTimeBlocDto).toList();
        List<ParkResponseDto> parks = offer.getParks().stream().map(parkMapper::toParkResponseDto).toList();

        return OfferResponseDto.builder()
                .id(offer.getId())
                .marketType(offer.getMarketType())
                .price(offer.getPrice())
                .blocs(blocs)
                .parks(parks)
                .build();
    }

    public Offer fromOfferCreateRequestDto(OfferCreateRequestDto offerCreateRequestDto) {
        List<TimeBloc> timeBlocs = offerCreateRequestDto.blocs()
                .stream()
                .map(timeBlocService::getTimeBlocById)
                .toList();

        List<Park> parks = offerCreateRequestDto.parks().stream().map(parkService::getParkById).toList();

        return Offer.builder()
                .marketType(offerCreateRequestDto.marketType())
                .price(offerCreateRequestDto.price())
                .blocs(timeBlocs)
                .parks(parks)
                .build();
    }
}
