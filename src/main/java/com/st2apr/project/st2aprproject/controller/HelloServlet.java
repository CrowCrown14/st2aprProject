package com.st2apr.project.st2aprproject.controller;

import java.io.*;
import java.util.List;

import com.st2apr.project.st2aprproject.model.TutorEntity;
import com.st2apr.project.st2aprproject.model.TutorSB;
import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    @EJB
    private TutorSB tutorSB;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<TutorEntity> entities = tutorSB.getAllTutor();

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}