package th.wongnai.fdelivery.driver.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DriverDetailResponse(@JsonProperty("driverId") String driverId,
                                   @JsonProperty("firstName") String firstName,
                                   @JsonProperty("lastName") String lastName) {
}
