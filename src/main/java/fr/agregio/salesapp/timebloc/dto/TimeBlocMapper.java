package fr.agregio.salesapp.timebloc.dto;

import fr.agregio.salesapp.timebloc.model.TimeBloc;

public class TimeBlocMapper {

    public static TimeBlocDto toTimeBlocDto(TimeBloc timeBloc) {
        return new TimeBlocDto(timeBloc.getId(),
                               timeBloc.getStartTime(),
                               timeBloc.getEndTime(),
                               timeBloc.getQuantity(),
                               timeBloc.getFloorPrice());
    }
}
