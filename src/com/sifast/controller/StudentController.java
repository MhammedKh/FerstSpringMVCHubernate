package com.sifast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sifast.entity.Student;
import com.sifast.service.StudentServiceImpl;
import com.sifast.service.UniversityServiceImpl;

@Controller
@RequestMapping(value = "/studentcontroller")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    UniversityServiceImpl universityService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String student(ModelMap model) {
        model.addAttribute("student", new Student());
        model.addAttribute("universityList", universityService.listUniversities());
        return "student";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(@ModelAttribute("student") Student student, ModelMap model) {

        studentService.addStudent(student);
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());
        return "result";
    }

    @RequestMapping(value = "/allStudent", method = RequestMethod.GET)
    public String addStudent(ModelMap model) {
        List<Student> studentList = studentService.listStudent();
        model.addAttribute("studentList", studentList);
        return "allStudent";
    }

    @RequestMapping(value = "/studentId/{id}", method = RequestMethod.GET)
    public String studentId(@PathVariable(value = "id") int id, ModelMap model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());

        return "result";
    }

}