package com.capool.backend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VehicleModel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "VEHICLE_TYPE", nullable = false)
    private String vehicleType;

    @Column(name = "VEHICLE_BRAND", nullable = false)
    private String vehicleBrand;

    @Id
    @Column(name = "VEHICLE_NUMBER", nullable = false)
    private String vehicleNumber;

    @Column(name = "VEHICLE_MODEL", nullable = false)
    private String vehicleModel;

    @Column(name = "VEHICLE_COLOR", nullable = true)
    private String vehicleColor;

    @Column(name = "VEHICLE_CAPACITY", nullable = false)
    private String vehicleCapacity;

    @Column(name = "VEHICLE_OWNER", nullable = false)
    private String vehicleOwner;

    public VehicleModel() {
        super();
    }

    public VehicleModel(String vehicleType, String vehicleNumber, String vehicleModel, String vehicleColor,
            String vehicleCapacity, String vehicleOwner) {
        super();
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
        this.vehicleColor = vehicleColor;
        this.vehicleCapacity = vehicleCapacity;
        this.vehicleOwner = vehicleOwner;
    }

    // Geter and Setters for all the fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(String vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    @Override
    public String toString() {
        return String.format(
                "VehicleModel [ id=%d, vehicleType=%s, vehicleNumber=%s, vehicleModel=%s, vehicleColor=%s, vehicleCapacity=%s, vehicleOwner=%s]",
                id, vehicleType, vehicleNumber, vehicleModel, vehicleColor, vehicleCapacity, vehicleOwner);

    }

}
