package fr.agregio.salesapp.park.dto;

import fr.agregio.salesapp.park.model.Park;
import org.springframework.stereotype.Component;

@Component
public class ParkMapper {

    public ParkResponseDto toParkResponseDto(Park park) {
        return ParkResponseDto.builder()
                .id(park.getId())
                .name(park.getName())
                .parkType(park.getParkType())
                .capacity(park.getCapacity())
                .build();
    }

    public Park fromParkCreateRequestDto(ParkCreateRequestDto parkCreateRequestDto) {
        return Park.builder()
                .name(parkCreateRequestDto.name())
                .parkType(parkCreateRequestDto.parkType())
                .capacity(parkCreateRequestDto.capacity())
                .build();
    }
}
