package com.pluralsight.dao;

import com.pluralsight.Vehicle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleDaoImplTest {
    static VehicleDao dao;
    static String url = "jdbc:mysql://localhost:3306/test_dealership";
    static String userName = "root";
    static String password = "yearup";

    @BeforeAll
    static void setup(){
        dao = new VehicleDaoImpl(url, userName, password);
    }

    @Test
    void findAllVehicles() {
    List<Vehicle> vehicleList = dao.findAllVehicles();
    int expected = 10;
    assertEquals(expected, vehicleList.size());

    }
// TODO CHANGE THE METHOD ON DAO TO MATCH THE TEST
    @Test
    void findVehiclesByVin() {
        List<Vehicle> vehicleList = dao.findAllVehicles();
    }

    @Test
    void findVehiclesByYear() {
        List<Vehicle> vehicleList = dao.findAllVehicles();

    }

    @Test
    void findVehiclesByMake() {
        List<Vehicle> vehicleList = dao.findAllVehicles();
    }

    @Test
    void findVehiclesByModel() {
        List<Vehicle> vehicleList = dao.findAllVehicles();
    }

    @Test
    void findVehiclesByType() {
        List<Vehicle> vehicleList = dao.findAllVehicles();
    }

    @Test
    void findVehiclesByColor() {
        List<Vehicle> vehicleList = dao.findAllVehicles();
    }

    @Test
    void findVehiclesByOdometer() {
        List<Vehicle> vehicleList = dao.findAllVehicles();
    }

    @Test
    void findVehiclesByPrice() {
        List<Vehicle> vehicleList = dao.findAllVehicles();
    }
}