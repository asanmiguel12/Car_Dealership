package com.pluralsight.CarDealershipAbstract;

import java.util.Scanner;

public class SalesContract extends Contract{
    double salesTax;
    double recordingFee;
    double processingFee;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double getTotalPrice, double getMonthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold);

    }


    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = this.totalPrice * .05;
    }

    public double getRecordingFee() {
        this.recordingFee = 100;
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        if (this.totalPrice <= 10000) {
            this.processingFee = 295;
        } else if (this.totalPrice > 10000) {
            this.processingFee = 495;
    }
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    Scanner scanner = new Scanner(System.in);
    public boolean willFinance() {
        System.out.println("Would you like to finance your vehicle? (Y/N");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            getMonthlyPayment();
            return true;
        } else if (choice.equalsIgnoreCase("N")) {
            getTotalPrice();
            return false;
        }
        return true;
    }

    @Override
    public double getTotalPrice() {
        if (!willFinance()) {
            return 0;
        } else {
            return getMonthlyPayment() + processingFee + recordingFee + salesTax;
        }
    }

    public double setTotalPrice() {
        return getTotalPrice();
    }

    @Override
    public double getMonthlyPayment() {
//        (p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1)));
//        Monthly payment = (loan amount) * (interest rate / 12) / (1 − (1 + (interest rate / 12)) ^ (-loan term))
        double rate1 = .0425;
        double rate2 = .05;
        double principal = getTotalPrice();
        double term1 = 48;
        double term2 = 24;

        if (principal > 10000) {
            double monthlyPayment = principal * (rate1 / 12) / Math.pow((1 - (1 + (rate1 / 12))), -term1);
            System.out.println("Monthly payment: " + monthlyPayment);
        } else {
            double monthlyPayment = principal * (rate2 / 12) / Math.pow((1 - (1 + (rate2 / 12))), -term2);
            System.out.println("Monthly payment: " + monthlyPayment);
        }

        return monthlyPayment;
    }

    public double setMonthlyPayment() {
        return getMonthlyPayment();
    }
}
