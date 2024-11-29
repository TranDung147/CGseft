package controllers.demo1.service;

import controllers.demo1.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void saveStudent(Student student);
}
