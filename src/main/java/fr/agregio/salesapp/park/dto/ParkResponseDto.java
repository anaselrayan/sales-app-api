package fr.agregio.salesapp.park.dto;

import fr.agregio.salesapp.park.model.ParkType;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ParkResponseDto(UUID id, String name, ParkType parkType, int capacity) {
}
