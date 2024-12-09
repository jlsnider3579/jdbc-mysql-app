package com.pluralsight.dao;

import com.pluralsight.Vehicle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class VehicleDaoImpl implements VehicleDao {
        private DataSource dataSource;
        public VehicleDaoImpl(DataSource dataSource) {
            this.dataSource = dataSource;

        }
        @Override
        public List<Vehicle> findAllVehicles(){
            List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
            String query = "SELECT * FROM vehicle"; // SQL query to return all vehicles

            // Established a connection to the database
            try(Connection connection = dataSource.getConnection()) {
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
        public List<Vehicle> findVehiclesByVin(int userVin) {
            List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
            String query = "SELECT * FROM vehicle WHERE vin = ?"; // SQL query to return vehicles with the vin

            // Establish a connection to the database
            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
                preparedStatement.setInt(1, userVin);
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
        public List<Vehicle> findVehiclesByYear(int min, int max) {
            List<Vehicle> vehicleList = new ArrayList<>();
            String query = "SELECT * FROM vehicle WHERE year BETWEEN ? AND ?"; // SQL query to return vehicles with the year

            // Establish a connection to the database
            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
                preparedStatement.setInt(1, min);
                preparedStatement.setInt(2, max);
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
        public List<Vehicle> findVehicleByMakeModel(String userMake, String userModel) {
            List<Vehicle> vehicleList = new ArrayList<>();
            String query = "SELECT * FROM vehicle WHERE make = ? AND model = ?";

            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
                preparedStatement.setString(1, userMake);
                preparedStatement.setString(2, userModel);
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

        //@Override
        public List<Vehicle> findVehiclesByMake(String userMake) {
            List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
            String query = "SELECT * FROM vehicle WHERE make = ?"; // SQL query to return vehicles with the make

            // Establish a connection to the database
            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
                preparedStatement.setString(1, userMake);
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

        //@Override
        public List<Vehicle> findVehiclesByModel(String userModel) {
            List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
            String query = "SELECT * FROM vehicle WHERE model = ?"; // SQL query to return vehicles with the model

            // Establish a connection to the database
            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
                preparedStatement.setString(1, userModel);
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
        public List<Vehicle> findVehiclesByType(String userType) {
            List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
            String query = "SELECT * FROM vehicle WHERE vehicle_type = ?"; // SQL query to return vehicles with the type

            // Establish a connection to the database
            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
                preparedStatement.setString(1, userType);
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
        public List<Vehicle> findVehiclesByColor(String userColor) {
            List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
            String query = "SELECT * FROM vehicle WHERE color = ?"; // SQL query to return vehicles with the color

            // Establish a connection to the database
            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
                preparedStatement.setString(1, userColor);
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
        public List<Vehicle> findVehiclesByOdometer(int min, int max) {
            List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
            String query = "SELECT * FROM vehicle WHERE odometer BETWEEN ? AND ?"; // SQL query to return vehicles with the odometer

            // Establish a connection to the database
            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);// Passed SQL query
                preparedStatement.setInt(1, min);
                preparedStatement.setInt(2, max);
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
        public List<Vehicle> findVehiclesByPrice(double min, double max) {
            List<Vehicle> vehicleList = new ArrayList<>(); // Created an empty list to hold vehicles
            String query = "SELECT * FROM vehicle WHERE price BETWEEN ? AND ?"; // SQL query to return vehicles with the price

            // Establish a connection to the database
            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);  // Passed SQL query
                preparedStatement.setDouble(1,min);
                preparedStatement.setDouble(2, max);
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


        private Vehicle createVehicle(ResultSet resultSet) throws SQLException {
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

