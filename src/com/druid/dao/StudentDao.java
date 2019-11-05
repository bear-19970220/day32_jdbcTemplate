package com.druid.dao;

import com.druid.domain.Student;

import java.util.List;

public interface StudentDao {

    public abstract List<Student> findAllStduent();


    public abstract void addStudent(Student stu);

    public abstract void deleteStudentById(Integer sid);


    public abstract List<Student> findStudentByName(String sname);


}
