package com.st2apr.project.st2aprproject.controller;

import com.st2apr.project.st2aprproject.model.intern.InternEntity;
import com.st2apr.project.st2aprproject.model.intern.InternSB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet(name = "AccueilServlet", value = "/")
public class AccueilServlet extends HttpServlet {

    @EJB
    InternSB isb;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doGet AccueilServlet");

        HttpSession session = request.getSession();

        String usernameAttributeFromSession = "";
        String firstNameAttributeFromSession = "";
        String lastNameAttributeFromSession = "";

        for (String element : Collections.list(session.getAttributeNames())) {
            if (element.equals("username")) {
                usernameAttributeFromSession = (String) session.getAttribute("username");
            }
            if (element.equals("firstName")) {
                firstNameAttributeFromSession = (String) session.getAttribute("firstName");
            }
            if (element.equals("lastName")) {
                lastNameAttributeFromSession = (String) session.getAttribute("lastName");
            }
        }

        if (usernameAttributeFromSession.equals("")) {
            response.sendRedirect(request.getContextPath() + "/login");
//            request.getRequestDispatcher("/login").forward(request, response);
        }
        else {
            request.setAttribute("username", usernameAttributeFromSession);
            request.setAttribute("firstName", firstNameAttributeFromSession);
            request.setAttribute("lastName", lastNameAttributeFromSession);

            ArrayList<InternEntity> interns = new ArrayList<>(isb.getAllInternFromATutor(usernameAttributeFromSession));

            if (interns.size() > 0) {
                for (int i = 0 ; i < interns.size() ; i++) {
                    System.out.println(interns.get(i).getNom());
                }
            }
            request.setAttribute("interns", interns);

            request.getRequestDispatcher("src/index.jsp").forward(request,response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doPost AccueilServlet");
        processRequest(request,response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "bonjour" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}