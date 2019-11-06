package com.druid.test;

import com.druid.domain.Student;
import com.druid.service.StudentService;
import com.druid.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class StudentTest {

    private StudentService studentService = new StudentServiceImpl();

    /**
     * 查询所有学生
     *
     * @throws Exception
     */
    @Test
    public void test_findAllStudents() throws Exception {
        StudentService studentService = new StudentServiceImpl();
        List<Student> students = studentService.findAllStudent();
        if (students != null && students.size() != 0) {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    /**
     * 添加学生
     *
     * @throws Exception
     */
    @Test
    public void test_addStudent() throws Exception {
        Student stu = new Student(6, "李四", "男");
        studentService.addStudent(stu);
        System.out.println("添加成功");
    }

    /**
     * 删除学生
     */
    @Test
    public void test_deleteStudent() {
        Student stu = new Student();
        stu.setSid(6);
        studentService.deleteStudent(stu);
        System.out.println("删除成功！");
    }

    /**
     * 按姓名查询学生
     */
    @Test
    public void test_findStudentByName() {
        List<Student> students = studentService.findStudentByName("三");
        if (students != null && students.size() > 0) {
            students.forEach((stu) -> System.out.println(stu));
        }
    }

    //dadadaadada

}
