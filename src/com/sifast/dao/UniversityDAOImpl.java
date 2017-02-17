package com.sifast.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sifast.entity.University;

@Repository("universityDao")
public class UniversityDAOImpl implements UniversityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveUniversity(University u) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(u);
        tx.commit();
        session.close();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<University> listUniversities() {
        Session session = this.sessionFactory.openSession();
        List<University> universties = session.createNamedQuery("University.findAll").getResultList();
        session.close();
        return universties;
    }

    @Override
    public University getUniversityFromId(int id) {
        Session session = this.sessionFactory.openSession();
        return session.get(University.class, id);
    }

}
