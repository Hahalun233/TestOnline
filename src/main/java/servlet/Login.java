package servlet;

import DAO.TeacherDao;
import User.Teacher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String idStr = req.getParameter("id");
        int id = 0;
        if(idStr == null || idStr.equals("")) {
            id = 0;
        } else {
            id = Integer.parseInt(idStr);
        }
        String teacher_password = req.getParameter("teacher_password");

        //封装Teacher对象
        Teacher loginteacher = new Teacher();
        loginteacher.setId(id);
        loginteacher.setTeacher_password(teacher_password);

        TeacherDao dao = new TeacherDao();
        Teacher teacher = new Teacher();
        try {
            teacher = dao.login(loginteacher);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(teacher.getTeacher_name()==null){
            resp.getWriter().write("帐号或密码错误!");
        }else {
            req.setAttribute("teacher",teacher);
            //转发
            req.getRequestDispatcher("/question_select").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
