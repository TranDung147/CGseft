package controllers.demo1.repository;

import controllers.demo1.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository{
    private static final List<Student> studentsList;
    static {
        studentsList = new ArrayList<>();
        studentsList.add(new Student(1, "dung", "dung@gmail.com", 20));
        studentsList.add(new Student(2, "tam", "tam@gmail.com", 22));
        studentsList.add(new Student(3, "huy", "huy@gmail.com", 21));
    }
    @Override
    public List<Student> findAll() {
        return studentsList;
    }

    @Override
    public void saveStudent(Student student) {
        studentsList.add(student);
    }
}
