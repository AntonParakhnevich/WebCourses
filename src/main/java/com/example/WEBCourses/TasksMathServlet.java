package com.example.WEBCourses;

import ITAcademy.Entity.Task;
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
@WebServlet(name = "TasksOnMath",value = "/tasksMath")
public class TasksMathServlet extends HttpServlet {
    private String message;
    private List<Task> tasks = new ArrayList<>();

    public void init() {
        message = "Task on Math";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        tasks = entityManager.createNativeQuery("select * FROM tasks  left join courses_tasks ct on T_ID=tasks.id where C_ID=1;", Task.class)
                .getResultList();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        for (Task t : tasks) {
            out.println("<h1>" + t.getName() + "</h1>");
        }
        out.println("<a href=\"index.jsp\">Home</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
