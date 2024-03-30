package th.wongnai.fdelivery.order.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record OrderStatusUpdateRequest(@NotBlank(message = "orderId must not be null or empty")
                                       @JsonProperty("orderId") String orderId,
                                       @NotBlank(message = "driverId must not be null or empty")
                                       @JsonProperty("driverId") String driverId,
                                       @NotBlank(message = "orderStatus must not be null or empty")
                                       @JsonProperty("orderStatus") String orderStatus) {
}
