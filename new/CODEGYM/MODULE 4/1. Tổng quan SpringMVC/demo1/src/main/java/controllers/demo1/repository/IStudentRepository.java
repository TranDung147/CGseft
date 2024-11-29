package controllers.demo1.repository;

import controllers.demo1.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void saveStudent(Student student);
}
