package fr.agregio.salesapp.offer.presentation;

import fr.agregio.salesapp.offer.dto.OfferCreateRequestDto;
import fr.agregio.salesapp.offer.dto.OfferMapper;
import fr.agregio.salesapp.offer.dto.OfferResponseDto;
import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.offer.model.Offer;
import fr.agregio.salesapp.offer.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/offers")
public class OfferController {

    private final OfferService offerService;
    private final OfferMapper offerMapper;


    @PostMapping
    public OfferResponseDto createNewOffer(@RequestBody OfferCreateRequestDto offerCreateRequestDto) {
        Offer newOffer = offerMapper.fromOfferCreateRequestDto(offerCreateRequestDto);
        return offerMapper.toOfferResponseDto(offerService.createNewOffer(newOffer));
    }

    @GetMapping
    public List<OfferResponseDto> findAllByMarketType(@RequestParam(name = "market-type") MarketType marketType) {
        return offerService.findAllByMarketType(marketType).stream().map(offerMapper::toOfferResponseDto).toList();
    }

}
