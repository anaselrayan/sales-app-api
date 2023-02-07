package fr.agregio.salesapp.offer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.agregio.salesapp.offer.model.MarketType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OfferCreateRequestDto(
        @NotNull @JsonProperty("market-type") MarketType marketType,
        @Positive BigDecimal price,
        @NotEmpty List<UUID> blocs,
        @NotEmpty List<UUID> parks
) {
}
