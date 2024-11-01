package CarDealershipAbstract;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
Scanner scanner = new Scanner(System.in);

    private void init() throws IOException {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = new Dealership();
    }

    public void display() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = new Dealership();
        try {
            System.out.println("Welcome To The Dealership Inventory Archives");

            System.out.println("How would you like to search this inventory?" + "\n" +
                    "1) Vehicles By Price" + "\n" +
                    "2) Vehicles By Make and Model" + "\n" +
                    "3) Vehicles By Color" + "\n" +
                    "4) Vehicles By Mileage" + "\n" +
                    "5) Vehicles By Year" + "\n" +
                    "6) Vehicles By Type" + "\n" +
                    "6) All Vehicles" + "\n" +
                    "7) Add Vehicle To Inventory" + "\n" +
                    "8) Remove Vehicle From Inventory ");

            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    dealershipFileManager.getDealership();
                    processGetByPriceRequest();
                    break;
                case 2:
                    dealershipFileManager.getDealership();
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    dealershipFileManager.getDealership();
                    processGetByColorRequest();
                    break;
                case 4:
                    dealershipFileManager.getDealership();
                    processGetByMileageRequest();
                    break;
                case 5:
                    dealershipFileManager.getDealership();
                    processGetByYearRequest();
                    break;
                case 6:
                    dealershipFileManager.getDealership();
                    processGetAllVehiclesRequest();
                    break;
                case 7:
                    dealershipFileManager.getDealership();
                    dealership.getAllVehicles();
                    break;
                case 8:
                    dealershipFileManager.getDealership();
                    processAddVehicleRequest();
                    break;
                case 9:
                    dealershipFileManager.getDealership();
                    processRemoveVehicleRequest();
                    break;

            }
            String buffer = scanner.nextLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

private void processGetByPriceRequest() throws IOException {
    System.out.println("Enter the minimum price to search for:");
    double min = scanner.nextDouble();
    System.out.println("Enter the maximum price to search for:");
    double max = scanner.nextDouble();
    scanner.nextLine();

    BufferedReader bufferedReader = new BufferedReader(new FileReader("carInventory.csv"));
    String input = bufferedReader.readLine();
    String[] getDealership = input.split("\\|");
    String dealershipInfo = getDealership[0] + "|" + getDealership[1] + "|" + getDealership[2];
    System.out.println(dealershipInfo);
    while ((input = bufferedReader.readLine()) != null) {
        String[] vehicleInfo = input.split("\\|");
        Vehicle vehicle = new Vehicle(vehicleInfo[0], Integer.parseInt(vehicleInfo[1]), vehicleInfo[2], vehicleInfo[3],
                vehicleInfo[4], vehicleInfo[5], Integer.parseInt(vehicleInfo[6]), Double.parseDouble(vehicleInfo[7]));
        String allInventory = vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getBrand() + "|" + vehicle.getMake() + "|" +
                vehicle.getModel() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
        if (vehicle.getPrice() > min && vehicle.getPrice() < max) {
            System.out.println(allInventory);
        } else {
            System.out.println("No vehicles found");

        }
    }
}
private void processGetByMakeModelRequest() throws IOException {
    System.out.println("Enter the make of the car:");
    String make = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Enter the model of the car");
    String model = scanner.nextLine();

    BufferedReader bufferedReader = new BufferedReader(new FileReader("carInventory.csv"));
    String input = bufferedReader.readLine();
    String[] getDealership = input.split("\\|");
    String dealershipInfo = getDealership[0] + "|" + getDealership[1] + "|" + getDealership[2];
    System.out.println(dealershipInfo);
    while ((input = bufferedReader.readLine()) != null) {
        String[] vehicleInfo = input.split("\\|");
        Vehicle vehicle = new Vehicle(vehicleInfo[0], Integer.parseInt(vehicleInfo[1]), vehicleInfo[2], vehicleInfo[3],
                vehicleInfo[4], vehicleInfo[5],Integer.parseInt(vehicleInfo[6]), Double.parseDouble(vehicleInfo[7]));
        String allInventory = vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getBrand() + "|" + vehicle.getMake() + "|" +
                vehicle.getModel() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
        if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getMake().equalsIgnoreCase(model)) {
            System.out.println(allInventory);
        } else {
            System.out.println("No vehicles found");
        }
    }
}

