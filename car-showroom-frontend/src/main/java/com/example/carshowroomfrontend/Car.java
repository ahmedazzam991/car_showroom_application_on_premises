package com.example.carshowroomfrontend;

public class Car {
    private Long id;
    private String make;
    private String model;
    private double price;

    // Constructors
    public Car() {
    }

    public Car(Long id, String make, String model, double price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

