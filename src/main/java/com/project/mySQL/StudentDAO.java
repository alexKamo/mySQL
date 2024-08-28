package com.project.mySQL;

public interface StudentDAO {

    void save (Student student);

    Student findById(Integer id);
}
