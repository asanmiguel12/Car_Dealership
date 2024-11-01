package CarDealershipAbstract;

import java.io.*;
import java.util.Scanner;

public class DealershipFileManager {
    DealershipFileManager () {
    }

    Scanner scanner = new Scanner(System.in);

    public String getDealership() throws IOException {
        FileReader fileReader = new FileReader("carInventory.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String dealershipInfo = bufferedReader.readLine();
        String[] dealershipGetInfo = dealershipInfo.split("\\|");
        String name = dealershipGetInfo[0];
        String address = dealershipGetInfo[1];
        String phoneNumber = dealershipGetInfo[2];

        System.out.println("Dealership info: " + "\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Phone number: " + phoneNumber);
        System.out.println("Is this the correct dealership you would like to view? (Y/N)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("\n Loading dealership..." + "\n");
        }
        if (choice.equalsIgnoreCase("N")) {
            userChooseDealership();
        }
        bufferedReader.close();
        fileReader.close();
        return dealershipInfo;
    }

    public void saveDealership(Dealership dealership) {
        System.out.println("Would you like to save this dealership's inventory? (Y/N)");
        String userChoice = scanner.nextLine();
        if (userChoice.equalsIgnoreCase("Y")) {
            try {
                FileWriter fileWriter = new FileWriter("carInventory.csv");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
                bufferedWriter.newLine();
                for (Vehicle vehicle : dealership.getAllVehicles()) {
                    bufferedWriter.write(vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getMake() + "|" +
                            vehicle.getModel() + "|" + vehicle.getModel() + "|" + vehicle.getColor() + "|" +
                            vehicle.getOdometer() + "|" + vehicle.getPrice());
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } catch (Exception e) {
                System.out.println("Error writing to file");
            }
        }

    }

    public void userChooseDealership() throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the name of the dealership you would like to view");
            String userInputFile = scanner.nextLine();
            FileReader fileReader = new FileReader(userInputFile + ".csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input = bufferedReader.readLine();

            if (fileReader.equals(userInputFile + ".csv")) {
                getDealership();
            } else {
                System.out.println("Sorry we could not find a dealership under that name. Please try again");
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Invalid Input" + "\n" + "Please Try Again");
            e.printStackTrace();

        }
    }

    public Dealership getInventory() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("carInventory.csv"));
            String input = bufferedReader.readLine();
            String[] getDealership = input.split("\\|");
            String dealershipInfo = getDealership[0] + "|" + getDealership[1] + "|" +  getDealership[2];
            System.out.println(dealershipInfo);
            while ((input = bufferedReader.readLine()) != null) {
                String[] vehicleInfo = input.split("\\|");
                Vehicle vehicle = new Vehicle(vehicleInfo[0], Integer.parseInt(vehicleInfo[1]), vehicleInfo[2], vehicleInfo[3],
                        vehicleInfo[4], vehicleInfo[5], Integer.parseInt(vehicleInfo[6]), Double.parseDouble(vehicleInfo[7]));
                String allInventory = vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getBrand() + "|" +  vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();

                System.out.println(allInventory);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        return null;
    }
}