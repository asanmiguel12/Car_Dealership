package com.pluralsight.CarDealershipAbstract;

public class Vehicle {
    String brand;
    int yearMake;
    String make;
    String model;
    String vin;
    String color;
    int odometer;
    double price;

    public Vehicle(String vin, int yearMake, String brand, String make, String model,
                    String color, int odometer, double price) {
        this.brand = brand;
        this.yearMake = yearMake;
        this.make = make;
        this.model = model;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearMake() {
        return yearMake;
    }

    public void setYearMake(int yearMake) {
        this.yearMake = yearMake;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

