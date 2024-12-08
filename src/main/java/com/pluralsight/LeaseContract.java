package com.pluralsight;

public class LeaseContract extends Contract {
    private final double expectedEndingValuePercent = 0.5;
    private final double leaseFeePercent = .07;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    double getTotalPrice() {
        return 0;
    }

    @Override
    double getMonthlyPayment() {
        double monthlyPayment = getVehicleSold().getPrice() + leaseFeePercent * getVehicleSold().getPrice();
        return monthlyPayment;
    }

    @Override
    String toStringRepresentation() {
        return "";
    }
}
