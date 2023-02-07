package fr.agregio.salesapp.timebloc.service;

import fr.agregio.salesapp.timebloc.exception.TimeBlocNotFoundException;
import fr.agregio.salesapp.timebloc.model.TimeBloc;
import fr.agregio.salesapp.timebloc.repository.TimeBlocRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class TimeBlocServiceImpl implements TimeBlocService {
    private final TimeBlocRepository timeBlocRepository;

    @Override
    public TimeBloc createNewTimeBloc(TimeBloc timeBloc) {
        log.info("Create new time bloc: {}", timeBloc);

        return timeBlocRepository.save(timeBloc);
    }

    @Override
    public TimeBloc getTimeBlocById(UUID timeBlocId) {
        return timeBlocRepository.findById(timeBlocId)
                                 .orElseThrow(() -> new TimeBlocNotFoundException(timeBlocId));
    }

    @Override
    public List<TimeBloc> findAll() {
        return timeBlocRepository.findAll();
    }
}
