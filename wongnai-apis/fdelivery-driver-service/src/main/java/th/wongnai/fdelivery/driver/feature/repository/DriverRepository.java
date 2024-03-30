package th.wongnai.fdelivery.driver.feature.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import th.wongnai.fdelivery.driver.feature.repository.entity.Driver;

public interface DriverRepository extends ReactiveMongoRepository<Driver, String> {

    @Query("{driverStatus : ?0}")
    Flux<Driver> findAllByDriverStatus(final boolean driverStatus);
}
