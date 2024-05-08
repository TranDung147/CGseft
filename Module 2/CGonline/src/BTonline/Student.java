package BTonline;

public class Student {
    public String name;
    public int id;
    public String email;
    public double GPA;

    public Student(String name, int id, String email, double GPA) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo(){
        return "Name: " + name + "\nID: " + id + "\nEmail: " + email + "\nGPA: " + GPA;
    }
}
