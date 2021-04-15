package EmployeeManagementSystem;


enum Gender {male,female};

public abstract class Employee {
    private String Name;
    private String Address;
    private int SSN;
    private Gender Sex;

    public Employee() {
    }

    public Employee(String name, String address, int SSN) {
        Name = name;
        Address = address;
        this.SSN = SSN;
    }

    public Employee(String name, String address, int SSN, Gender sex) {
        Name = name;
        Address = address;
        this.SSN = SSN;
        Sex = sex;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getSSN() {
        return SSN;
    }

    public Gender getSex() {
        return Sex;
    }

    public void setSex(Gender sex) {
        Sex = sex;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }
    public abstract double Earning();

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", SSN=" + SSN +
                ", Sex=" + Sex +
                '}';
    }
}
