package th.wongnai.fdelivery.driver.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record DriverLocationQueryRequest(@NotBlank(message = "driverId must not be null or empty")
                                         @JsonProperty("driverId") String driverId,
                                         @NotBlank(message = "latitude must not be null or empty")
                                         @JsonProperty("latitude") double latitude,
                                         @NotBlank(message = "longitude must not be null or empty")
                                         @JsonProperty("longitude") double longitude) {
}
