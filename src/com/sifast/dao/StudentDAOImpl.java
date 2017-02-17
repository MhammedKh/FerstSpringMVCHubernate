package com.sifast.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sifast.entity.Student;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void save(Student p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> list() {
        Session session = this.sessionFactory.openSession();
        List<Student> StudentList = session.createNamedQuery("Student.findAll").getResultList();
        session.close();
        return StudentList;
    }

    @Override
    public Student getStudentFromId(int id) {
        Session session = this.sessionFactory.openSession();
        return session.get(Student.class, id);

    }

}
