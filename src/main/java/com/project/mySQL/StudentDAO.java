package com.project.mySQL;

import java.util.List;

public interface StudentDAO {

    void save (Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    List<Student> findByEmail(String email);

    List<Student> findByFirstOrLastName(String frLsName);

    void update(Student student);

    void updateLastName(String lastName);

    void delete(int id);
}
