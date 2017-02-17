package com.sifast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifast.dao.UniversityDAO;
import com.sifast.entity.University;

@Service("universityService")
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    UniversityDAO universityDao;

    @Override
    public void addUniversity(University p) {
        universityDao.saveUniversity(p);

    }

    @Override
    public List<University> listUniversities() {
        return universityDao.listUniversities();
    }

    @Override
    public University getUniversityById(int id) {
        return universityDao.getUniversityFromId(id);
    }

}
