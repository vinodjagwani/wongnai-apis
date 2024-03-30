package th.wongnai.fdelivery.driver.feature.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import th.wongnai.fdelivery.driver.feature.repository.LocationRepository;
import th.wongnai.fdelivery.driver.feature.repository.entity.Location;
import th.wongnai.fdelivery.driver.feature.service.LocationService;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LocationServiceImpl implements LocationService {

    LocationRepository locationRepository;

    @Override
    public Mono<Location> save(final Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Flux<Location> findByDriverAndLocationNear(final String driverId, final Point point, final Distance maxDistance) {
        return locationRepository.findByDriverIdAndLocationNear(driverId, point, maxDistance);
    }
}
