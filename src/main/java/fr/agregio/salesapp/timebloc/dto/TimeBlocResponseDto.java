package fr.agregio.salesapp.timebloc.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;

@Builder
public record TimeBlocResponseDto(
        UUID id, LocalTime startTime, LocalTime endTime, int quantity, BigDecimal floorPrice
) {}
