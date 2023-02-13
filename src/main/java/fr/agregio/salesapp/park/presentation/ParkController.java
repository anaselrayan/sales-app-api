package fr.agregio.salesapp.park.presentation;

import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.park.dto.ParkCreateRequestDto;
import fr.agregio.salesapp.park.dto.ParkMapper;
import fr.agregio.salesapp.park.dto.ParkResponseDto;
import fr.agregio.salesapp.park.model.Park;
import fr.agregio.salesapp.park.service.ParkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/parks")
public class ParkController {

    private final ParkService parkService;
    private final ParkMapper parkMapper;

    @PostMapping
    public ParkResponseDto createNewPark(@RequestBody ParkCreateRequestDto parkCreateRequestDto) {
        Park park = parkMapper.fromParkCreateRequestDto(parkCreateRequestDto);
        return parkMapper.toParkResponseDto(parkService.createNewPark(park));
    }

    @GetMapping
    public List<ParkResponseDto> findAllByMarketType(@RequestParam(name = "market-type") MarketType marketType) {
        return parkService.findAllByMarketType(marketType).stream().map(parkMapper::toParkResponseDto).toList();
    }
}
