package fr.agregio.salesapp.park.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.agregio.salesapp.park.model.ParkType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ParkCreateRequestDto(
        @NotEmpty String name,
        @NotNull @JsonProperty("park-type") ParkType parkType,
        @Positive @NotNull int capacity
) {
}
