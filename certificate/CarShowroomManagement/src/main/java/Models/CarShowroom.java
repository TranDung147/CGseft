package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CarShowroom {
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<String> logs = new ArrayList<>();
    private int revenue;

    public CarShowroom() {  
        loadEmployeeData();
        loadCarData();
        loadCustomerData();
        loadLog();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<String> getLogs() {
        return logs;
    }
    
    public void setLogs(String s) {
        logs.add(s);
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
    
    private void loadEmployeeData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("employeedata.txt"));
            String line = br.readLine();
            while (line != null) { 
                ArrayList<String> dataArrayList = new ArrayList<>();
                String[] s = line.split(";");
                for (int i = 0; i < s.length; i++) {
                    String[] datas = s[i].trim().split("=");
                    dataArrayList.add(datas[1]);
                }
                line = br.readLine();
                employees.add(new Employee(dataArrayList.get(0), dataArrayList.get(1), dataArrayList.get(2), dataArrayList.get(3), dataArrayList.get(4), dataArrayList.get(5), Integer.parseInt(dataArrayList.get(6)), Integer.parseInt(dataArrayList.get(7))));
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    private void loadCarData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("carsdata.txt"));
            String line = br.readLine();
            while (line != null) { 
                ArrayList<String> dataArrayList = new ArrayList<>();
                String[] s = line.split(";");
                for (int i = 0; i < s.length; i++) {
                    String[] datas = s[i].trim().split("=");
                    dataArrayList.add(datas[1]);
                }
                line = br.readLine();
                cars.add(new Car(dataArrayList.get(0), dataArrayList.get(1), dataArrayList.get(2), dataArrayList.get(3), Integer.parseInt(dataArrayList.get(4)), Integer.parseInt(dataArrayList.get(5)), Integer.parseInt(dataArrayList.get(6)), Integer.parseInt(dataArrayList.get(7))));
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    private void loadCustomerData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("customerdata.txt"));
            String line = br.readLine();
            while (line != null) { 
                ArrayList<String> dataArrayList = new ArrayList<>();
                String[] s = line.split(";");
                for (int i = 0; i < s.length; i++) {
                    String[] datas = s[i].trim().split("=");
                    dataArrayList.add(datas[1]);
                }
                line = br.readLine();
                customers.add(new Customer(dataArrayList.get(1), dataArrayList.get(3), dataArrayList.get(2), dataArrayList.get(4), dataArrayList.get(0)));
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    private void loadLog() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("logs.txt"));
            String line = br.readLine();
            while (line != null) { 
                String[] s0 = line.trim().split(":");
                if (s0.length == 2) {
                    String[] s1 = s0[1].trim().split(" ");
                    revenue = Integer.parseInt(s1[0]);
                    break;
                } else {
                    logs.add(line);
                    line = br.readLine();
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }
}
