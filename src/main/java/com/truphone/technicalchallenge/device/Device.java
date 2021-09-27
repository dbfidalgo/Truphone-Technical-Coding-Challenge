package com.truphone.technicalchallenge.device;

import java.time.LocalDateTime;
import java.util.UUID;


public class Device {

    private String id;
    private String name;
    private String brand;
    private LocalDateTime creationTime;

    public Device(String name, String brand) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.brand = brand;
        this.creationTime = LocalDateTime.now();
    }

    // GETTERS

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    // SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // toString

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
