package th.wongnai.fdelivery.driver.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DriverCreateResponse(@JsonProperty("driverId") String driverId) {
}
