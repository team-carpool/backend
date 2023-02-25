package com.carpool.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE_TABLE")
public class VehicleModel {
	
	@Id
    @Column(name = "VEHICLE_NUMBER", nullable = false)
    private String vehicleNumber;

    @Column(name = "VEHICLE_TYPE", nullable = false)
    private String vehicleType;

    @Column(name = "VEHICLE_BRAND", nullable = false)
    private String vehicleBrand;

    @Column(name = "VEHICLE_MODEL", nullable = true)
    private String vehicleModel;

    @Column(name = "VEHICLE_COLOR", nullable = true)
    private String vehicleColor;

    @Column(name = "VEHICLE_CAPACITY", nullable = false)
    private short vehicleCapacity;

    @ManyToOne
    @JoinColumn(name = "VEHICLE_OWNER")  // FOREIGN KEY COLUMN NAME
    private UserModel vehicleOwner;

    // Constructors
    
    protected VehicleModel() {
        super();
    }

    public VehicleModel(String vehicleType, String vehicleNumber, String vehicleModel, String vehicleColor,
            short vehicleCapacity, UserModel vehicleOwner) {
        super();
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
        this.vehicleColor = vehicleColor;
        this.vehicleCapacity = vehicleCapacity;
        this.vehicleOwner = vehicleOwner;
    }

    // Getter and Setters for all the fields

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

    public short getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(short vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public UserModel getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(UserModel vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    @Override
    public String toString() {
        return String.format(
                "VehicleModel [vehicleType=%s, vehicleNumber=%s, vehicleModel=%s, vehicleColor=%s, vehicleCapacity=%d, vehicleOwner=%s]",
                vehicleType, vehicleNumber, vehicleModel, vehicleColor, vehicleCapacity, vehicleOwner);

    }

}
