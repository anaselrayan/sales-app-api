package fr.agregio.salesapp.timebloc.dto;

import fr.agregio.salesapp.timebloc.model.TimeBloc;
import org.springframework.stereotype.Component;

@Component
public class TimeBlocMapper {

    public TimeBlocResponseDto toTimeBlocResponseDto(TimeBloc timeBloc) {
        return TimeBlocResponseDto.builder()
                .id(timeBloc.getId())
                .startTime(timeBloc.getStartTime())
                .endTime(timeBloc.getEndTime())
                .quantity(timeBloc.getQuantity())
                .floorPrice(timeBloc.getFloorPrice())
                .build();
    }
}
