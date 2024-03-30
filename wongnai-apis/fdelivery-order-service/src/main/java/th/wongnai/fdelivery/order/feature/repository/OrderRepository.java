package th.wongnai.fdelivery.order.feature.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import th.wongnai.fdelivery.order.feature.repository.entity.Order;

import java.util.List;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

    Flux<Order> findByDriverIdInAndOrderStatus(final List<String> driverIds, final String orderStatus);
}
