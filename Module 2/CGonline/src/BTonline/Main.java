package BTonline;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[10];
        students[0] = new Student("Dung", 1, "dung@gmail.com", 9.0);
        students[1] = new Student("Huy", 2, "huy@gmail.com", 8.2);
        students[2] = new Student("bao", 3, "bao@gmail.com", 7.0);
        students[3] = new Student("cuong", 4, "cuong@gmail.com", 6.0);
        students[4] = new Student("long", 5, "long@gmail.com", 7.7);
        students[5] = new Student("quan", 6, "quan@gmail.com", 9.0);
        students[6] = new Student("kiet", 7, "kiet@gmail.com", 9.2);
        students[7] = new Student("hoang", 8, "hoang@gmail.com", 8.0);
        students[8] = new Student("thu", 9, "thu@gmail.com", 7.0);
        students[9] = new Student("mai", 10, "mai@gmail.com", 8.6);

        for (Student student : students) {
            if (student != null) {
                System.out.println(student.getInfo());
            }
        }
        System.out.println("==============");
        for (Student student : students) {
            if (student.getGPA() > 8.0) {
                System.out.println(student.getInfo());
            }
        }
    }
}
