package com.truphone.technicalchallenge.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API LAYER
 *
 *    1. Add device
 *    2. Get device by identifier
 *    3. List all devices
 *    4. Update device (full and partial)
 *    5. Delete a device
 *    6. Search device by brand
 */

@RestController
@RequestMapping(path = "tech-challenge/v1/devices")
public class DeviceController {
    // this API layer have dependency from Service Layer
    // called dependency injection

    // reference to deviceService
    private final DeviceService deviceService;

    // the deviceService should be instanciated and injected (Autowired) into the constructor below
    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    // 1. Add device
    @PostMapping
    public ResponseEntity<String> createDevice (@RequestBody Device newDevice) {
        try {
            return ResponseEntity.ok(deviceService.createDevice(newDevice));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // 2. Get device by identifier
    @GetMapping(value="/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(deviceService.getDeviceById(id));
        } catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 3. List all devices
    // 6. Search device by brand (query parameter)
    @GetMapping
    public ResponseEntity<List<Device>> getDevices(@RequestParam (value = "brand", defaultValue = "") String brand) {
        if (brand.isEmpty())
            return ResponseEntity.ok(deviceService.getDevices());

        return ResponseEntity.ok(deviceService.getDevicesByBrand(brand));
    }

    // 4. Update device (full and partial)
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateDevice (@PathVariable ("id") String id, @RequestParam(required = false) String name, @RequestParam(required = false) String brand) {
        try {
            deviceService.updateDevice (id, name, brand);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 5. Delete a device
    @DeleteMapping (value="/{id}")
    public ResponseEntity<String> deleteDevice (@PathVariable String id) {
        try {
            deviceService.deleteDeviceById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IllegalArgumentException exception){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
