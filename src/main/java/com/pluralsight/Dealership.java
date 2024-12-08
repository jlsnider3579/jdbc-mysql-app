package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    private int id;

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // Constructor
    public Dealership(String name, String address, String phone, int id) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.id = id;
        this.inventory = new ArrayList<>();
    }

    // Stub methods
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= min && vehicle.getPrice() <= max)
                .toList();
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return inventory.stream().filter(
                vehicle -> vehicle.getMake().trim().equalsIgnoreCase(make)
                        && vehicle.getModel().trim().equalsIgnoreCase(model)).toList();
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max)
                .toList();
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .toList();
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max)
                .toList();
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                .toList();
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        // Intentionally left empty for now
    }
}
