package fr.agregio.salesapp.timebloc.model;

import fr.agregio.salesapp.offer.model.Offer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Data
@Entity
public class TimeBloc {
    @Id
    @GeneratedValue
    private UUID id;

    private LocalTime startTime;

    private LocalTime endTime;

    private int quantity;

    private BigDecimal floorPrice;

    @ManyToMany
    private List<Offer> offers = new ArrayList<>();

    public TimeBloc(LocalTime startTime, LocalTime endTime, int quantity, BigDecimal floorPrice) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.quantity = quantity;
        this.floorPrice = floorPrice;
    }
}
