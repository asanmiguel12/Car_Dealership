package com.pluralsight.CarDealershipAbstract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {
    public ContractFileManager() {
}

    public List<Contract> displayContracts () throws FileNotFoundException {
        List<Contract> contracts = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Contracts.csv"));
            String input;
            while (( input = bufferedReader.readLine()) != null) {
                String[] contractInfo = input.split("\\|");
                Vehicle vehicle = new Vehicle(contractInfo[4], Integer.parseInt(contractInfo[5]), contractInfo[6], contractInfo[7],
                        contractInfo[8], contractInfo[9], Integer.parseInt(contractInfo[10]), Double.parseDouble(contractInfo[11]));
                if (contractInfo[0].equalsIgnoreCase("SALE")) {
                    boolean financed = contractInfo[14].equalsIgnoreCase("YES");
                    SalesContract salesContract = new SalesContract(contractInfo[1], contractInfo[2], contractInfo[3],
                            vehicle, Double.parseDouble(contractInfo[15]), Double.parseDouble(contractInfo[13]));
                    contracts.add(salesContract);
                } else if (contractInfo[0].equalsIgnoreCase("LEASE")) {
                    LeaseContract leaseContract = new LeaseContract(contractInfo[1], contractInfo[2], contractInfo[3], vehicle);
                    contracts.add(leaseContract);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error Reading File");
        }
        return contracts;
    }


    public Contract saveContract (Contract contract) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("contracts.csv"));
            ArrayList<Contract> contracts = new ArrayList<>();
            String input;
            while (( input = bufferedReader.readLine()) != null) {
                String[] contractInfo = input.split("\\|");
                Vehicle v = new Vehicle(contractInfo[4], Integer.parseInt(contractInfo[5]), contractInfo[6], contractInfo[7],
                        contractInfo[8], contractInfo[9], Integer.parseInt(contractInfo[10]), Double.parseDouble(contractInfo[11]));
                if (contractInfo[0].equalsIgnoreCase("SALE")) {
                    boolean isfinanced = contractInfo[14].equalsIgnoreCase("YES");

                    SalesContract salesContract = new SalesContract(contractInfo[1], contractInfo[2], contractInfo[3], v,
                            Double.parseDouble(contractInfo[15]), Double.parseDouble(contractInfo[13]));

                    contracts.add(salesContract);
                } else if (contractInfo[0].equalsIgnoreCase("LEASE")) {
                    LeaseContract leaseContract = new LeaseContract(contractInfo[1], contractInfo[2], contractInfo[3], v);
                    contracts.add(leaseContract);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("No vehicles found");
        }
        return contract;
    }


    public void displaySalesContracts (){

    }

    public void displayLeaseContracts () {

    }

}
