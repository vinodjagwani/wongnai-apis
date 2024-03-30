package th.wongnai.fdelivery.driver.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DriverLocationQueryResponse(@JsonProperty("driverId") String driverId,
                                          @JsonProperty("latitude") double latitude,
                                          @JsonProperty("longitude") double longitude) {
}
