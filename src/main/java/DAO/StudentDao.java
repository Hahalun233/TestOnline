package DAO;

import beans.Student;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {

    public Student login(Student loginUser) throws SQLException {
        Connection connect = DBUtil.getConnection();
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement prepStmt = connect.prepareStatement(sql);
        prepStmt.setString(1,loginUser.getStu_name());
        prepStmt.setString(2,loginUser.getStu_password());
        ResultSet rs = prepStmt.executeQuery();
        Student student = new Student();
        if(rs.next()){
            student.setStu_name(rs.getString("students_name"));
            student.setStu_password(rs.getString("students_password"));
        }
        return student;
    }

    public Student register(Student registerUser) throws SQLException {
        Connection connect = DBUtil.getConnection();
        String sql = "insert students(id,students_name,students_password) values(?,?,?)";
        PreparedStatement prepStmt = connect.prepareStatement(sql);
        prepStmt.setInt(1,registerUser.getStu_id());
        prepStmt.setString(2,registerUser.getStu_name());
        prepStmt.setString(3,registerUser.getStu_password());
        prepStmt.execute();
        return registerUser;
    }
    public Student register_check(Student registerStudent) throws SQLException {
        Connection connect = DBUtil.getConnection();
        String sql = "select * from students where id = ?";
        PreparedStatement prepStmt = connect.prepareStatement(sql);
        prepStmt.setInt(1,registerStudent.getStu_id());
        ResultSet rs = prepStmt.executeQuery();
        Student  studnet = new Student();
        if(rs.next()){
            studnet.setStu_id(rs.getInt("id"));
        }
        return studnet;
    }

}
