package fr.agregio.salesapp.timebloc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;


@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
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
}
