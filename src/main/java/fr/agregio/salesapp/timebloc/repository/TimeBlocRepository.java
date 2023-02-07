package fr.agregio.salesapp.timebloc.repository;


import fr.agregio.salesapp.timebloc.model.TimeBloc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TimeBlocRepository extends JpaRepository<TimeBloc, UUID> {
}
