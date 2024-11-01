package com.pluralsight.CarDealershipAbstract;

public class LeaseContract extends Contract {
    double endingValue;
    double getTotalPrice;
    double getMonthlyPayment;
    double leaseFee;
    double leaseAPR = .04;
    double leaseTerm = 36;

    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.getTotalPrice = getTotalPrice;
        this.getMonthlyPayment = getMonthlyPayment;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return this.vehiclePrice * leaseAPR * leaseTerm;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return getMonthlyPayment() * leaseTerm;
    }

    @Override
    public double getMonthlyPayment(){
        return vehiclePrice * leaseAPR / (1 - Math.pow(1 + leaseAPR, -leaseTerm));
    }
}
