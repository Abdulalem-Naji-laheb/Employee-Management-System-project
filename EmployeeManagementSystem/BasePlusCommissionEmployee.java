package EmployeeManagementSystem;

public class
BasePlusCommissionEmployee extends CommissionEmployee{
  private   double base;

    public BasePlusCommissionEmployee() {
    }

    public BasePlusCommissionEmployee(String name, String address, int SSN, double gross_sales, double commission_rate, double base) {
        super(name, address, SSN, gross_sales, commission_rate);
        this.base = base;
    }

    public BasePlusCommissionEmployee(String name, String address,
                                      int SSN, Gender sex, double gross_sales, double commission_rate,
                                      double base) {
        super(name, address, SSN, sex, gross_sales, commission_rate);
        this.base = base;
    }
//
//    public BasePlusCommissionEmployee(String fatima, String syria, int i, int i1, double v, int i2) {
//    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
@Override
    public double Earning(){
        return base + super.Earning();
    }

    @Override
    public void DisplayAllDetails() {
        super.DisplayAllDetails();
        DisplayEarning();
    }

    @Override
    public void DisplayEarning() {
        System.out.println("the Earning "+Earning());
    }
}
