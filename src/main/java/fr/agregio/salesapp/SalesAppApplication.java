package fr.agregio.salesapp;

import fr.agregio.salesapp.offer.dto.OfferCreateRequestDto;
import fr.agregio.salesapp.offer.service.OfferService;
import fr.agregio.salesapp.park.dto.ParkCreateRequestDto;
import fr.agregio.salesapp.park.dto.ParkDto;
import fr.agregio.salesapp.park.model.ParkType;
import fr.agregio.salesapp.park.service.ParkService;
import fr.agregio.salesapp.timebloc.model.TimeBloc;
import fr.agregio.salesapp.timebloc.service.TimeBlocService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import static fr.agregio.salesapp.offer.model.MarketType.*;

@SpringBootApplication
public class SalesAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesAppApplication.class, args);
    }

    @Bean
    CommandLineRunner fillData(ParkService parkService, TimeBlocService timeBlocService, OfferService offerService, ApplicationContext applicationContext) {
        return args -> {

            // TimeBlocs creation

            LocalTime firstBlocStartTime = LocalTime.of(0, 0, 0);
            List<TimeBloc> timeBlocs = Stream.of(new TimeBloc(firstBlocStartTime,
                                                              firstBlocStartTime.plusHours(3),
                                                              1000,
                                                              BigDecimal.TEN),
                                                 new TimeBloc(firstBlocStartTime.plusHours(3),
                                                              firstBlocStartTime.plusHours(6),
                                                              1000,
                                                              BigDecimal.TEN),
                                                 new TimeBloc(firstBlocStartTime.plusHours(6),
                                                              firstBlocStartTime.plusHours(9),
                                                              1000,
                                                              BigDecimal.TEN),
                                                 new TimeBloc(firstBlocStartTime.plusHours(9),
                                                              firstBlocStartTime.plusHours(12),
                                                              1000,
                                                              BigDecimal.TEN))
                                             .map(timeBlocService::createNewTimeBloc)
                                             .toList();

            // Parks creation

            List<ParkDto> parkDtos = Stream.of(new ParkCreateRequestDto("Park 1", ParkType.SOLAR, 100),
                                               new ParkCreateRequestDto("Park 3", ParkType.HYDRAULIC, 300),
                                               new ParkCreateRequestDto("Park 2", ParkType.WIND, 200))
                                           .map(parkService::createNewPark)
                                           .toList();


            // Offers creation

            Stream.of(new OfferCreateRequestDto(PRIMARY_RESERVE,
                                                BigDecimal.ONE,
                                                List.of(timeBlocs.get(0)
                                                                 .getId(),
                                                        timeBlocs.get(1)
                                                                 .getId()),
                                                List.of(parkDtos.get(0)
                                                                .id(),
                                                        parkDtos.get(1)
                                                                .id())),
                      new OfferCreateRequestDto(QUICK_RESERVE,
                                                BigDecimal.ONE,
                                                List.of(timeBlocs.get(0)
                                                                 .getId()),
                                                List.of(parkDtos.get(0)
                                                                .id())),
                      new OfferCreateRequestDto(SECONDARY_RESERVE,
                                                BigDecimal.ONE,
                                                List.of(timeBlocs.get(3)
                                                                 .getId()),
                                                List.of(parkDtos.get(1)
                                                                .id())))
                  .forEach(offerService::createNewOffer);
        };
    }

}
