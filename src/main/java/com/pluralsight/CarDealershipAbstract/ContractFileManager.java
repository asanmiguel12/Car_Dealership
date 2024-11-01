package com.pluralsight.CarDealershipAbstract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {
    public ContractFileManager() {
}

    public void displayAllContracts () throws FileNotFoundException {
        List<Contract> contracts = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Contracts.csv"));
            String input;
            while (( input = bufferedReader.readLine()) != null) {
                String[] data = input.split("\\|");
                Vehicle v = new Vehicle(Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6], data[7],
                        data[8], data[9], Integer.parseInt(data[10]), Double.parseDouble(data[11]));
                if (data[0].equalsIgnoreCase("SALE")) {
                    boolean financed = data[14].equalsIgnoreCase("YES");

                    SalesContract salesContract = new SalesContract(data[1], data[2], data[3], v,
                            5, Double.parseDouble(data[13]), financed);

                    contracts.add(salesContract);
                } else if (data[0].equalsIgnoreCase("LEASE")) {
                    LeaseContract leaseContract = new LeaseContract(data[1], data[2], data[3], v);
                    contracts.add(leaseContract);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error Reading File");
        }
        return contracts;


    }


    public void saveContract () throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("contracts.csv"));
            String input;
            while (( input = bufferedReader.readLine()) != null) {
                String[] data = input.split("\\|");
                Vehicle v = new Vehicle(Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6], data[7],
                        data[8], data[9], Integer.parseInt(data[10]), Double.parseDouble(data[11]));
                if (data[0].equalsIgnoreCase("SALE")) {
                    boolean financed = data[14].equalsIgnoreCase("YES");

                    SalesContract salesContract = new SalesContract(data[1], data[2], data[3], v,
                            5, Double.parseDouble(data[13]), financed);

                    contracts.add(salesContract);
                } else if (data[0].equalsIgnoreCase("LEASE")) {
                    LeaseContract leaseContract = new LeaseContract(data[1], data[2], data[3], v);
                    contracts.add(leaseContract);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error Reading File");
        }
        return contracts;
        }


    public void displaySalesContracts (){

    }

    public void displayLeaseContracts () {

    }

}
