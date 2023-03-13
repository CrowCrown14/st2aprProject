package com.st2apr.project.st2aprproject.controller;

import com.st2apr.project.st2aprproject.model.intern.InternEntity;
import com.st2apr.project.st2aprproject.model.intern.InternSB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "ModifyInternServlet", value = "/updateIntern")
public class ModifyInternServlet extends HttpServlet {

    @EJB
    InternSB isb;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getParameterValues("interns"));
        String formActionValue = (String) request.getParameter("formAction");

        // for Modify button
//        if (checkedInterns != null && formActionValue != null) {
//            if (checkedInterns.size() > 0 ) {
//                System.out.println("ok");
//            }
//        }
//        else {
            response.sendRedirect(request.getContextPath() + "/");
//        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("doPost ModifyInternServlet");

        if (request.getParameter("formAction") != null) {

            //click button Delete from excelIntern
            if (request.getParameter("formAction").equals("Delete")) {

                String[] checkedInterns = request.getParameterValues("selectedInterns");

                System.out.println(request.getParameter("formAction"));

                if (checkedInterns != null) {

                    for (String intern : checkedInterns) {
                        isb.deleteIntern(intern);
                    }
                }
            }


            //click button Modify from excelIntern
            if (request.getParameter("formAction").equals("Modify")) {

                String[] checkedInterns = request.getParameterValues("selectedInterns");

                System.out.println(request.getParameter("formAction"));

                if (checkedInterns != null) {

                    ArrayList<InternEntity> interns = new ArrayList<>();

                    for (String intern : checkedInterns) {
                        String tutorUsername = (String) request.getSession().getAttribute("username");
                        interns.addAll(isb.getSpecificInternFromTutor(tutorUsername, intern));
                    }

                    if (interns.size() > 0) {
                        request.setAttribute("interns", interns);
                        request.getRequestDispatcher("src/component/modifyAddIntern.jsp").forward(request, response);
                    }
                }
            }
        }
        if (request.getParameter("AddFromUpdate") != null) {
            //click button Add from modifyAddIntern
            if (request.getParameter("AddFromUpdate").equals("Add")) {
                System.out.println("Add From Update");
            }
        }

        response.sendRedirect(request.getContextPath() + "/");
    }

}
