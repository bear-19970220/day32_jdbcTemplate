package com.druid.dao.impl;

import com.druid.dao.StudentDao;
import com.druid.domain.Student;
import com.druid.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> findAllStduent() {
        Connection conn = DruidUtils.getConnection();
        String sql = "select * from t_student";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>(0);
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            Student stu = null;
            while (rs.next()) {
                Integer sid = rs.getInt(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                stu = new Student(sid, sname, ssex);
                students.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeResource(rs, pstmt, conn);
        }
        return students;
    }

    @Override
    public void addStudent(Student student) {
        Connection conn = DruidUtils.getConnection();
        String sql = "insert into t_student values(?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, student.getSid());
            pstmt.setObject(2, student.getSname());
            pstmt.setObject(3, student.getSsex());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeResource(pstmt, conn);
        }
    }

    @Override
    public void deleteStudentById(Integer sid) {
        Connection conn = DruidUtils.getConnection();
        String sql = "delete from t_student where s_id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, sid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeResource(pstmt, conn);
        }
    }

    @Override
    public List<Student> findStudentByName(String sname) {
        Connection conn = DruidUtils.getConnection();
        String sql = "select * from t_student where s_name like ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>(0);
        Student stu = new Student();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, "%" + sname + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer sid = rs.getInt(1);
                String sname2 = rs.getString(2);
                String ssex = rs.getString(3);
                stu.setSid(sid);
                stu.setSname(sname2);
                stu.setSsex(ssex);
                students.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeResource(rs, pstmt, conn);
        }
        return students;
    }
}
