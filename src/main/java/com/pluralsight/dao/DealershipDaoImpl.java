package com.pluralsight.dao;

import com.pluralsight.Dealership;
import com.pluralsight.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealershipDaoImpl implements DealershipDao {
    private String url;
    private String userName;
    private String password;

    public DealershipDaoImpl(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public List<Dealership> findAllDealerships() {
        List<Dealership> dealershipList = new ArrayList<>();
        String query = "SELECT * FROM dealership";

        try (Connection connection = DatabaseConfig.getConnection(url, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Passed SQL query
            ResultSet resultSet = preparedStatement.executeQuery(); // Told SQL to execute the query

            // Iterates through list until the end
            while (resultSet.next()) {
                dealershipList.add(createDealership(resultSet));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dealershipList;
    }

    private Dealership createDealership(ResultSet resultSet) throws SQLException {
        return new Dealership(
                resultSet.getString("name"),
                resultSet.getString("address"),
                resultSet.getString("phone"),
                resultSet.getInt("dealership_id")

        ); // Created a new dealership using the data from the sql database

    }
}

