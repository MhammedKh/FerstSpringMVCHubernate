package com.sifast.ws.v2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sifast.entity.University;
import com.sifast.service.StudentServiceImpl;
import com.sifast.service.UniversityServiceImpl;

@RestController
@Api(value = "university", description = "every thing about your university")
@RequestMapping(value = "/universityWScontroller")
public class UniversityWsControllerV2 {

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    UniversityServiceImpl universityService;

    @ApiOperation(value = " get all of university", consumes = "application/json")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<University> getAllUniversity() {
        List<University> universityList = universityService.listUniversities();
        return universityList;
    }
}