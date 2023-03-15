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

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    @EJB
    private TutorSB tsb;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doGet RegisterServlet");

        HttpSession session = request.getSession();

        String usernameAttributeFromSession = "";

        for (String element : Collections.list(session.getAttributeNames())) {
            if (element.equals("username")) {
                usernameAttributeFromSession = (String) session.getAttribute("username");
            }
        }

        if (usernameAttributeFromSession.equals("")) {
            request.getRequestDispatcher("src/register.jsp").forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doPost RegisterServlet");

        String loginInputJSP = request.getParameter("loginField");
        String pwdInputJSP = request.getParameter("pwdField");
        String pwdValidateInputJSP = request.getParameter("pwdValidateField");
        String firstNameInputJSP = request.getParameter("firstNameField");
        String lastNameInputJSP = request.getParameter("lastNameField");

        ArrayList<TutorEntity> tutorFromDB = new ArrayList<>(tsb.getSpecificTutor(loginInputJSP));

        if (tutorFromDB != null) {
            if (tutorFromDB.size() > 0) {
                sendErrorMessage(request, response, "Username already exists");
            }

            else if (!pwdInputJSP.equals(pwdValidateInputJSP)) {
                sendErrorMessage(request,response, "Password and Password confirmation are not the same");
            }
            else {
                TutorEntity tutor = new TutorEntity();
                tutor.setUsername(loginInputJSP);
                tutor.setPassword(pwdInputJSP);
                tutor.setTutorFirstName(firstNameInputJSP);
                tutor.setTutorLastName(lastNameInputJSP);
                tsb.insertOrUpdateTutor(tutor);

                HttpSession session = request.getSession();

                session.setAttribute("createdAccountMessage", "Your account has been created");

                response.sendRedirect(request.getContextPath() + "/login");
            }
        }


    }

    private void sendErrorMessage(HttpServletRequest request, HttpServletResponse response, String message) throws IOException, ServletException {
        request.setAttribute("messageError", message);
        doGet(request, response);
    }

    public void destroy() {
    }
}