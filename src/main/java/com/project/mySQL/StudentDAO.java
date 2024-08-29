package com.project.mySQL;

import java.util.List;

public interface StudentDAO {

    void save (Student student);

    Student findById(Integer id);

    List<Student> findAll();
}
