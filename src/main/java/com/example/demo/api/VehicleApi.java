package com.example.demo.api;

        import com.example.demo.entities.Vehicle;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.stereotype.Component;

@Component
public interface VehicleApi extends MongoRepository<Vehicle, String> {

}
