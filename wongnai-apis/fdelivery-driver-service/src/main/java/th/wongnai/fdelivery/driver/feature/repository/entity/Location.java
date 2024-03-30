package th.wongnai.fdelivery.driver.feature.repository.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document(collection = "locations")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Location {

    @Id
    String id;

    @Field("driverId")
    String driverId;

    @GeoSpatialIndexed
    double[] location;

}
