package th.wongnai.fdelivery.driver.feature.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import th.wongnai.fdelivery.driver.feature.repository.DriverRepository;
import th.wongnai.fdelivery.driver.feature.repository.entity.Driver;
import th.wongnai.fdelivery.driver.feature.service.DriverService;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DriverServiceImpl implements DriverService {

    DriverRepository driverRepository;

    @Override
    public Flux<Driver> findAllByDriverStatus(final boolean driverStatus) {
        return driverRepository.findAllByDriverStatus(driverStatus);
    }

    @Override
    public Mono<Driver> findOne(final String id) {
        return driverRepository.findById(id);
    }

    @Override
    public Mono<Driver> save(final Driver driver) {
        return driverRepository.save(driver);
    }
}
