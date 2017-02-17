package com.sifast.service;

import java.util.List;

import com.sifast.entity.Student;

public interface StudentService {

    void addStudent(Student p);

    List<Student> listStudent();

    Student getStudentById(int id);

}
