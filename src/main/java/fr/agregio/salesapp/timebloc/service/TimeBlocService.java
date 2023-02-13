package fr.agregio.salesapp.timebloc.service;

import fr.agregio.salesapp.timebloc.model.TimeBloc;

import java.util.List;
import java.util.UUID;

public interface TimeBlocService {
    TimeBloc getTimeBlocById(UUID timeBlocId);

    List<TimeBloc> findAll();
}
