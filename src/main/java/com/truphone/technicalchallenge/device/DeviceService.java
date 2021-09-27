package com.truphone.technicalchallenge.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * SERVICE LAYER
 */

// this class needs to be instaciated ie needs to be a Spring Bean
// to do that, we should use @Service

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    // 1. Add device
    public String createDevice(Device newDevice) {
        if (newDevice.getName().isEmpty() || newDevice.getBrand().isEmpty())
            throw new IllegalArgumentException("Name and Brand cannot be null!");

        this.deviceRepository.addDevice(newDevice);
        return newDevice.getId();
    }

    // 2. Get device by identifier (id)
    public Device getDeviceById(String id) {
        Device device = this.deviceRepository.getDeviceById(id);

        if(Objects.isNull(device))
            throw new IllegalArgumentException("ID not found!");

        return device;
    }

    // 3. List all devices
    public List<Device> getDevices() {
        return this.deviceRepository.getDevices();
    }

    // 4. Update device (full and partial)
    public void updateDevice(String id, String name, String brand) {
        Device device = deviceRepository.getDeviceById(id);

        if (Objects.isNull(device))
            throw new IllegalArgumentException("Device with ID: " + id + "does not exist!");

        // to guarantee that the name is not null and the name is not the same
        if (name != null && name.length() > 0 && !Objects.equals(device.getName(), name)) {
            device.setName(name);
        }

        // to guarantee that the name is not null and the name is not the same
        if (brand != null && brand.length() > 0 && !Objects.equals(device.getBrand(), brand)) {
            device.setBrand(brand);
        }
    }

    // 5. Delete a device
    public void deleteDeviceById(String id) {
        Device device = this.deviceRepository.getDeviceById(id);
        if(Objects.isNull(device))
            throw new IllegalArgumentException("ID not found!");

        this.deviceRepository.deleteDeviceById(id);
    }

    //6. Search device by brand
    public List<Device> getDevicesByBrand(String brand) {
        return this.deviceRepository.getDevicesByBrand(brand);
    }

}
