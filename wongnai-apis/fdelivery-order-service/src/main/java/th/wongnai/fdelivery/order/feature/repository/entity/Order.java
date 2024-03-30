package th.wongnai.fdelivery.order.feature.repository.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Setter
@Getter
@Document(collection = "order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    String orderId;

    @Field("driverId")
    String driverId;

    @Field("orderStatus")
    String orderStatus;

    @Field("paymentId")
    String paymentId;

    @Field("orderedAt")
    LocalDateTime orderedAt;

    @Field("orderCompleteAt")
    LocalDateTime orderCompleteAt;

}
