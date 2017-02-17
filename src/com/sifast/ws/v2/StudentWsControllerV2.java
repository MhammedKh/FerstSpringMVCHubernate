package com.sifast.ws.v2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sifast.entity.Student;
import com.sifast.service.StudentServiceImpl;
import com.sifast.service.UniversityServiceImpl;

@RestController
@Api(value = "student", description = "every thing about your student")
@RequestMapping(value = "/studentWScontrollerV2")
public class StudentWsControllerV2 {

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    UniversityServiceImpl universityService;

    @ApiOperation(value = "add student and get all of them")
    @RequestMapping(value = "/V1/addStudentWS", method = RequestMethod.GET, headers = "V1")
    public Response addStudentWs(@ApiParam(value = "student id", required = true) @RequestParam int id,
            @ApiParam(value = "student name", required = true) @RequestParam String name, @ApiParam(value = "student age", required = true) @RequestParam int age,
            @ApiParam(value = "university id", required = true) @RequestParam int idUniversity) {
        if (studentService.getStudentById(id) != null) {
            return Response.status(403).entity("student already exists").build();
        } else if (universityService.getUniversityById(idUniversity) == null) {
            return Response.status(403).entity("University not exists").build();
        } else {
            Student student = new Student();
            student.setId(id);
            student.setAge(age);
            student.setName(name);
            student.setUniversity(universityService.getUniversityById(idUniversity));
            studentService.addStudent(student);
            List<Student> studentList = studentService.listStudent();
            return Response.ok(studentList, MediaType.APPLICATION_JSON).build();

        }

    }

}
