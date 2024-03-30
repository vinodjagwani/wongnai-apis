package th.wongnai.fdelivery.order.client.driver;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@ReactiveFeignClient(url = "${client.driver.get-all-drivers}", name = "client"

)
public interface DriverFeignClient {

    @GetMapping(value = "/api/availableDriver", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<Map<String, Object>> getAvailableDriver(@RequestHeader("Authorization") final String authorization);

    @PostMapping(value = "/api/updateDriverStatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<Map<String, Object>> updateDriverStatus(@RequestHeader("Authorization") final String authorization, final Map<String, Object> request);
}
