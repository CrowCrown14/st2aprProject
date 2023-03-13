package com.st2apr.project.st2aprproject.controller;

import com.st2apr.project.st2aprproject.model.tutor.TutorEntity;
import com.st2apr.project.st2aprproject.model.tutor.TutorSB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @EJB
    private TutorSB tsb;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doGet LoginServlet");

        HttpSession session = request.getSession();

        String usernameAttributeFromSession = "";

        String createdAccountMessage = "";

        for (String element : Collections.list(session.getAttributeNames())) {
            if (element.equals("username")) {
                usernameAttributeFromSession = (String) session.getAttribute("username");
            }
            if (element.equals("createdAccountMessage")) {
                createdAccountMessage = (String) session.getAttribute("createdAccountMessage");
                request.setAttribute("createdAccountMessage",createdAccountMessage);
                session.removeAttribute("createdAccountMessage");
            }
        }

        if (usernameAttributeFromSession.equals("")) {
            request.getRequestDispatcher("src/login.jsp").forward(request, response);

        }
        else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("doPost LoginServlet");
        String loginInputJSP = request.getParameter("loginField");
        String pwdInputJSP = request.getParameter("pwdField");

        ArrayList<TutorEntity> tutorFromDB = new ArrayList<>(tsb.getSpecificTutor(loginInputJSP));

        if (tutorFromDB != null) {
            if (tutorFromDB.size() <= 0) {
                sendErrorMessage(request, response, "Username doesn't exist");
            }
            else {
                if (tutorFromDB.get(0).getPassword().equals(pwdInputJSP)) {
                    HttpSession session = request.getSession();

                    session.setAttribute("username", tutorFromDB.get(0).getUsername());
                    session.setAttribute("lastName", tutorFromDB.get(0).getTutorLastName());
                    session.setAttribute("firstName", tutorFromDB.get(0).getTutorFirstName());

                    response.sendRedirect(request.getContextPath() + "/");
                }
                else {
                    sendErrorMessage(request, response, "Password invalid");
                }
            }


//            request.getRequestDispatcher("index.jsp").forward(request,response);
//            processRequest(request, response);
        }
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    private void sendErrorMessage(HttpServletRequest request, HttpServletResponse response, String message) throws IOException, ServletException {
        request.setAttribute("messageError",message);
        doGet(request,response);
    }

    public void destroy() {
    }
}