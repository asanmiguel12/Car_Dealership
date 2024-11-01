package CarDealershipAbstract;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {
    public ContractFileManager() {
}

    public void displayAllContracts () throws FileNotFoundException {
        ArrayList<Contract> contracts = new ArrayList<>();
        FileReader fileReader = new FileReader("Contracts.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


    }


    public void saveContract () throws IOException {
        FileWriter fileWriter = new FileWriter("Contracts.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(dealership.getName() +"|" + dealership.getAddress() + "|" + dealership.getPhone());
        bufferedWriter.newLine();
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            bufferedWriter.write(vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" + vehicle.getModel() + "|" + vehicle.getColor() + "|" +
                    vehicle.getOdometer() + "|" + vehicle.getPrice());
            bufferedWriter.newLine();
        }
    }


    public void displaySalesContracts (){

    }

    public void displayLeaseContracts () {

    }

}
