package com.pluralsight;

import com.pluralsight.dao.VehicleDao;
import com.pluralsight.dao.VehicleDaoImpl;

import javax.sql.DataSource;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInterFace {
    private Dealership dealership;
    private VehicleDao vehicleDao;

    static String url = "jdbc:mysql://localhost:3306/dealership";
    static String userName = "root";
    static String password = "yearup";

    // Constructor
    public UserInterFace(DataSource dataSource) {
        vehicleDao = new VehicleDaoImpl(dataSource);
    }

    // Method to display the menu and process user commands
    public void display() {
//        init(); // Load the dealership data
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("""
                     Welcome to the D & B Dealership
                     1. View vehicles by vin
                     2. View Vehicles by Price
                     3. View Vehicles by Make/model
                     5. View Vehicles by Year
                     6. View Vehicles by Color
                     7. View Vehicles by Mileage
                     8. View Vehicles by Type
                     9. View All Vehicles
                     10. Add a Vehicle
                     11. Remove a Vehicle
                     0. Exit
                    """);

            System.out.print("Enter your choice: ");

            // Read user input
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Handle user input
            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest(vehicleDao.findAllVehicles());
                case 8 -> processAddVehicleRequest();
                // case 9 -> processRemoveVehicleRequest();
                case 0 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public void processGetByVinRequest(int vin){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter vehicle vin");

        List<Vehicle> vehiclesByVin = dealership.getInventory().stream().filter(vehicle -> vehicle.getVin() == vin).toList();
    }

    // Placeholder methods (to be implemented later)
    public void processGetByPriceRequest() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your minimum price ");
        double minimumPrice = s.nextDouble();
        System.out.println("Enter you maximum price ");
        double maximumPrice = s.nextDouble();

        List<Vehicle> vehiclesByPrice = vehicleDao.findVehiclesByPrice(minimumPrice, maximumPrice);

        if (vehiclesByPrice.isEmpty()) {
            System.out.println("No vehicles within price range");
        } else {
            System.out.println(vehiclesByPrice);
        }
    }

    public void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        List<Vehicle> vehiclesByMakeModel = vehicleDao.findVehicleByMakeModel(make, model);

        if (vehiclesByMakeModel.isEmpty()) {
            System.out.println("No vehicles found with the specified make and model.");
        } else {
            vehiclesByMakeModel.forEach(System.out::println);
        }
    }

    public void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start year: ");
        int startYear = scanner.nextInt();
        System.out.println("Enter end year");
        int endYear= scanner.nextInt();

        List<Vehicle> vehiclesByYear = vehicleDao.findVehiclesByYear(startYear, endYear);

        if (vehiclesByYear.isEmpty()) {
            System.out.println("No vehicles found for the specified year.");
        } else {
            vehiclesByYear.forEach(System.out::println);
        }
    }

    public void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        List<Vehicle> vehiclesByColor = vehicleDao.findVehiclesByColor(color);

        if (vehiclesByColor.isEmpty()) {
            System.out.println("No vehicles found with the specified color.");
        } else {
            vehiclesByColor.forEach(System.out::println);
        }
    }

    public void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();

        List<Vehicle> vehiclesByMileage = dealership.getInventory().stream()
                .filter(vehicle -> vehicle.getOdometer() <= maxMileage)
                .collect(Collectors.toList());

        if (vehiclesByMileage.isEmpty()) {
            System.out.println("No vehicles found with mileage under " + maxMileage + ".");
        } else {
            vehiclesByMileage.forEach(System.out::println);
        }
    }

    public void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vehicle type (e.g., Sedan, SUV): ");
        String vehicleType = scanner.nextLine();

        List<Vehicle> vehiclesByType = dealership.getInventory().stream()
                .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                .collect(Collectors.toList());

        if (vehiclesByType.isEmpty()) {
            System.out.println("No vehicles found of type " + vehicleType + ".");
        } else {
            vehiclesByType.forEach(System.out::println);
        }
    }

    public void processGetAllVehiclesRequest( List<Vehicle> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("No vehicles available in the inventory.");
        } else {
            inventory.forEach(System.out::println);
        }
    }

    public void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter VIN: ");
        int vin = scanner.nextInt();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter vehicle type: ");
        String type = scanner.nextLine();
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        System.out.println("Enter odometer reading: ");
        int odometer = scanner.nextInt();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(newVehicle);

        System.out.println("Vehicle successfully added to the inventory!");
    }
}

