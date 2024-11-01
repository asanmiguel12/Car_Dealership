package CarDealershipAbstract;

public class LeaseContract extends Contract {
    double endingValue;
    double leaseFee;
    double getTotalPrice;
    double getMonthlyPayment;

    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold, double getTotalPrice, double getMonthlyPayment) {
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
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment(){
    return 0;
    }
}
