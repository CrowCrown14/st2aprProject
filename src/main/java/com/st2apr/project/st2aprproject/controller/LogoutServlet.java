package com.st2apr.project.st2aprproject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Collections;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doPost LogoutServlet");

        request.getSession();

        HttpSession session = request.getSession();

        for (String element : Collections.list(session.getAttributeNames())) {
            if (element.equals("username")) {
                session.setAttribute("username", "");
            }
            if (element.equals("lastName")) {
                session.setAttribute("lastName", "");
            }
            if (element.equals("firstName")) {
                session.setAttribute("firstName", "");
            }
        }

        System.out.println(session.getAttribute("username"));
        System.out.println(session.getAttribute("firstName"));
        System.out.println(session.getAttribute("lastName"));

        response.sendRedirect(request.getContextPath() + "/");
    }
}
