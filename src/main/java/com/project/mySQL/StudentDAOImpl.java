package com.project.mySQL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        theQuery.setParameter("theData",theLastName);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByEmail(String email) {
        TypedQuery<Student> emailQuery = entityManager.createQuery("FROM Student WHERE email LIKE '%com'",Student.class);
        return emailQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstOrLastName(String frLsName) {
        TypedQuery<Student> frltName = entityManager.createQuery("FROM Student WHERE lastName=:nameData or firstName=:nameData",Student.class);
        frltName.setParameter("nameData",frLsName);
        return frltName.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateLastName(String lastName) {
        String query = "UPDATE Student SET lastName='"+lastName+"'";
        entityManager.createQuery(query).executeUpdate();
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = entityManager.find(Student.class,id);
        if(student != null) entityManager.remove(student);
    }

}
