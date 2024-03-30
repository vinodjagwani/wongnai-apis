package th.wongnai.fdelivery.order.feature.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import th.wongnai.fdelivery.order.feature.repository.OrderRepository;
import th.wongnai.fdelivery.order.feature.repository.entity.Order;
import th.wongnai.fdelivery.order.feature.service.OrderService;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    @Override
    public Mono<Order> findOne(final String id) {
        return orderRepository.findById(id);
    }

    @Override
    public Mono<Order> createOrder(final Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Mono<Order> updateOrderStatus(final Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Flux<Order> findByDriverIdInAndOrderStatus(final List<String> driverIds, final String orderStatus) {
        return orderRepository.findByDriverIdInAndOrderStatus(driverIds, orderStatus);
    }
}
