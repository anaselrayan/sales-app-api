package fr.agregio.salesapp.timebloc.presentation;

import fr.agregio.salesapp.timebloc.dto.TimeBlocMapper;
import fr.agregio.salesapp.timebloc.dto.TimeBlocResponseDto;
import fr.agregio.salesapp.timebloc.service.TimeBlocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/time-blocs")
public class TimeBlocController {

    private final TimeBlocService timeBlocService;
    private final TimeBlocMapper timeBlocMapper;

    @GetMapping
    public List<TimeBlocResponseDto> findAllTimeBlocs() {
        return timeBlocService.findAll().stream().map(timeBlocMapper::toTimeBlocResponseDto).toList();
    }
}
