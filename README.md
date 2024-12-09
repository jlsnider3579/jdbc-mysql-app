# JDBC MySQL App

This project demonstrates a Java application using JDBC to interact with a MySQL database. It includes features for managing dealership inventory, contracts, and sales.

## Table of Contents
- Overview
- Project Structure
- Features
- Technologies Used
- Usage
- Testing

---

## Overview
The jdbc-mysql-app is a dealership management system built using Java and JDBC. It allows users to manage vehicle inventory, generate sales and lease contracts, and handle database operations.

---

## Project Structure

### Main Code
- **com.pluralsight.dao**: Contains Data Access Object (DAO) interfaces and their implementations for interacting with the database.
  - DatabaseConfig: Configures the database connection.
  - DealershipDao and DealershipDaoImpl: Handles dealership-specific database operations.
  - InventoryDao: Manages inventory-related database operations.
  - VehicleDao and VehicleDaoImpl: Handles vehicle data.
  - SalesContractDao: Manages sales contract data.

- **Other Classes**:
  - App: Entry point for the application.
  - Contract, SalesContract, LeaseContract: Represent contracts.
  - Dealership: Main logic for dealership management.
  - UserInterface: Facilitates user interaction.
  - Vehicle: Represents vehicle entities.

### Test Code
- **com.pluralsight.dao**:
  - DealershipDaoImplTest: Unit tests for dealership DAO implementation.
  - VehicleDaoSqlImplTest: Unit tests for vehicle DAO implementation.

---

## Features
- **Inventory Management**: Add, update, and delete vehicle records.
- **Contract Management**: Create and manage sales and lease contracts.
- **User Interface**: Interactive menu system to access features.
- **Database Integration**: Fully integrated with MySQL using JDBC.

---

## Technologies Used
- Java
- JDBC
- MySQL
- JUnit (for testing)
- IntelliJ IDEA (as IDE)

---


