package com.truphone.technicalchallenge.device;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DeviceRepository {

    private Map<String, Device> deviceMap;

    public DeviceRepository() {
        this.deviceMap = new HashMap<>();
        this.init();
    }

    // this private method will add 10 devices to the Map to start the application with devices inserted
    private void init () {
        Device iPhoneXR = new Device("iPhone XR", "Apple");
        Device iPhoneX = new Device("iPhone X", "Apple");
        Device iPhoneXS = new Device("iPhone XS", "Apple");
        Device iPhoneXSMax = new Device("iPhone XS Max", "Apple");
        Device samsungS20 = new Device("Samsung S20", "Samsung");
        Device huaweiP40= new Device("Huawei P40", "Huawei");

        deviceMap.put(iPhoneXR.getId(),iPhoneXR);
        deviceMap.put(iPhoneX.getId(),iPhoneX);
        deviceMap.put(iPhoneXS.getId(),iPhoneXS);
        deviceMap.put(iPhoneXSMax.getId(),iPhoneXSMax);
        deviceMap.put(samsungS20.getId(),samsungS20);
        deviceMap.put(huaweiP40.getId(),huaweiP40);
    }

    // Add device to the repository
    public void addDevice(Device newDevice) {
        this.deviceMap.put(newDevice.getId(), newDevice);
    }

    // Get device by identifier
    public Device getDeviceById(String id) {
        return this.deviceMap.get(id);
    }

    // Get all devices found on the repository
    public List<Device> getDevices () {

//       for(Device device: deviceMap.values()) {
//           deviceList.add(device);
//       }
//        return deviceList;

        return new ArrayList<>(deviceMap.values());
    }

    // Search device by brand - returns a list of devices by brand
    public List<Device> getDevicesByBrand(String brand) {
        List<Device> deviceList = new ArrayList<>();

        for (Device device: deviceMap.values()) {
            if(device.getBrand().toLowerCase().equals(brand.toLowerCase()))
                deviceList.add(device);
        }
        return deviceList;
    }

    // Delete device by Id
    public void deleteDeviceById(String id) {
        this.deviceMap.remove(id);
    }
}
