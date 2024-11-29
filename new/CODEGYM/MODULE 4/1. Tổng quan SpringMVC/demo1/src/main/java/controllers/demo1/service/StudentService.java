package controllers.demo1.service;

import controllers.demo1.model.Student;
import controllers.demo1.repository.IStudentRepository;
import controllers.demo1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.saveStudent(student);
    }
}
