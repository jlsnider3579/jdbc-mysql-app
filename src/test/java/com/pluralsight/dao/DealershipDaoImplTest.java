package com.pluralsight.dao;

import com.pluralsight.Dealership;
import com.pluralsight.Vehicle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipDaoImplTest {
    static DealershipDao dao;
    static String url = "jdbc:mysql://localhost:3306/test_dealership";
    static String userName = "root";
    static String password = "yearup";

    @BeforeAll
    static void setup() {
        dao = new DealershipDaoImpl(url, userName, password);
    }


    @Test
    void findAllDealerships() {
        List<Dealership> dealershipList = dao.findAllDealerships();
        int expected = 1;
        assertEquals(expected, dealershipList.size());

    }

}