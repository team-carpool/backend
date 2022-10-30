package com.carpool.backend.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.carpool.constants.UserGender;
import com.carpool.constants.UserRole;

@Entity
@Table(name = "USER_TABLE")
public class UserModel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Id
    @Column(name = "EMAIL_ID", nullable = false)
    private String emailId;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PHONE_NUMBER")
    private int phone;
    
    private String country;

    private boolean hasVehicle;
    
    @OneToMany(mappedBy = "vehicleOwner")
    private List<VehicleModel> vehicleList;

    @Column(name = "GENDER", nullable = true)
    private UserGender gender;

    private String currentLocation;

    @Column(name = "USER_ROLE", nullable = false)
    private UserRole userRole;
    
    private boolean isLoggedIn;
    
    private boolean isDeleted;
    
    private LocalDate createdOn;
    
    private LocalDate updatedOn;

    // constructors
    
    protected UserModel() {
        super();
    }

    public UserModel(String firstName, String lastName, String email, String password, LocalDate createdOn) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = email;
        this.password = password;
        this.createdOn = createdOn;
    }

    // Getter and Setters for all the fields

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return emailId;
    }

    public void setEmail(String email) {
        this.emailId = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isHasVehicle() {
        return hasVehicle;
    }

    public void setHasVehicle(boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }

    public List<VehicleModel> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<VehicleModel> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public UserGender getGender() {
        return gender;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public UserRole getRole() {
        return userRole;
    }

    public void setRole(UserRole role) {
        this.userRole = role;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    
    public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return String.format(
                "UserModel [userId=%d, firstName=%s, lastName=%s, email=%s,  phone=%d, country=%s, hasVehicle=%b, rold=%s, isLoggedIn=%b, createdOn=%s, updatedOn=%s]",
                userId, firstName, lastName, emailId, phone, country, hasVehicle, userRole, isLoggedIn, createdOn, updatedOn);
    }

}
