import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager(){
        this.students = new ArrayList<Student>();
    }

    public List<Student> getStudent(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void searchStudentByID(int ID){
        List<Student> data = new ArrayList<Student>();
        for(Student student : students){
            if(student.getID() == ID){
                data.add(student);
                System.out.println(student);
            }
        }
        if (data.size() == 0){
            System.out.println("Not found");
        }
    }
}
