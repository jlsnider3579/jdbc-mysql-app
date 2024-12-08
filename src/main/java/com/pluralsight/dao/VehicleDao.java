package com.pluralsight.dao;

import com.pluralsight.Vehicle;

import java.util.List;

public interface VehicleDao {
    List<Vehicle> findAllVehicles();
    List<Vehicle> findVehiclesByVin();
    List<Vehicle> findVehiclesByYear();
    List<Vehicle> findVehiclesByMake();
    List<Vehicle> findVehiclesByModel();
    List<Vehicle> findVehiclesByType();
    List<Vehicle> findVehiclesByColor();
    List<Vehicle> findVehiclesByOdometer();
    List<Vehicle> findVehiclesByPrice();
}
