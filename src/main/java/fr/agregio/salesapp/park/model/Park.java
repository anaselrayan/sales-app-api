package fr.agregio.salesapp.park.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fr.agregio.salesapp.offer.model.Offer;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Park {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ParkType parkType;

    private int capacity;

    @ManyToMany
    @JoinTable(
            name = "park_offer",
            joinColumns = @JoinColumn(name = "park_id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id")
    )
    @JsonBackReference
    private Set<Offer> offers = new HashSet<>();

    public boolean addOffer(Offer offer) {
        return offers.add(offer);
    }
}
