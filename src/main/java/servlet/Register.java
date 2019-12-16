package servlet;

import DAO.TeacherDao;
import beans.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet(value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        String idStr = req.getParameter("id");
        int id = 0;
        if(idStr == null || idStr.equals("")) {
            id = 0;
        } else {
            id = Integer.parseInt(idStr);
        }
        String teacher_name = req.getParameter("teacher_name");
        String teacher_password = req.getParameter("teacher_password");

        //封装Teacher对象
        Teacher registerTeacher = new Teacher();
        registerTeacher.setId(id);
        registerTeacher.setTeacher_name(teacher_name);
        registerTeacher.setTeacher_password(teacher_password);

        TeacherDao dao = new TeacherDao();
        Teacher teacher = null;
        Teacher teacher_check = null;
        try {
            teacher = dao.register(registerTeacher);
            teacher_check = dao.register_check(registerTeacher);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(teacher.getId()==0||teacher.getTeacher_name()==null||teacher.getTeacher_password()==null) {
            resp.getWriter().write("注册用户信息缺失!");
        }else if(teacher_check.getTeacher_name()!=null){
            resp.getWriter().write("该用户已注册!");
        }else {
            req.setAttribute("teacher", teacher);
            req.getRequestDispatcher("/question_select").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
