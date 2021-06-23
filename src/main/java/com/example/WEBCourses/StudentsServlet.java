package com.example.WEBCourses;

import ITAcademy.Entity.Student;
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
@WebServlet(name = "Students", value = "/studentsMath")
public class StudentsServlet extends HttpServlet {
    private String message;
    private List<Student> students = new ArrayList<>();

    public void init() {
        message = "Students";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        List<Student> students = entityManager.createNativeQuery("select *\n" +
                "FROM students\n" +
                "         left join courses c on c.id = 1\n" +
                "         left join courses_students cs on S_ID = students.id\n" +
                "where C_ID = 1",Student.class).getResultList();
        entityManager.getTransaction().commit();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        for (Student s:students){
            out.println("<h1>" + s.getFirstName()+" "+s.getLastName()+ "</h1>");
        }
        out.println("<a href=\"index.jsp\">Home</a>");
        out.println("</body></html>");
    }
    public void destroy() {
    }
}
