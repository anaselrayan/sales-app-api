package fr.agregio.salesapp.park.exception;

import java.util.UUID;

public class ParkNotFoundException extends RuntimeException {
    public ParkNotFoundException(UUID parkId) {
        super(String.format("Park %s not found ", parkId));
    }
}
