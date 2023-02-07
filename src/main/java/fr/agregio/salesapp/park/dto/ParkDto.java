package fr.agregio.salesapp.park.dto;

import fr.agregio.salesapp.park.model.ParkType;

import java.util.UUID;

public record ParkDto(UUID id, String name, ParkType parkType, int capacity) {
}
