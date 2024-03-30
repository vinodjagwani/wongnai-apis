package th.wongnai.fdelivery.driver.feature.repository.entity;

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
@Document(collection = "driver")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver {

    @Id
    String driverId;

    @Field("firstName")
    String firstName;

    @Field("lastName")
    String lastName;

    @Field("driverStatus")
    boolean driverStatus;

    @Field("createAt")
    LocalDateTime createAt;

}
