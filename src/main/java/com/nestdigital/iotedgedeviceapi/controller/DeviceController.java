package com.nestdigital.iotedgedeviceapi.controller;

import com.nestdigital.iotedgedeviceapi.model.Device;
//import com.example.demo.repository.ReactiveMongoRepository;
import com.nestdigital.iotedgedeviceapi.repository.ReactiveMongoRepository;
//import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class DeviceController {
    private final ReactiveMongoRepository reactiveMongoRepository;
    public DeviceController(ReactiveMongoRepository reactiveMongoRepository){
        this.reactiveMongoRepository=reactiveMongoRepository;
    }
    @GetMapping("/device")
    public Flux<Device> getDevice(){
        return reactiveMongoRepository.findAll();
    }
    @PostMapping("/device")
    public Mono<Device> addDevice(@RequestBody Device device){
        return reactiveMongoRepository.save(device);
    }

    @DeleteMapping("/device/{id}")
    public Mono<Void> deleteDevice(@PathVariable String id) {
        return reactiveMongoRepository.deleteById(id);
    }
}
