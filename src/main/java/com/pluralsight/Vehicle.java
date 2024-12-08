package com.pluralsight;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType; // e.g., car, truck, etc.
    private String color;
    private int odometer;
    private double price;

    // Constructor
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;

    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    public String toCSVFormat() {
        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                vin, year, make, model, vehicleType, color, odometer, price);
    }
}