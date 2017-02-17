package com.sifast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sifast.entity.University;
import com.sifast.service.UniversityServiceImpl;

@Controller
@RequestMapping(value = "/universitycontroller")
public class UniversityController {

    @Autowired
    UniversityServiceImpl universityService;

    @RequestMapping(value = "/university", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("university", "command", new University());
    }

    @RequestMapping(value = "/allUniversity", method = RequestMethod.POST)
    public String allniversity(University university, ModelMap model) {
        universityService.addUniversity(university);
        List<University> universityList = universityService.listUniversities();
        model.addAttribute("universityList", universityList);
        return "allUniversity";
    }

}
