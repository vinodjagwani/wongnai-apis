package th.wongnai.fdelivery.driver.feature.web.facade;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import th.wongnai.fdelivery.driver.feature.repository.entity.Driver;
import th.wongnai.fdelivery.driver.feature.repository.entity.Location;
import th.wongnai.fdelivery.driver.feature.service.DriverService;
import th.wongnai.fdelivery.driver.feature.service.LocationService;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverCreateRequest;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverCreateResponse;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverDetailResponse;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverLocationCreateRequest;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverLocationCreateResponse;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverLocationQueryRequest;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverLocationQueryResponse;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverStatusUpdateRequest;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverStatusUpdateResponse;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DriverCreateFacade {

    DriverService driverService;

    LocationService locationService;

    public Mono<DriverCreateResponse> createDriver(final DriverCreateRequest request) {
        return driverService.save(createDriverRequest(request)).map(response -> new DriverCreateResponse(response.getDriverId()));
    }

    public Mono<DriverStatusUpdateResponse> updateDriverStatus(final DriverStatusUpdateRequest request) {
        return driverService.findOne(request.driverId()).map(driver -> {
            driver.setDriverStatus(request.driverStatus());
            return driver;
        }).map(driverService::save).flatMap(updatedOrder -> updatedOrder.map(response -> new DriverStatusUpdateResponse(response.getDriverId())));
    }

    public Mono<DriverDetailResponse> getAvailableDriver() {
        return Mono.from(driverService.findAllByDriverStatus(true).map(driver -> new DriverDetailResponse(driver.getDriverId(), driver.getFirstName(), driver.getLastName())));
    }

    public Mono<DriverLocationCreateResponse> createDriverLocation(final DriverLocationCreateRequest request) {
        final Location location = new Location();
        location.setDriverId(request.driverId());
        location.setLocation(new double[]{request.latitude(), request.longitude()});
        return locationService.save(location).map(savedLocation -> new DriverLocationCreateResponse(location.getDriverId()));
    }

    public Flux<DriverLocationQueryResponse> findDriverLocation(final DriverLocationQueryRequest request) {
        final Point point = new Point(request.latitude(), request.longitude());
        final Distance distance = new Distance(5, Metrics.KILOMETERS);
        return locationService.findByDriverAndLocationNear(request.driverId(), point, distance)
                .map(l -> new DriverLocationQueryResponse(l.getDriverId(), l.getLocation()[0], l.getLocation()[1]));
    }


    private Driver createDriverRequest(final DriverCreateRequest request) {
        final Driver driver = new Driver();
        driver.setDriverId(UUID.randomUUID().toString());
        driver.setFirstName(request.firstName());
        driver.setLastName(request.lastName());
        driver.setCreateAt(LocalDateTime.now());
        driver.setDriverStatus(true);
        return driver;
    }
}
