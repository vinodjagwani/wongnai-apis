package th.wongnai.fdelivery.order.feature.web.rest;

import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import th.wongnai.fdelivery.order.feature.web.dto.OrderCreateRequest;
import th.wongnai.fdelivery.order.feature.web.dto.OrderCreateResponse;
import th.wongnai.fdelivery.order.feature.web.dto.OrderStatusUpdateRequest;
import th.wongnai.fdelivery.order.feature.web.dto.OrderStatusUpdateResponse;
import th.wongnai.fdelivery.order.feature.web.facade.OrderCreateFacade;

import javax.validation.Valid;

@RestController
@Api(tags = "Driver")
@RequestMapping("/api")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderController {

    OrderCreateFacade orderCreateFacade;

    @PostMapping(value = "/createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<OrderCreateResponse> createOrder(@Valid @RequestBody OrderCreateRequest request, final ServerWebExchange exchange) {
        return orderCreateFacade.createOrder(request, exchange);
    }

    @PostMapping(value = "/updateOrderStatus", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<OrderStatusUpdateResponse> updateOrderStatus(@Valid @RequestBody OrderStatusUpdateRequest request) {
        return orderCreateFacade.updateOrderStatus(request);
    }
}
