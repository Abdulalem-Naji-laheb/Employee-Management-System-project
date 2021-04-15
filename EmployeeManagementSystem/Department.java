package EmployeeManagementSystem;

import java.util.LinkedList;

public class Department {
    private int dNo;
    private  String dName;
    /**
     * Edit the Data-Structures of the employees, from Arraylist<> to LinkList<>.
     */
    LinkedList<Employee> empList;

    public Department() {
    }

    /**
     * Edit.
     */
    public Department(int dNo, String dName ) {
        this.dNo = dNo;
        this.dName = dName;
        empList = new  LinkedList<Employee> ();
    }

    /**
     * Edit getEmpList(), to return LinkList<> rather than Arraylist<>.
     */
    public LinkedList<Employee> getEmpList() {
        return empList;
    }

    public int getNo() {
        return dNo;
    }

    public void setNo(int dNo) {
        this.dNo = dNo;
    }

    public String getName() {
        return dName;
    }

    public void setName(String dName) {
        this.dName = dName;
    }

    /**
     * Edit.
     * we use the addLast() methode in the LinkList.
     */
    public void add_Employee(Employee e){
        empList.addLast(e);
    }

    /**
     * Edit.
     * we use the remove() methode in the LinkList.
     */
    public boolean remove_Employee(int ssn){
        for (int i =0; i < empList.size(); i++) {
            if (empList.get(i).getSSN() == ssn){
                empList.remove(i);
                return true;
            }
        }
        return false;
    }
    public  int getEmployeeCount(){
        return empList.size();
    }
    public void print_basic_data(){
        for (int i = 0; i < empList.size(); i++) {
            System.out.println(empList.get(i).getSSN()+" " +empList.get(i).getName() +" "+ empList.get(i).getSex());

        }

    }
    public  void print_All_details(){
        for (int i = 0; i <empList.size() ; i++) {
            if(empList.get(i) instanceof SalariedEmployee)
                ((SalariedEmployee) empList.get(i)).DisplayAllDetails();
            if(empList.get(i) instanceof HourlyEmployee)
               ((HourlyEmployee) empList.get(i)).DisplayAllDetails();
            if(empList.get(i) instanceof CommissionEmployee)
                ((CommissionEmployee) empList.get(i)).DisplayAllDetails();


        }
    }
}
