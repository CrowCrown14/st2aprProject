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
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ModifyInternServlet", value = "/updateIntern")
public class ModifyInternServlet extends HttpServlet {

    @EJB
    InternSB isb;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

//                System.out.println(request.getParameter("formAction"));

                if (checkedInterns != null) {

                    for (String intern : checkedInterns) {
                        isb.deleteIntern(intern);
                    }
                }
            }


            //click button Modify from excelIntern
            if (request.getParameter("formAction").equals("Modify")) {

                String[] checkedInterns = request.getParameterValues("selectedInterns");

//                System.out.println(request.getParameter("formAction"));

                if (checkedInterns != null) {

                    ArrayList<InternEntity> interns = new ArrayList<>();

                    for (String intern : checkedInterns) {
                        String tutorUsername = (String) request.getSession().getAttribute("username");
                        interns.addAll(isb.getSpecificInternFromTutor(tutorUsername, intern));
                    }

                    if (interns.size() > 0) {
                        request.setAttribute("interns", interns);
                        request.getRequestDispatcher("src/component/modifyAddIntern.jsp").forward(request, response);
                        return;
                    }
                }
            }

            //click button Add from excelIntern
            if (request.getParameter("formAction").equals("Add")) {

                InternEntity newIntern = new InternEntity();
                newIntern.setTutorUsername((String) request.getSession().getAttribute("username"));
                newIntern.setCdc(false);
                newIntern.setFicheVisite(false);
                newIntern.setFicheEvalEntreprise(false);
                newIntern.setSondageWeb(false);
                newIntern.setRapportRendu(false);
                newIntern.setSoutenance(false);
                newIntern.setPlanifier(false);
                newIntern.setFaite(false);

                Iterator<String> parameterNames = request.getParameterNames().asIterator();

                while (parameterNames.hasNext()) {
                    String parameterName = parameterNames.next();
                    String parameterValue = request.getParameter(parameterName);

                    switch (parameterName) {
                        case "group":
                            newIntern.setGroupe(parameterValue);
                            break;
                        case "nom":
                            newIntern.setNom(parameterValue);
                            break;
                        case "prenom":
                            newIntern.setPrenom(parameterValue);
                            break;
                        case "selectedCdc":
                            newIntern.setCdc(true);
                            break;
                        case "selectedFicheVisite":
                            newIntern.setFicheVisite(true);
                            break;
                        case "selectedFicheEvalEntreprise":
                            newIntern.setFicheEvalEntreprise(true);
                            break;
                        case "selectedSondageWeb":
                            newIntern.setSondageWeb(true);
                            break;
                        case "selectedRapportRendu":
                            newIntern.setRapportRendu(true);
                            break;
                        case "selectedSoutenance":
                            newIntern.setSoutenance(true);
                            break;
                        case "selectedPlanifier":
                            newIntern.setPlanifier(true);
                            break;
                        case "selectedFaite":
                            newIntern.setFaite(true);
                            break;
                        case "getDebut":
                            if (!parameterValue.equals(""))
                                newIntern.setDebut(Date.valueOf(parameterValue));
                            break;
                        case "getFin":
                            if (!parameterValue.equals(""))
                                newIntern.setFin(Date.valueOf(parameterValue));
                            break;
                        case "getEntreprise":
                            newIntern.setEntreprise(parameterValue);
                            break;
                        case "getMdS":
                            newIntern.setMdS(parameterValue);
                            break;
                        case "getAdresse":
                            newIntern.setAdresse(parameterValue);
                            break;
                        case "getNoteTechnique":
                            if (!parameterValue.equals(""))
                                newIntern.setNoteTechnique(Integer.parseInt(parameterValue));
                            else
                                newIntern.setNoteTechnique(-9999);
                            break;
                        case "getNoteCommunication":
                            if (!parameterValue.equals(""))
                                newIntern.setNoteCommunication(Integer.parseInt(parameterValue));
                            else
                                newIntern.setNoteTechnique(-9999);
                            break;
                        default:
//                                        System.out.println("Should not happen");
                    }
                }

                isb.insertIntern(newIntern);
            }
        }
        if (request.getParameter("ModifyFromUpdate") != null) {
            //click button Add from modifyAddIntern
            if (request.getParameter("ModifyFromUpdate").equals("Add")) {

                Iterator<String> iterator = request.getParameterNames().asIterator();

                ArrayList<InternEntity> changedInterns = new ArrayList<>();

                while (iterator.hasNext()) {


                    String selectedNamePart = "";
                    String internId = "";

                    String informationFromForm = iterator.next();

                    String valueFromInformationFromForm = request.getParameter(informationFromForm);

//                    System.out.println(valueFromInformationFromForm);

                    if (! informationFromForm.equals("ModifyFromUpdate")) {

                        for (int i = 0; i < informationFromForm.length(); i++) {
                            if (Character.isAlphabetic(informationFromForm.charAt(i))) {
                                selectedNamePart += informationFromForm.charAt(i);
                            }
                            if (Character.isDigit(informationFromForm.charAt(i))) {
                                internId += informationFromForm.charAt(i);
                            }
                        }
                        boolean internExistInChangedInterns = false;
                        for (InternEntity intern : changedInterns) {
                            if (intern.getInternId() == Integer.parseInt(internId)) {
                                internExistInChangedInterns = true;

                            }
                        }
                        if (!internExistInChangedInterns) {
                            String tutorUsername = (String) request.getSession().getAttribute("username");
                            List<InternEntity> internEntities = isb.getSpecificInternFromTutor(tutorUsername, internId);

                            for (InternEntity intern : internEntities) {
                                intern.setCdc(false);
                                intern.setFicheVisite(false);
                                intern.setFicheEvalEntreprise(false);
                                intern.setSondageWeb(false);
                                intern.setRapportRendu(false);
                                intern.setSoutenance(false);
                                intern.setPlanifier(false);
                                intern.setFaite(false);
                            }

                            changedInterns.addAll(internEntities);

                        }

                        for (InternEntity intern : changedInterns) {
                            if (intern.getInternId() == Integer.parseInt(internId)) {
                                switch (selectedNamePart) {
                                    case "group":
                                        intern.setGroupe(valueFromInformationFromForm);
                                        break;
                                    case "nom":
                                        intern.setNom(valueFromInformationFromForm);
                                        break;
                                    case "prenom":
                                        intern.setPrenom(valueFromInformationFromForm);
                                        break;
                                    case "selectedCdc":
                                        intern.setCdc(true);
                                        break;
                                    case "selectedFicheVisite":
                                        intern.setFicheVisite(true);
                                        break;
                                    case "selectedFicheEvalEntreprise":
                                        intern.setFicheEvalEntreprise(true);
                                        break;
                                    case "selectedSondageWeb":
                                        intern.setSondageWeb(true);
                                        break;
                                    case "selectedRapportRendu":
                                        intern.setRapportRendu(true);
                                        break;
                                    case "selectedSoutenance":
                                        intern.setSoutenance(true);
                                        break;
                                    case "selectedPlanifier":
                                        intern.setPlanifier(true);
                                        break;
                                    case "selectedFaite":
                                        intern.setFaite(true);
                                        break;
                                    case "getDebut":
                                        if (!valueFromInformationFromForm.equals(""))
                                            intern.setDebut(Date.valueOf(valueFromInformationFromForm));
                                        break;
                                    case "getFin":
                                        if (!valueFromInformationFromForm.equals(""))
                                            intern.setFin(Date.valueOf(valueFromInformationFromForm));
                                        break;
                                    case "getEntreprise":
                                        intern.setEntreprise(valueFromInformationFromForm);
                                        break;
                                    case "getMdS":
                                        intern.setMdS(valueFromInformationFromForm);
                                        break;
                                    case "getAdresse":
                                        intern.setAdresse(valueFromInformationFromForm);
                                        break;
                                    case "getNoteTechnique":
                                        if (!valueFromInformationFromForm.equals(""))
                                            intern.setNoteTechnique(Integer.parseInt(valueFromInformationFromForm));
                                        else
                                            intern.setNoteTechnique(-9999);
                                        break;
                                    case "getNoteCommunication":
                                        if (!valueFromInformationFromForm.equals(""))
                                            intern.setNoteCommunication(Integer.parseInt(valueFromInformationFromForm));
                                        else
                                            intern.setNoteTechnique(-9999);
                                        break;
                                    default:
//                                        System.out.println("Should not happen");
                                }
                            }
                        }


                    }

                }

                for (InternEntity intern : changedInterns) {
                    isb.insertOrUpdateIntern(intern);
                }
            }


        }

        response.sendRedirect(request.getContextPath() + "/");
    }

}
