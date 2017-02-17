package com.sifast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifast.dao.StudentDAO;
import com.sifast.entity.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO studentDao;

    @Override
    public void addStudent(Student p) {
        studentDao.save(p);

    }

    @Override
    public List<Student> listStudent() {
        return studentDao.list();
    }

    @Override
    public Student getStudentById(int id) {

        return studentDao.getStudentFromId(id);
    }

}
