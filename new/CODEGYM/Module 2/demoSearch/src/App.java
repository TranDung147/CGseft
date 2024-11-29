public class App {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student(1, "Dung", 18, "nam");
        students[1] = new Student(2, "Quang", 20, "nam");
        students[2] = new Student(3, "Ngoc", 21, "nu");
        students[3] = new Student(4, "Thu", 20, "nu");
        students[4] = new Student(5, "Tam", 20, "nu");

        StudentManager sm = new StudentManager();
        for (int i = 0; i < students.length; i++) {
            sm.addStudent(students[i]);
        }
        sm.searchStudentByID(3);
    }

}
