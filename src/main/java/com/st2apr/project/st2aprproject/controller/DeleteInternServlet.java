package com.st2apr.project.st2aprproject.controller;

import com.st2apr.project.st2aprproject.model.InternSB;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteInternServlet", value = "/deleteIntern")
public class DeleteInternServlet extends HttpServlet {

    @EJB
    InternSB isb;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String[] checkedInterns = request.getParameterValues("selectedInterns");

        for (String intern : checkedInterns) {
            isb.deleteIntern(intern);
        }

        response.sendRedirect(request.getContextPath() + "/");
    }

}
