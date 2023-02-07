package fr.agregio.salesapp.park.dto;

import fr.agregio.salesapp.park.model.Park;

public class ParkMapper {
    public static Park fromParkCreateRequestDto(ParkCreateRequestDto parkCreateRequestDto) {
        return new Park(parkCreateRequestDto.name(), parkCreateRequestDto.parkType(), parkCreateRequestDto.capacity());
    }

    public static ParkDto toParkDto(Park park) {
        return new ParkDto(park.getId(), park.getName(), park.getParkType(), park.getCapacity());
    }
}
