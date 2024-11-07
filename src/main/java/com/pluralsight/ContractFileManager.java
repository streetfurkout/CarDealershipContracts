package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            writer.write(contract instanceof SalesContract ? "SALE" : "LEASE");
            writer.write("|" + contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" + contract.getVehicleSold().getVin());
            writer.write("|" + contract.getTotalPrice() + "|" + contract.getMonthlyPayment());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing contract to file: " + e.getMessage());
        }
    }
}