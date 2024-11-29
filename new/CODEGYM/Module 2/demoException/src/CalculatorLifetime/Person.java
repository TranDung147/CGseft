package CalculatorLifetime;

public class Person {
    private int day;
    private int month;
    private int year;

    public Person() {
    }
    public Person(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() throws Exception {
        if (day < 1 || day > 31) {
            throw new Exception("Ngày không hợp lệ");
        }
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() throws Exception {
        if (month < 1 || month > 12) {
            throw new Exception("Tháng không hợp lệ");
        }
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() throws Exception {
        if (year > 2024) {
            throw new Exception("Năm không hợp lệ");
        }
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ngay=" + day+
                ", thang=" + month +
                ", nam=" + year +
                '}';
    }
}
