package th.wongnai.fdelivery.order.feature.web.facade;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import th.wongnai.fdelivery.order.client.driver.DriverFeignClient;
import th.wongnai.fdelivery.order.exception.BusinessServiceException;
import th.wongnai.fdelivery.order.exception.dto.ErrorCodeEnum;
import th.wongnai.fdelivery.order.feature.repository.entity.Order;
import th.wongnai.fdelivery.order.feature.service.OrderService;
import th.wongnai.fdelivery.order.feature.web.dto.OrderCreateRequest;
import th.wongnai.fdelivery.order.feature.web.dto.OrderCreateResponse;
import th.wongnai.fdelivery.order.feature.web.dto.OrderStatusUpdateRequest;
import th.wongnai.fdelivery.order.feature.web.dto.OrderStatusUpdateResponse;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderCreateFacade {

    OrderService orderService;

    DriverFeignClient driverFeignClient;


    public Mono<OrderCreateResponse> createOrder(final OrderCreateRequest request, final ServerWebExchange exchange) {
        final Order order = createOrderRequest(request);
        final String token = Optional.ofNullable(exchange.getRequest().getHeaders().get("Authorization"))
                .map(header -> header.stream().findFirst().orElse("")).orElse("");
        return driverFeignClient.getAvailableDriver(token)
                .map(availableDriver -> {
                    final String driverId = availableDriver.getOrDefault("driverId", "").toString();
                    order.setDriverId(driverId);
                    orderService.createOrder(order).subscribe(o -> {
                        driverFeignClient.updateDriverStatus(token, Map.of("driverId", driverId, "driverStatus", false))
                                .subscribe(u -> log.debug("Driver status has been updated with driverId [{}]", driverId));
                        log.debug("Order has been created with orderId [{}] and driverId [{}]", order.getOrderId(), order.getOrderId());
                    });
                    return new OrderCreateResponse(order.getOrderId(), order.getDriverId(), order.getOrderStatus());
                })
                .switchIfEmpty(Mono.error(new BusinessServiceException(ErrorCodeEnum.INVALID_DATA, "No driver available")));
    }

    public Mono<OrderStatusUpdateResponse> updateOrderStatus(final OrderStatusUpdateRequest request) {
        return orderService.findOne(request.orderId()).map(order -> {
                    Optional.of(request.orderStatus()).filter("Completed"::equalsIgnoreCase)
                            .ifPresent(p -> {
                                order.setOrderCompleteAt(LocalDateTime.now());
                                order.setOrderStatus(request.orderStatus());
                            });
                    order.setOrderStatus(request.orderStatus());
                    return order;
                }).map(orderService::updateOrderStatus)
                .flatMap(updatedOrder -> updatedOrder
                        .map(response -> new OrderStatusUpdateResponse(response.getOrderId())));
    }

    private Order createOrderRequest(final OrderCreateRequest request) {
        final Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setPaymentId(request.paymentId());
        order.setOrderStatus("Processing");
        order.setOrderedAt(LocalDateTime.now());
        return order;
    }
}
