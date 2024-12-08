package com.pluralsight.dao;

import com.pluralsight.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDaoImpl implements VehicleDao {
    private String url;
    private String userName;
    private String password;

    public VehicleDaoImpl(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;

    }
    @Override
    public List<Vehicle> findAllVehicles(){
        List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
        String query = "SELECT * FROM vehicle"; // SQL query to return all vehicles

        // Established a connection to the database
        try(Connection connection = DatabaseConfig.getConnection(url, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Passed SQL query
            ResultSet resultSet = preparedStatement.executeQuery(); // Told SQL to execute the query

            // Iterates through list until the end
            while (resultSet.next()){
                vehicleList.add(createVehicle(resultSet)); // added a vehicle to the local variable list

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList; // Return the vehicle list
    }

    @Override
    public List<Vehicle> findVehiclesByVin() {
        List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
        String query = "SELECT vin FROM vehicles"; // SQL query to return vehicles with the vin

        // Establish a connection to the database
        try(Connection connection = DatabaseConfig.getConnection(url, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
            ResultSet resultSet = preparedStatement.executeQuery(); // Told SQL to execute the query

            // Iterates through list until done
            while (resultSet.next()){
                vehicleList.add(createVehicle(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList; // Return vehicle list
    }

    @Override
    public List<Vehicle> findVehiclesByYear() {
        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT year FROM vehicles"; // SQL query to return vehicles with the year

        // Establish a connection to the database
        try(Connection connection = DatabaseConfig.getConnection(url, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
            ResultSet resultSet = preparedStatement.executeQuery(); // Told SQL to execute the query

            // Iterates through list until done
            while (resultSet.next()){
                vehicleList.add(createVehicle(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findVehiclesByMake() {
        List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
        String query = "SELECT make FROM vehicles"; // SQL query to return vehicles with the make

        // Establish a connection to the database
        try(Connection connection = DatabaseConfig.getConnection(url, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
            ResultSet resultSet = preparedStatement.executeQuery(); // Told SQL to execute the query

            // Iterates through list until done
            while (resultSet.next()){
                vehicleList.add(createVehicle(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findVehiclesByModel() {
        List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
        String query = "SELECT model FROM vehicles"; // SQL query to return vehicles with the model

        // Establish a connection to the database
        try(Connection connection = DatabaseConfig.getConnection(url, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
            ResultSet resultSet = preparedStatement.executeQuery(); // Told SQL to execute the query

            // Iterates through list until done
            while (resultSet.next()){
                vehicleList.add(createVehicle(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findVehiclesByType() {
        List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
        String query = "SELECT type FROM vehicles"; // SQL query to return vehicles with the type

        // Establish a connection to the database
        try(Connection connection = DatabaseConfig.getConnection(url, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
            ResultSet resultSet = preparedStatement.executeQuery(); // Told SQL to execute the query

            // Iterates through list until done
            while (resultSet.next()){
                vehicleList.add(createVehicle(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findVehiclesByColor() {
        List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
        String query = "SELECT color FROM vehicles"; // SQL query to return vehicles with the color

        // Establish a connection to the database
        try(Connection connection = DatabaseConfig.getConnection(url, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
            ResultSet resultSet = preparedStatement.executeQuery(); // Told SQL to execute the query

            // Iterates through list until done
            while (resultSet.next()){
                vehicleList.add(createVehicle(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findVehiclesByOdometer() {
        List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
        String query = "SELECT odometer FROM vehicles"; // SQL query to return vehicles with the odometer

        // Establish a connection to the database
        try(Connection connection = DatabaseConfig.getConnection(url, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
            ResultSet resultSet = preparedStatement.executeQuery(); // Told SQL to execute the query

            // Iterates through list until done
            while (resultSet.next()){
                vehicleList.add(createVehicle(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findVehiclesByPrice() {
        List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
        String query = "SELECT price FROM vehicles"; // SQL query to return vehicles with the price

        // Establish a connection to the database
        try(Connection connection = DatabaseConfig.getConnection(url, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
            ResultSet resultSet = preparedStatement.executeQuery(); // Told SQL to execute the query

            // Iterates through list until done
            while (resultSet.next()){
                vehicleList.add(createVehicle(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }


    private Vehicle createVehicle(ResultSet resultSet) throws SQLException{
        return new Vehicle(
                resultSet.getInt("vin"),
                resultSet.getInt("year"),
                resultSet.getString("make"),
                resultSet.getString("model"),
                resultSet.getString("vehicle_type"),
                resultSet.getString("color"),
                resultSet.getInt("odometer"),
                resultSet.getDouble("price")
                ); // Created a new vehicle using the data from the sql database

    }
}
