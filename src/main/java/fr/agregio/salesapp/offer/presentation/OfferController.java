package fr.agregio.salesapp.offer.presentation;

import fr.agregio.salesapp.offer.dto.OfferCreateRequestDto;
import fr.agregio.salesapp.offer.dto.OfferDto;
import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.offer.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/offers")
public class OfferController {

    private final OfferService offerService;


    @PostMapping
    public OfferDto createNewOffer(@RequestBody OfferCreateRequestDto offerCreateRequestDto) {
        return offerService.createNewOffer(offerCreateRequestDto);
    }

    @GetMapping
    public List<OfferDto> findAllByMarketType(@RequestParam(name = "market-type") MarketType marketType) {
        return offerService.findAllByMarketType(marketType);
    }

}
