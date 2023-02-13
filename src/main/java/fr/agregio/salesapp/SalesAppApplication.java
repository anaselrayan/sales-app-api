package fr.agregio.salesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesAppApplication.class, args);
    }

//    @Bean
    //    CommandLineRunner fillData(ParkService parkService, TimeBlocService timeBlocService, OfferService
    //    offerService, ApplicationContext applicationContext) {
    //        return args -> {
    //
    //            LocalTime firstBlocStartTime = LocalTime.of(0, 0, 0);
    //            List<TimeBloc> timeBlocs = Stream.of(new TimeBloc(UUID.fromString
    //            ("809ea1e8-1f4c-4b4e-9fa4-53d24150ad32"),
    //                                                              firstBlocStartTime,
    //                                                              firstBlocStartTime.plusHours(3),
    //                                                              4500,
    //                                                              BigDecimal.TEN),
    //                                                 new TimeBloc(UUID.fromString
    //                                                 ("5ecb0116-2463-468f-924b-bca63ede7441"),
    //                                                              firstBlocStartTime.plusHours(3),
    //                                                              firstBlocStartTime.plusHours(6),
    //                                                              6500,
    //                                                              BigDecimal.TEN),
    //                                                 new TimeBloc(UUID.fromString
    //                                                 ("43395128-89d1-4d4c-9a56-6e19c1e909b8"),
    //                                                              firstBlocStartTime.plusHours(6),
    //                                                              firstBlocStartTime.plusHours(9),
    //                                                              1700,
    //                                                              BigDecimal.TEN),
    //                                                 new TimeBloc(UUID.fromString
    //                                                 ("a6606940-ec1f-41e8-b5f5-370bb22e0b81"),
    //                                                              firstBlocStartTime.plusHours(9),
    //                                                              firstBlocStartTime.plusHours(12),
    //                                                              9000,
    //                                                              BigDecimal.TEN))
    //                                             .map(timeBlocService::createNewTimeBloc)
    //                                             .toList();
    //
    //            List<ParkDto> parkDtos = Stream.of(new ParkCreateRequestDto("Park 1", ParkType.SOLAR, 100),
    //                                               new ParkCreateRequestDto("Park 3", ParkType.HYDRAULIC, 300),
    //                                               new ParkCreateRequestDto("Park 2", ParkType.WIND, 200))
    //                                           .map(parkService::createNewPark)
    //                                           .toList();
    //
    //            Stream.of(new OfferCreateRequestDto(PRIMARY_RESERVE,
    //                                                BigDecimal.ONE,
    //                                                List.of(timeBlocs.get(0)
    //                                                                 .getId(),
    //                                                        timeBlocs.get(1)
    //                                                                 .getId()),
    //                                                List.of(parkDtos.get(0)
    //                                                                .id(),
    //                                                        parkDtos.get(1)
    //                                                                .id())),
    //                      new OfferCreateRequestDto(QUICK_RESERVE,
    //                                                BigDecimal.ONE,
    //                                                List.of(timeBlocs.get(0)
    //                                                                 .getId()),
    //                                                List.of(parkDtos.get(0)
    //                                                                .id())),
    //                      new OfferCreateRequestDto(SECONDARY_RESERVE,
    //                                                BigDecimal.ONE,
    //                                                List.of(timeBlocs.get(3)
    //                                                                 .getId()),
    //                                                List.of(parkDtos.get(1)
    //                                                                .id())),
    //                      new OfferCreateRequestDto(SECONDARY_RESERVE,
    //                                                BigDecimal.ONE,
    //                                                Collections.emptyList(),
    //                                                Collections.emptyList()))
    //                  .forEach(offerService::createNewOffer);
    //        };
    //    }

}
