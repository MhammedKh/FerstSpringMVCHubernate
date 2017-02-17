package com.sifast.service;

import java.util.List;

import com.sifast.entity.University;

public interface UniversityService {

    void addUniversity(University p);

    List<University> listUniversities();

    University getUniversityById(int id);

}
