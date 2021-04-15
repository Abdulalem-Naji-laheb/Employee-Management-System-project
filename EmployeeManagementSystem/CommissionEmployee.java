package EmployeeManagementSystem;


public class CommissionEmployee extends Employee implements Displayable{
    private double gross_sales;
    private double Commission_rate;

    public CommissionEmployee() {
    }

    public CommissionEmployee(String name, String address, int SSN, double gross_sales, double commission_rate) {
        super(name, address, SSN);
        this.gross_sales = gross_sales;
        Commission_rate = commission_rate;
    }

    public CommissionEmployee(String name, String address, int SSN, Gender sex,
                              double gross_sales, double commission_rate) {
        super(name, address, SSN, sex);
        this.gross_sales = gross_sales;
        Commission_rate = commission_rate;
    }

    public double getGross_sales() {
        return gross_sales;
    }

    public void setGross_sales(double gross_sales) {
        this.gross_sales = gross_sales;
    }

    public double getCommission_rate() {
        return Commission_rate;
    }

    public void setCommission_rate(double commission_rate) {
        Commission_rate = commission_rate;
    }
    public  double Earning(){
        return  gross_sales*Commission_rate;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "gross_sales=" + gross_sales +
                ", Commission_rate=" + Commission_rate +
                '}';
    }

    @Override
    public void DisplayAllDetails() {
        System.out.println(super.toString());
        System.out.println(toString());
    }

    @Override
    public void DisplayEarning() {
        System.out.println(Earning());
    }
}
