package com.klef.fsad.exam;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private int id;

    @Column(name = "restaurant_name", nullable = false)
    private String name;

    @Column(name = "established_date")
    private LocalDate date;

    @Column(name = "status")
    private String status;

    @Column(name = "cuisine_type")
    private String cuisineType;

    @Column(name = "location")
    private String location;

    @Column(name = "contact_number")
    private String contactNumber;

    public Restaurant() {}

    public Restaurant(String name, LocalDate date, String status, String cuisineType, String location, String contactNumber) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.cuisineType = cuisineType;
        this.location = location;
        this.contactNumber = contactNumber;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCuisineType() { return cuisineType; }
    public void setCuisineType(String cuisineType) { this.cuisineType = cuisineType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", name=" + name + ", date=" + date +
               ", status=" + status + ", cuisineType=" + cuisineType +
               ", location=" + location + ", contactNumber=" + contactNumber + "]";
    }
}
