package th.wongnai.fdelivery.driver.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record DriverStatusUpdateRequest(@NotBlank(message = "driverId must not be null or empty")
                                        @JsonProperty("driverId") String driverId,
                                        @NotBlank(message = "driverStatus must not be null or empty")
                                        @JsonProperty("driverStatus") boolean driverStatus) {
}
