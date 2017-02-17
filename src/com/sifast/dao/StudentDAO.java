package com.sifast.dao;

import java.util.List;

import com.sifast.entity.Student;

public interface StudentDAO {

    void save(Student p);

    List<Student> list();

    Student getStudentFromId(int id);

}
