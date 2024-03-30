package th.wongnai.fdelivery.driver.feature.web.rest;

import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverCreateRequest;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverCreateResponse;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverDetailResponse;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverLocationCreateRequest;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverLocationCreateResponse;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverLocationQueryRequest;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverLocationQueryResponse;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverStatusUpdateRequest;
import th.wongnai.fdelivery.driver.feature.web.dto.DriverStatusUpdateResponse;
import th.wongnai.fdelivery.driver.feature.web.facade.DriverCreateFacade;

import javax.validation.Valid;

@RestController
@Api(tags = "Driver")
@RequestMapping("/api")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DriverController {

    DriverCreateFacade driverCreateFacade;

    @PostMapping(value = "/createDriver", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DriverCreateResponse> createOrder(@Valid @RequestBody final DriverCreateRequest request) {
        return driverCreateFacade.createDriver(request);
    }

    @PostMapping(value = "/updateDriverStatus", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DriverStatusUpdateResponse> updateOrderStatus(@Valid @RequestBody DriverStatusUpdateRequest request) {
        return driverCreateFacade.updateDriverStatus(request);
    }

    @GetMapping(value = "/availableDriver", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DriverDetailResponse> getAvailableDriver() {
        return driverCreateFacade.getAvailableDriver();
    }


    @PostMapping(value = "/sendDriverLocation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DriverLocationCreateResponse> createDriverGeoLocation(@Valid @RequestBody final DriverLocationCreateRequest request) {
        return driverCreateFacade.createDriverLocation(request);
    }

    @PostMapping(value = "/driverLocation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flux<DriverLocationQueryResponse> findDriverLocation(@Valid @RequestBody final DriverLocationQueryRequest request) {
        return driverCreateFacade.findDriverLocation(request);
    }
}
