package th.wongnai.fdelivery.driver.feature.service;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import th.wongnai.fdelivery.driver.feature.repository.entity.Location;

public interface LocationService {

    Mono<Location> save(final Location location);

    Flux<Location> findByDriverAndLocationNear(final String driverId, final Point point, final Distance maxDistance);
}
