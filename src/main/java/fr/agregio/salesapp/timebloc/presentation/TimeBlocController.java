package fr.agregio.salesapp.timebloc.presentation;

import fr.agregio.salesapp.timebloc.dto.TimeBlocDto;
import fr.agregio.salesapp.timebloc.dto.TimeBlocMapper;
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

    @GetMapping
    public List<TimeBlocDto> findAllTimeBlocs() {
        return timeBlocService.findAll()
                              .stream()
                              .map(TimeBlocMapper::toTimeBlocDto)
                              .toList();
    }
}
