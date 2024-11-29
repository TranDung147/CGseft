package Models;

public class Employee {
    private String msnv, name, dob, address, cccd, phoneNum;
    private int salary, numCarSold;

    public Employee() {
        numCarSold = 0;
    }

    public Employee(String msnv, String name, String dob, String address, String cccd, String phoneNum, int salary, int numCarSold) {
        this.msnv = msnv;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.cccd = cccd;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.numCarSold = numCarSold;
    }
    
    public Employee(String msnv, String name, String dob, String address, String cccd, String phoneNum, int salary) {
        this.msnv = msnv;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.cccd = cccd;
        this.phoneNum = phoneNum;
        this.salary = salary;
    }

    public String getMsnv() {
        return msnv;
    }

    public void setMsnv(String msnv) {
        this.msnv = msnv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getNumCarSold() {
        return numCarSold;
    }

    public void setNumCarSold(int numCarSold) {
        this.numCarSold = numCarSold;
    }

    @Override
    public String toString() {
        return "MSNV: " + msnv + " || Full name: " + name + " || Phone number: " + phoneNum;
    }
    
    public void display() {
        System.out.println("MSNV: " + msnv);
        System.out.println("Full name: " + name);
        System.out.println("Date of birth: " + dob);
        System.out.println("Address: " + address);
        System.out.println("CCCD: " + cccd);
        System.out.println("Phone number: " + phoneNum);
        System.out.println("Salary: " + salary);
        System.out.println("Number of cars sold: " + numCarSold);
    }
    
    public void changeInfor(String msnv, String name, String dob, String address, String cccd, String phoneNum, int salary, int numCarSold) {
        this.msnv = msnv;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.cccd = cccd;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.numCarSold = numCarSold;
    }
}
