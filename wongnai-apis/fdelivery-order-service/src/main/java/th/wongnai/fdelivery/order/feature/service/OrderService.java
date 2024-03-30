package th.wongnai.fdelivery.order.feature.service;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import th.wongnai.fdelivery.order.feature.repository.entity.Order;

import java.util.List;

public interface OrderService {

    Mono<Order> findOne(final String id);

    Mono<Order> createOrder(final Order order);

    Mono<Order> updateOrderStatus(final Order order);

    Flux<Order> findByDriverIdInAndOrderStatus(final List<String> driverIds, final String orderStatus);
}
