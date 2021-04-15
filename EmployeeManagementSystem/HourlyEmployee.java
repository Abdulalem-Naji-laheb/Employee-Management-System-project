package EmployeeManagementSystem;

public class HourlyEmployee extends Employee implements Displayable {
    private double hour_ate;
    private int no_of_hour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, String address, int SSN, double hour_ate, int no_of_hour) {
        super(name, address, SSN);
        this.hour_ate = hour_ate;
        this.no_of_hour = no_of_hour;
    }

    public HourlyEmployee(String name, String address, int SSN, Gender sex, double hour_ate, int no_of_hour) {
        super(name, address, SSN, sex);
        this.hour_ate = hour_ate;
        this.no_of_hour = no_of_hour;
    }

    public double getHour_ate() {
        return hour_ate;
    }

    public void setHour_ate(double hour_ate) {
        this.hour_ate = hour_ate;
    }

    public int getNo_of_hour() {
        return no_of_hour;
    }

    public void setNo_of_hour(int no_of_hour) {
        this.no_of_hour = no_of_hour;
    }
    public double Earning(){
        return no_of_hour*hour_ate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "hour_ate=" + hour_ate +
                ", no_of_hour=" + no_of_hour +
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
