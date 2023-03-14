package com.nestdigital.iotedgedeviceapi.repository;

import com.nestdigital.iotedgedeviceapi.model.Device;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveMongoRepository extends ReactiveCrudRepository<Device,String> {

}
