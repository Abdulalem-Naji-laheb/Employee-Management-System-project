package EmployeeManagementSystem;

import java.util.LinkedList;
import java.util.Scanner;

public class TheManage_Of_Employee_test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        /**
         * Edit.
         */
        LinkedList<Department> departments = new LinkedList<>();

        boolean continua = true;

        while (continua){
            System.out.println("for remove -> R , add employ -> A, count employ -> C, display all details -> D," +
                    " Display Earning -> DE , Exit -> E");
            String command = input.next();

            if (command.equals("R") || command.equals("r")){
                removeEmploy(departments);

            }else if (command.equals("A") || command.equals("a")){
                Department dept = createNewDept();
                addSomeEmploy(dept);
                /**
                 * Edit.
                 */
                departments.addLast(dept);

            }else if (command.equals("C") || command.equals("c")){
                countEmploy(departments);

            }else if (command.equals("DE") || command.equals("de")){
                displayEarning(departments);
            }

            else if (command.equals("D") || command.equals("d")){
                displayAll(departments);

            }else if (command.equals("E") || command.equals("e")){
                continua = false;
            }

        }

    }

    static Department createNewDept(){
        Scanner input = new Scanner(System.in);

        int numDept;
        String nameDept;

        System.out.print("Enter the dept No:");
        numDept = input.nextInt();
        System.out.print("Enter the dept name:");
        nameDept = input.next();

        return new Department(numDept, nameDept);
    }
    static void addSomeEmploy(Department dept){
        Scanner input = new Scanner(System.in);

        System.out.print("How many employ you want:");
        int countEmp = input.nextInt();

        System.out.println("What is the type of employ ?");
        System.out.println("Salaried -> S , Hourly -> H, Commission -> C , Base Plus Commission -> B");
        String type = input.next();

        for (int i = 0; i < countEmp; i++) {
            System.out.println("Employ ("+ (i + 1) + ")");
            System.out.println("-------------------------------------");

            if (type.equals("S") || type.equals("s")) {
                Employee sm = salariedEmp();
                dept.add_Employee(sm);

            } else if (type.equals("H") || type.equals("h")) {
                Employee hm = hourlyEmp();
                dept.add_Employee(hm);

            } else if (type.equals("C") || type.equals("c")) {
                Employee cm = commissionEmp();
                dept.add_Employee(cm);

            } else if (type.equals("B") || type.equals("b")) {
                Employee bm = basePlusCommissionEmp();
                dept.add_Employee(bm);

            }
        }
    }

    /**
     * Edit displayAll(), to receive LinkList<> rather than Arraylist<>.
     */
    static void displayAll(LinkedList<Department> departments){

        for (Department dept: departments) {
            System.out.println("Details this Department.");
            System.out.println("Dept Name: " + dept.getName());
            System.out.println("Dept No: " + dept.getNo());
            dept.print_All_details();
            System.out.println("-----------------------------------");
        }
    }

    /**
     * Edit displayEarning(), to receive LinkList<> rather than Arraylist<>.
     */

    static void displayEarning(LinkedList<Department> departments){
        for (Department dept: departments) {
            System.out.println("Details this Department.");
            System.out.println("Dept Name: " + dept.getName());
            System.out.println("Dept No: " + dept.getNo());
            for (Employee emp: dept.getEmpList()) {
                System.out.print("Employ salary = ");
                System.out.println(emp.Earning());
            }
            System.out.println("-----------------------------------");
        }
    }

    /**
     * Edit removeEmploy(), to receive LinkList<> rather than Arraylist<>.
     */
    static void removeEmploy(LinkedList<Department> departments){
        Scanner input = new Scanner(System.in);
        boolean done  = false;

        while (true) {
            if (departments.size() >= 1){
                System.out.print("Enter employ SSN:");
                int ssn = input.nextInt();

                for (Department dept : departments) {
                    done = dept.remove_Employee(ssn);
                }
                if (done){
                    System.out.println("removed successfully");
                    break;
                }else {
                    System.out.println("This employ not exist to any department, Try again");
                    System.out.println("enter any key to continua Or  ---  Exit -> E");
                    String command = input.next();
                    if (command.equals("E") || command.equals("e")){
                        done = false;
                    }
                }
            }else {
                System.out.println("You don't have eny department at all. ");
                break;
            }

        }
    }

    /**
     * Edit countEmploy(), to receive LinkList<> rather than Arraylist<>.
     */
    static void countEmploy(LinkedList<Department> departments){
        int count = 0;
        if (departments.size() >= 1){
            for (Department dept : departments) {
                count = dept.getEmployeeCount();
                System.out.println("Details this Department.");
                System.out.println("Dept Name: " + dept.getName());
                System.out.println("Dept No: " + dept.getNo());
                System.out.println("Counts: " + count);
                System.out.println("-----------------------------------");
                count = 0;
            }
        }else {
            System.out.println("You don't have eny employs. ");
        }

    }

    static Employee basePlusCommissionEmp(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name:");
        String name = input.nextLine();

        System.out.print("Enter your address:");
        String address = input.nextLine();

        System.out.print("Enter your SSN:");
        int SSN = input.nextInt();

        System.out.print("Enter your gross sales:");
        double  gross_sales = input.nextDouble();

        System.out.print("Enter your commission rate:");
        double commission_rate = input.nextDouble();

        System.out.print("Enter your base:");
        double base = input.nextDouble();

        return  new BasePlusCommissionEmployee(name,address,SSN,gross_sales,commission_rate,base);
    }

    static Employee commissionEmp(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name:");
        String name = input.nextLine();

        System.out.print("Enter your address:");
        String address = input.nextLine();

        System.out.print("Enter your SSN:");
        int SSN = input.nextInt();

        System.out.print("Enter your gross sales:");
        double  gross_sales = input.nextDouble();

        System.out.print("Enter your commission rate:");
        double commission_rate = input.nextDouble();

        return  new CommissionEmployee(name,address,SSN,gross_sales,commission_rate);
    }

    static Employee hourlyEmp(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name:");
        String name = input.nextLine();

        System.out.print("Enter your address:");
        String address = input.nextLine();

        System.out.print("Enter your SSN:");
        int SSN = input.nextInt();

        System.out.print("Enter your hour rate:");
        double  hour_rate = input.nextDouble();

        System.out.print("Enter your number Of Hour:");
        int numberOfHour = input.nextInt();

        return  new HourlyEmployee(name,address,SSN,hour_rate,numberOfHour);
    }

    static Employee salariedEmp(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name:");
        String name = input.nextLine();

        System.out.print("Enter your address:");
        String address = input.nextLine();

        System.out.print("Enter your SSN:");
        int SSN = input.nextInt();

        System.out.print("Enter your Salary:");
        double salary = input.nextDouble();

        System.out.print("Enter your Bonus:");
        double bonus = input.nextDouble();

        System.out.print("Enter your Deduction:");
        double deduction = input.nextDouble();
        System.out.println("-------------------------------------");

        return  new SalariedEmployee(name,address,SSN,salary,bonus,deduction);

    }
}



