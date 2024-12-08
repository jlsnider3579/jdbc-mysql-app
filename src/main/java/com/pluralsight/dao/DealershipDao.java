package com.pluralsight.dao;

import com.pluralsight.Dealership;

import java.util.List;

public interface DealershipDao {
    List<Dealership> findAllDealerships();
}
