package th.wongnai.fdelivery.order.feature.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderStatusUpdateResponse(@JsonProperty("orderId") String orderId) {
}
