package th.wongnai.fdelivery.driver.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record DriverCreateRequest(@NotBlank(message = "firstName must not be null or empty")
                                  @JsonProperty("firstName") String firstName,
                                  @NotBlank(message = "lastName must not be null or empty")
                                  @JsonProperty("lastName") String lastName) {
}
