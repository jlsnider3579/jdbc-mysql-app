package com.pluralsight;

import com.pluralsight.dao.VehicleDao;
import org.apache.commons.dbcp2.BasicDataSource;

public class App {
    public static void main(String[] args) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("root");
        ds.setPassword("yearup");
        ds.setUrl("jdbc:mysql://localhost:3306/dealership");

        UserInterFace ui = new UserInterFace(ds);
        ui.display();
    }
}
