package com.sifast.dao;

import java.util.List;

import com.sifast.entity.University;

public interface UniversityDAO {

    void saveUniversity(University u);

    List<University> listUniversities();

    University getUniversityFromId(int id);

}
