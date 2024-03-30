package th.wongnai.fdelivery.driver.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record DriverLocationCreateRequest(@NotBlank(message = "driverId must not be null or empty")
                                          @JsonProperty("driverId") String driverId,
                                          @NotNull(message = "latitude must not be null or empty")
                                          @JsonProperty("latitude") double latitude,
                                          @NotNull(message = "longitude must not be null or empty")
                                          @JsonProperty("longitude") double longitude) {
}
