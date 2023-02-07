package fr.agregio.salesapp.timebloc.dto;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;

public record TimeBlocDto(
        UUID id, LocalTime startTime, LocalTime endTime, int quantity, BigDecimal floorPrice
) {
}
