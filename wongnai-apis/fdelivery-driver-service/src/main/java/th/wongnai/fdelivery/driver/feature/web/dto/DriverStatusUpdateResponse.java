package th.wongnai.fdelivery.driver.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DriverStatusUpdateResponse(@JsonProperty("orderId") String orderId) {
}
