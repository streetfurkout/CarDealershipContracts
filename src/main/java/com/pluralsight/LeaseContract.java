package com.pluralsight;

public class LeaseContract extends Contract {
    private static final double ENDING_VALUE_PERCENTAGE = 0.5;
    private static final double LEASE_FEE_RATE = 0.07;
    private static final double FINANCE_RATE = 0.04;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.totalPrice = calculateTotalPrice(vehicleSold.getPrice());
        this.monthlyPayment = calculateMonthlyPayment(vehicleSold.getPrice());
    }

    private double calculateTotalPrice(double vehiclePrice) {
        return vehiclePrice * LEASE_FEE_RATE + (vehiclePrice * ENDING_VALUE_PERCENTAGE);
    }

    private double calculateMonthlyPayment(double vehiclePrice) {
        double financedAmount = vehiclePrice * (1 - ENDING_VALUE_PERCENTAGE);
        return (financedAmount * (1 + FINANCE_RATE * 36 / 12)) / 36;
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
}