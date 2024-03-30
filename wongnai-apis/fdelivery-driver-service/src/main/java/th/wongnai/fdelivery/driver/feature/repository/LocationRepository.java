package th.wongnai.fdelivery.driver.feature.repository;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import th.wongnai.fdelivery.driver.feature.repository.entity.Location;

public interface LocationRepository extends ReactiveMongoRepository<Location, String> {

    Flux<Location> findByDriverIdAndLocationNear(final String driverId, final Point point, final Distance maxDistance);

}
