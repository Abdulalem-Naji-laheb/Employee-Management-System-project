package EmployeeManagementSystem;

import java.awt.geom.Ellipse2D;

public class SalariedEmployee extends Employee implements Displayable {
    double salary, bonus,deduction;


    public SalariedEmployee(String name, String address, int SSN, Gender sex, double salary, double bonus,
                            double deduction) {
        super(name, address, SSN, sex);
        this.salary = salary;
        this.bonus = bonus;
        this.deduction = deduction;

    }

    public SalariedEmployee(String name, String address, int SSN, double salary, double bonus, double deduction) {
        super(name, address, SSN);
        this.salary = salary;
        this.bonus = bonus;
        this.deduction = deduction;
    }

    public SalariedEmployee() {
    }

    public SalariedEmployee(String n, String d, int s, String g, int s1, int b, int de) {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }
    @Override
public double Earning(){
        return (salary+bonus)-deduction;
    }
    public void DisplayAllDetails(){
        System.out.println(super.toString());
        System.out.println(toString());

    }
public void DisplayEarning(){

        System.out.println(Earning());
}

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "salary=" + salary +
                ", bonus=" + bonus +
                ", deduction=" + deduction +
                '}';
    }
}
