package DAO;

import User.Teacher;
import util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDao {
    public Teacher login(Teacher loginTeacher) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from Teacher where id = ? and password = ?";
        PreparedStatement prepStmt = connection.prepareStatement(sql);
        prepStmt.setInt(1,loginTeacher.getId());
        prepStmt.setString(2,loginTeacher.getTeacher_password());
        ResultSet rs = prepStmt.executeQuery();
        Teacher teacher = new Teacher();
        if(rs.next()){
            teacher.setId(rs.getInt("id"));
            teacher.setTeacher_name(rs.getString("teacher_name"));
            teacher.setTeacher_password(rs.getString("teacher_password"));
        }
        prepStmt.close();
        connection.close();
        return teacher;
    }

    public Teacher register(Teacher registerTeacher) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql = "insert teacher(id,teacher_name,teacher_password) values(?,?,?)";
        PreparedStatement prepStmt = connection.prepareStatement(sql);
        prepStmt.setInt(1,registerTeacher.getId());
        prepStmt.setString(2,registerTeacher.getTeacher_name());
        prepStmt.setString(3,registerTeacher.getTeacher_password());
        prepStmt.execute();
        prepStmt.close();
        connection.close();
        return registerTeacher;
    }

    public Teacher register_check(Teacher registerTeacher) throws SQLException {
        Connection connect = DBUtil.getConnection();
        String sql = "select * from teacher where id = ?";
        PreparedStatement prepStmt = connect.prepareStatement(sql);
        prepStmt.setInt(1,registerTeacher.getId());
        ResultSet rs = prepStmt.executeQuery();
        Teacher teacher = new Teacher();
        if(rs.next()){
            teacher.setId(rs.getInt("id"));
        }
        rs.close();
        prepStmt.close();
        connect.close();
        return teacher;
    }


}
