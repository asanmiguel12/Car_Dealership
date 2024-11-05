package com.pluralsight.CarDealershipAbstract;

public class LeaseContract extends Contract {
    double endingValue;
    double getTotalPrice;
    double getMonthlyPayment;
    double leaseFee;
    double leaseAPR = .04;
    double leaseTerm = 36;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.getTotalPrice = getTotalPrice;
        this.getMonthlyPayment = getMonthlyPayment;
    }

    public double getEndingValue() {
        double residualPercentage = .58;
        return this.vehiclePrice * residualPercentage;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return this.vehiclePrice * leaseAPR;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return this.getMonthlyPayment * leaseTerm;
    }

    @Override
    public double getMonthlyPayment(){
        double monthlyDepreciation = this.getEndingValue()/leaseTerm;
        double loanAmount = this.vehiclePrice - this.getEndingValue() + this.getLeaseFee();
        double monthlyInterestRate = leaseAPR / 12;

        return loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -leaseTerm));
    }
}
