package com.druid.service.impl;

import com.druid.dao.StudentDao;
import com.druid.dao.impl.StudentDaoImpl;
import com.druid.domain.Student;
import com.druid.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> findAllStudent() {
        return studentDao.findAllStduent();
    }

    @Override
    public void addStudent(Student stu) {
        studentDao.addStudent(stu);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteStudentById(student.getSid());
    }

    @Override
    public List<Student> findStudentByName(String sname) {
        return studentDao.findStudentByName(sname);
    }
}
