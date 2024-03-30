package th.wongnai.fdelivery.driver.feature.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import th.wongnai.fdelivery.driver.feature.repository.entity.Driver;

public interface DriverService {

    Mono<Driver> findOne(final String id);

    Mono<Driver> save(final Driver driver);

    Flux<Driver> findAllByDriverStatus(final boolean driverStatus);

}
