package fr.agregio.salesapp.park.presentation;

import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.park.dto.ParkCreateRequestDto;
import fr.agregio.salesapp.park.dto.ParkDto;
import fr.agregio.salesapp.park.service.ParkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/parks")
public class ParkController {

    private final ParkService parkService;

    @PostMapping
    public ParkDto createNewPark(@RequestBody ParkCreateRequestDto parkCreateRequestDto) {
        return parkService.createNewPark(parkCreateRequestDto);
    }

    @GetMapping
    public List<ParkDto> findAllByMarketType(@RequestParam(name = "market-type") MarketType marketType) {
        return parkService.findAllByMarketType(marketType);
    }
}
