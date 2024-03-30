package th.wongnai.fdelivery.order.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderCreateResponse(@JsonProperty("orderId") String orderId,
                                  @JsonProperty("driverId") String driverId,
                                  @JsonProperty("orderStatus") String orderStatus) {
}
