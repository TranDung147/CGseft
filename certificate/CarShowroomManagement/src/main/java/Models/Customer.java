package Models;

import java.util.ArrayList;

public class Customer {
    private String name, email, address, phoneNum, mkh;
    private ArrayList<String> logs = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String email, String address, String phoneNum, String mkh) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.mkh = mkh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMkh() {
        return mkh;
    }

    public void setMkh(String mkh) {
        this.mkh = mkh;
    }
    
    public void setLogs(String s) {
        logs.add(s);
    }

    @Override
    public String toString() {
        return name + " || Phone number: " + phoneNum;
    }
    
    public void display() {
        System.out.println("Customer's ID: " + mkh);
        System.out.println("Full name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone number: " + phoneNum);
        System.out.println("Address: " + address);
        for (int i = 0; i < logs.size(); i++) {
            System.out.println((i + 1) + ". " + logs.get(i));
        }
    }
}
