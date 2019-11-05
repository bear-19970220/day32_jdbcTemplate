package com.druid.service;

import com.druid.domain.Student;

import java.util.List;

public interface StudentService {

    public abstract List<Student> findAllStudent() throws Exception;

    public abstract void addStudent(Student stu) throws Exception;

    public abstract void deleteStudent(Student student);

    public abstract List<Student> findStudentByName(String sname);


}
