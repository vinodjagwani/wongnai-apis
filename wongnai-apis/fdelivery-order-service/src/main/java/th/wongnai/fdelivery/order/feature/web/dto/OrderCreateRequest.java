package th.wongnai.fdelivery.order.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record OrderCreateRequest(@NotBlank(message = "driverId must not be null or empty")
                                 @JsonProperty("driverId") String driverId,
                                 @NotBlank(message = "paymentId must not be null or empty")
                                 @JsonProperty("paymentId") String paymentId,
                                 @NotBlank(message = "orderStatus must not be null or empty")
                                 @JsonProperty("orderStatus") String orderStatus) {
}
