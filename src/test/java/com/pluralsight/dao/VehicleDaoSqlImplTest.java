package com.pluralsight.dao;

import com.pluralsight.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleDaoSqlImplTest {
     VehicleDao dao;
     String url = "jdbc:mysql://localhost:3306/test_dealership";
     String userName = "root";
     String password = "yearup";
     BasicDataSource dataSource = new BasicDataSource();

    @BeforeEach
     void setUp(){
    dataSource.setUrl(url);
    dataSource.setUsername(userName);
    dataSource.setPassword(password);

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
        List<Vehicle> vehicleList = dao.findVehiclesByVin(888234);
        int expected = 10;
        assertEquals(expected, vehicleList.size());
    }

    @Test
    void findVehiclesByYear() {
        List<Vehicle> vehicleList = dao.findVehiclesByYear(2016, 2024);
        int expected = 10;
        assertEquals(expected, vehicleList.size());

    }

    @Test
    void findVehiclesByMake() {
        List<Vehicle> vehicleList = dao.findVehiclesByMake();
        int expected = 10;
        assertEquals(expected, vehicleList.size());
    }

    @Test
    void findVehiclesByModel() {
        List<Vehicle> vehicleList = dao.findVehiclesByModel();
        int expected = 10;
        assertEquals(expected, vehicleList.size());
    }

    @Test
    void findVehiclesByType() {
        List<Vehicle> vehicleList = dao.findVehiclesByType();
        int expected = 10;
        assertEquals(expected, vehicleList.size());
    }

    @Test
    void findVehiclesByColor() {
        List<Vehicle> vehicleList = dao.findVehiclesByColor();
        int expected = 10;
        assertEquals(expected, vehicleList.size());
    }

    @Test
    void findVehiclesByOdometer() {
        List<Vehicle> vehicleList = dao.findVehiclesByOdometer(, );
        int expected = 10;
        assertEquals(expected, vehicleList.size());
    }

    @Test
    void findVehiclesByPrice() {
        List<Vehicle> vehicleList = dao.findVehiclesByPrice(, );
        int expected = 10;
        assertEquals(expected, vehicleList.size());
    }
}