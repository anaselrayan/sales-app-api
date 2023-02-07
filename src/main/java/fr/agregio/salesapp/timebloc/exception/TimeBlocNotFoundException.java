package fr.agregio.salesapp.timebloc.exception;

import java.util.UUID;

public class TimeBlocNotFoundException extends RuntimeException {
    public TimeBlocNotFoundException(UUID timeBlocId) {
        super(String.format("TimeBloc %s not found", timeBlocId));
    }
}
