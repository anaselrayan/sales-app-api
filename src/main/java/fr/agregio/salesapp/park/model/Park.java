package fr.agregio.salesapp.park.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fr.agregio.salesapp.offer.model.Offer;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Park {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ParkType parkType;

    private int capacity;

    @ManyToMany
    @JoinTable(name = "produce_offer",
               joinColumns = @JoinColumn(name = "park_id"),
               inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonBackReference
    private Set<Offer> offers = new HashSet<>();

    public Park(String name, ParkType parkType, int capacity) {
        this.name = name;
        this.parkType = parkType;
        this.capacity = capacity;
    }

    public boolean addOffer(Offer offer) {
        return offers.add(offer);
    }
}
