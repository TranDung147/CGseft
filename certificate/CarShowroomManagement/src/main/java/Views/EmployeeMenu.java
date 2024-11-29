package Views;
import Controllers.CheckInput;
import Controllers.EmployeesController;
import java.util.Scanner;
public class EmployeeMenu extends Menu{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                addEmployee();               
                break;
            case 2:
                EmployeesController.viewEmployees();
                break;
            case 3:
                editEmployee();       
                break;
            case 4:
                removeEmployee();
                break;
            case 5:
                String[] choice = {"Search by msnv", "Search by name", "Search by CCCD", "Back"};
                new SearchEmployeesMenu().run("SEARCH EMPLOYEE", choice);
                break;   
        }
    }
    
    private void addEmployee() {
        String msnv, name, dob, address, cccd, phoneNum, tempSalary;
        
        System.out.println("-------------------");
        do {            
            System.out.print("MSNV: ");
            msnv = sc.nextLine();
            if (EmployeesController.checkExistence(msnv)) {
                System.out.println("---------------");
                System.out.println("MSNV had been used!! Enter again!!");
                System.out.println("----------------");
            }
        } while (EmployeesController.checkExistence(msnv));
        
        System.out.print("Full name: ");
        name = sc.nextLine();
        
        do {
            System.out.print("Date of birth: ");
            dob = sc.nextLine();
        } while (CheckInput.checkInputDob(dob));
        
        do {
            System.out.print("CCCD: ");
            cccd = sc.nextLine();
            if (CheckInput.checkInputNumber(cccd)) {
                System.out.println("----------");
                System.out.println("CCCD just contain number!!");
                System.out.println("-----------");
            }
        } while (CheckInput.checkInputNumber(cccd));
        
        System.out.print("Address: ");
        address = sc.nextLine();
        
        do {            
            System.out.print("Phone number: ");
            phoneNum = sc.nextLine();
            if (CheckInput.checkInputNumber(phoneNum)) {
                System.out.println("----------");
                System.out.println("Phone number just contain number!!");
                System.out.println("-----------");
            }
        } while (CheckInput.checkInputNumber(phoneNum));
        
        do {            
            System.out.print("Salary: ");
            tempSalary = sc.nextLine();
            if (CheckInput.checkInputNumber(tempSalary)) {
                System.out.println("----------");
                System.out.println("Salary just contain number!!");
                System.out.println("-----------");
            }
        } while (CheckInput.checkInputNumber(tempSalary));
        
        int salary = Integer.parseInt(tempSalary);
        
        EmployeesController.addEmployee(msnv, name, dob, address, cccd, phoneNum, salary);
        System.out.println("Add success!!");
    }

    private void editEmployee() {
        String msnv, name, address, cccd, phoneNum, dob, tempSalary, tempNumCarSold;
        int salary, numCarsSold;
        
        System.out.println("----------------------");
        System.out.print("MSNV of employee: ");
        msnv = sc.nextLine();
        
        if (!EmployeesController.checkExistence(msnv)) {
            System.out.println("----------------------");
            System.out.println("Employee does not exist!!");
            return;
        } 
        
        System.out.print("Full name: ");
        name = sc.nextLine();
        
        do {
            System.out.print("Date of birth: ");
            dob = sc.nextLine();
        } while (CheckInput.checkInputDob(dob));
        
        do {
            System.out.print("CCCD: ");
            cccd = sc.nextLine();
             if (CheckInput.checkInputNumber(cccd)) {
                System.out.println("----------");
                System.out.println("CCCD just contain number!!");
                System.out.println("-----------");
            }
        } while (CheckInput.checkInputNumber(cccd));
        
        System.out.print("Address: ");
        address = sc.nextLine();
        
        do {            
            System.out.print("Phone number: ");
            phoneNum = sc.nextLine();
             if (CheckInput.checkInputNumber(phoneNum)) {
                System.out.println("----------");
                System.out.println("Phone number just contain number!!");
                System.out.println("-----------");
            }
        } while (CheckInput.checkInputNumber(phoneNum));
        
        do {            
            System.out.print("Salary: ");
            tempSalary = sc.nextLine();
             if (CheckInput.checkInputNumber(tempSalary)) {
                System.out.println("----------");
                System.out.println("Salary just contain number!!");
                System.out.println("-----------");
            }
        } while (CheckInput.checkInputNumber(tempSalary));
        salary = Integer.parseInt(tempSalary);
        
        do {            
            System.out.print("Number of cars sold: ");
            tempNumCarSold = sc.nextLine();
             if (CheckInput.checkInputNumber(tempNumCarSold)) {
                System.out.println("----------");
                System.out.println("Number of car sold just contain number!!");
                System.out.println("-----------");
            }
        } while (CheckInput.checkInputNumber(tempNumCarSold));
        numCarsSold = Integer.parseInt(tempNumCarSold);
        
        EmployeesController.editEmployee(msnv, name, dob, address, cccd, phoneNum, salary, numCarsSold);
        System.out.println("Edit success!!");
    }

    private void removeEmployee() {
        System.out.println("----------------------");
        String msnv;
        System.out.print("Enter MSNV of employee: ");
        msnv = sc.nextLine();
        if (!EmployeesController.checkExistence(msnv)) {
            System.out.println("Employee does not exist!!");
            return;
        } 
        
        EmployeesController.removeEmployee(msnv);
        System.out.println("Remove success!!");
    }
}
