package com.pluralsight;

public class SalesContract extends Contract {
    private final double salesTaxAmount = 0.05;
    private final double recordingFee = 100.0;
    private double processingFee;
    private boolean isFinancing;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.processingFee = processingFee;
        this.isFinancing = isFinancing;
    }

    @Override
    double getTotalPrice() {
        Vehicle vehicleSold = getVehicleSold();
        double total = vehicleSold.getPrice() + vehicleSold.getPrice() * salesTaxAmount + recordingFee + processingFee;
        return total;
    }

    @Override
    double getMonthlyPayment() {
        Vehicle v = getVehicleSold();
        double monthlyLoanRate = v.getPrice() > 10000 ? .0425 : .0525;
        return -1;
    }

    @Override
    String toStringRepresentation() {
        return "";
    }
}
