package CarDealershipAbstract;

import java.util.Scanner;

public class SalesContract extends Contract{
    double salesTax;
    double recordingFee;
    double processingFee;
    double vehiclePrice;
    double getTotalPrice;
    double getMonthlyPayment;

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, double vehiclePrice, double getTotalPrice, double getMonthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold);
        this.getTotalPrice = totalPrice;
        this.getMonthlyPayment = getMonthlyPayment;
        this.vehiclePrice = vehiclePrice;
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
        if (willFinance() == true) {
            double rate = .0425;
            double vehiclePrice = this.vehiclePrice;
            double term1 = 48;
            double term2 = 24;
            double totalInterest = vehiclePrice * rate * term1;
            return getMonthlyPayment();
        } else {
            return 0;
        }
    }
    public double setTotalPrice() {

        return getTotalPrice;
    }

    @Override
    public double getMonthlyPayment() {
//        (p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1)));
//        Monthly payment = (loan amount) *
//        (interest rate / 12) / (1 − (1 + (interest rate / 12)) ^ (-loan term))
        double rate = .0425;
        double principal = this.vehiclePrice;
        double term1 = 48;
        double term2 = 24;

        if (principal > 10000) {
            double monthlyPayment = principal * (rate / 12) / Math.pow((1 - (1 + (rate / 12))), -term1);
        } else {
            double monthlyPayment = principal * (rate/12) / Math.pow((1 - (1 + (rate/12))), -term2);
        }
        return monthlyPayment;
    }

    public double setMonthlyPayment() {
        return getMonthlyPayment;
    }
}
