package com.example.WEBCourses;

import ITAcademy.Entity.Teacher;
import ITAcademy.Util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by .
 */

@WebServlet(name = "TeachersOnMath", value = "/teacher")
public class TeacherMathServlet extends HttpServlet {
    private String message;
    private List<Teacher> teachers = new ArrayList<>();

    public void init() {
        message = "Teacher on Math";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        teachers = entityManager.createNativeQuery("select * from teachers where teachers.course_id=1", Teacher.class)
                .getResultList();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        for (Teacher t : teachers) {
            out.println("<h1>" + t.getName() + "</h1>");
        }
        out.println("<a href=\"index.jsp\">Home</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