//        Scanner input=new Scanner(System.in);
//        int x;
//        String y;
//        System.out.println("enter the deptno");
//        x=input.nextInt();
//        System.out.println("enter the deptnam");
//        y=input.next();
//        System.out.println("the dept number :"+x +"the dept name :"+y);
//      //  System.out.println("the");

//        Department d1=new Department(x,y);
//         String n,d,g;
//                 int s,b,de;
//        System.out.println("enter the emp name ");
//        n=input.next();
//        System.out.println("enter the emp address");
//        d=input.next();
//        System.out.println("enter the emp ssn");
//        s=input.nextInt();
//        System.out.println("enter the emp gender");
//        g=input.next();
//        System.out.println("enter the emp salary");
//        s=input.nextInt();
//        System.out.println("enter the emp bonus");
//        b=input.nextInt();
//        System.out.println("enter the emp deduction");
//        de=input.nextInt();
//        System.out.println("the emp name::" +n+  " Address::"+d+"SSN::" +s+ "gender::"+g+"salary::" +s +"bonus::" +b+ " deduction::1"+de);
//
//

//        SalariedEmployee ss1=new SalariedEmployee(n,d,s,g,s,b,de);
//        d1.add_Employee(ss1);
//        System.out.println("remove emp ");
//int f;
//        d1.remove_Employee(f=input.nextInt());

//    Department d1=new Department(1,"information Systems");
//
//        d1.add_Employee(se);
//                HourlyEmployee he=new HourlyEmployee("AbdullAleam","yemen",22,Gender.male,100,7);
//                d1.add_Employee(he);
//                //System.out.println(he.DisplayEarning());
//                ;
//                CommissionEmployee ce=new CommissionEmployee("Akhram","Palestine",44,Gender.male,1700,0.25);
//                d1.add_Employee(ce);
//
//                BasePlusCommissionEmployee bc=new BasePlusCommissionEmployee("fatima","syria",80,Gender.female,1900,0.30,200);
//                d1.add_Employee(bc);
//
//
//
//                System.out.println(d1.getEmployeeCount());
//                d1.remove_Employee(3);
//                System.out.println(d1.getEmployeeCount());
//                //        d1.print_basic_data();
//                d1.print_All_details();
//                System.out.println("the  earning of se :"+se.Earning());
//                System.out.println("the  earning of he :"+he.Earning());
//                System.out.println("the  earning of ce :"+ce.Earning());