private void processGetByYearRequest() throws IOException {
    System.out.println("Enter the start year to search for:");
    int min = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Enter the end year to search for:");
    int max = scanner.nextInt();
    scanner.nextLine();

    BufferedReader bufferedReader = new BufferedReader(new FileReader("carInventory.csv"));
    String input = bufferedReader.readLine();
    String[] getDealership = input.split("\\|");
    String dealershipInfo = getDealership[0] + "|" + getDealership[1] + "|" + getDealership[2];
    System.out.println(dealershipInfo);
    while ((input = bufferedReader.readLine()) != null) {
        String[] vehicleInfo = input.split("\\|");
        Vehicle vehicle = new Vehicle(vehicleInfo[0], Integer.parseInt(vehicleInfo[1]), vehicleInfo[2], vehicleInfo[3],
                vehicleInfo[4], vehicleInfo[5],Integer.parseInt(vehicleInfo[6]), Double.parseDouble(vehicleInfo[7]));
        String allInventory = vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getBrand() + "|" + vehicle.getMake() + "|" +
                vehicle.getModel() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
        if (vehicle.getYearMake() > min && vehicle.getYearMake() < max) {
            System.out.println(allInventory);
        } else {
            System.out.println("No vehicles found");
        }
    }
}

    private void processGetByColorRequest() throws IOException {
        System.out.println("Enter the color to search for:");
        String color = scanner.nextLine();
        Dealership dealership = new Dealership();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("carInventory.csv"));
        String input = bufferedReader.readLine();
        String[] getDealership = input.split("\\|");
        String dealershipInfo = getDealership[0] + "|" + getDealership[1] + "|" + getDealership[2];
        System.out.println(dealershipInfo);
        while ((input = bufferedReader.readLine()) != null) {
            String[] vehicleInfo = input.split("\\|");
            Vehicle vehicle = new Vehicle(vehicleInfo[0], Integer.parseInt(vehicleInfo[1]), vehicleInfo[2], vehicleInfo[3],
                    vehicleInfo[4], vehicleInfo[5],Integer.parseInt(vehicleInfo[6]), Double.parseDouble(vehicleInfo[7]));
            String allInventory = vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getBrand() + "|" + vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                System.out.println(allInventory);
            } else {
                System.out.println("No vehicles found");
        }
    }
}

    private void processGetByMileageRequest() throws IOException {
        System.out.println("Enter the minimum mileage to search for:");
        int min = scanner.nextInt();
        System.out.println("Enter the maximum mileage to search for:");
        int max = scanner.nextInt();
        scanner.nextLine();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("carInventory.csv"));
        String input = bufferedReader.readLine();
        String[] getDealership = input.split("\\|");
        String dealershipInfo = getDealership[0] + "|" + getDealership[1] + "|" + getDealership[2];
        System.out.println(dealershipInfo);
        while ((input = bufferedReader.readLine()) != null) {
            String[] vehicleInfo = input.split("\\|");
            Vehicle vehicle = new Vehicle(vehicleInfo[0], Integer.parseInt(vehicleInfo[1]), vehicleInfo[2], vehicleInfo[3],
                    vehicleInfo[4], vehicleInfo[5],Integer.parseInt(vehicleInfo[6]), Double.parseDouble(vehicleInfo[7]));
            String allInventory = vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getBrand() + "|" + vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
            if (vehicle.getOdometer() > min && vehicle.getOdometer() < max) {
                System.out.println(allInventory);
            } else {
                System.out.println("No vehicles found");
            }
        }
    }

    private void processGetByVehicleTypeRequest() {
            System.out.println("Enter the vehicle brand to search for:");
            String model = scanner.nextLine();

        }

    public void processGetAllVehiclesRequest() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("carInventory.csv"));
        String input = bufferedReader.readLine();
        String[] getDealership = input.split("\\|");
        String dealershipInfo = getDealership[0] + "|" + getDealership[1] + "|" + getDealership[2];
        System.out.println(dealershipInfo);
        while ((input = bufferedReader.readLine()) != null) {
            String[] vehicleInfo = input.split("\\|");
            Vehicle vehicle = new Vehicle(vehicleInfo[0], Integer.parseInt(vehicleInfo[1]), vehicleInfo[2], vehicleInfo[3],
                    vehicleInfo[4], vehicleInfo[5],Integer.parseInt(vehicleInfo[6]), Double.parseDouble(vehicleInfo[7]));
            String allInventory = vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getBrand() + "|" + vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
            System.out.println(allInventory);
        }
    }

    private void processAddVehicleRequest() throws IOException {
        System.out.println("Enter the vin of the car:");
        String vin = scanner.nextLine();
        System.out.println("Enter the year of the car:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the make of the car:");
        String brand = scanner.nextLine();
        System.out.println("Enter the model of the car:");
        String make = scanner.nextLine();
        System.out.println("Enter the type of the car:");
        String model = scanner.nextLine();
        System.out.println("Enter the color of the car:");
        String color = scanner.nextLine();
        System.out.println("Enter the mileage of the car:");
        int odometer = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the price of the car:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, brand, make, model, color, odometer, price);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("carInventory", true));
        String newVehicle = vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getBrand() + "|" + vehicle.getMake() +
                "|" + vehicle.getModel() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
        bufferedWriter.write(newVehicle);
        }

    private void processRemoveVehicleRequest() throws IOException {
         System.out.println("Enter the VIN of the vehicle you want to remove");
         String vin = scanner.nextLine();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("carInventory.csv"));
        String input = bufferedReader.readLine();
        String[] getDealership = input.split("\\|");
        String dealershipInfo = getDealership[0] + "|" + getDealership[1] + "|" + getDealership[2];
        System.out.println(dealershipInfo);
        while ((input = bufferedReader.readLine()) != null) {
            String[] vehicleInfo = input.split("\\|");
            Vehicle vehicle = new Vehicle(vehicleInfo[0], Integer.parseInt(vehicleInfo[1]), vehicleInfo[2], vehicleInfo[3],
                    vehicleInfo[4], vehicleInfo[5],Integer.parseInt(vehicleInfo[6]), Double.parseDouble(vehicleInfo[7]));
            String allInventory = vehicle.getVin() + "|" + vehicle.getYearMake() + "|" + vehicle.getBrand() + "|" + vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
            ArrayList<String> inventory = new ArrayList<>();
            inventory.add(allInventory);
            if (vehicle.getVin().equalsIgnoreCase(vin)) {
                System.out.println(allInventory);
                inventory.remove(vehicle);
            } else {
                System.out.println("No vehicles found");

            }
        }
    }
}