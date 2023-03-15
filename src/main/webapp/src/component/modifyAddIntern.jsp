<%@ page import="com.st2apr.project.st2aprproject.model.intern.InternEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../header/header.jsp"/>
<body>
<div class="mainDiv">
        <jsp:include page="../header/topPageWelcome.jsp"/>
        <%
                ArrayList<InternEntity> interns = (ArrayList<InternEntity>) request.getAttribute("interns");

                out.println("<table>");
                out.println("<form name='updateIntern' action='updateIntern' method='POST'>");
                out.println("<thead>");
                out.println("<th> Gr </th>");
                out.println("<th> NOM </th>");
                out.println("<th> PRENOM </th>");
                out.println("<th> CdC </th>");
                out.println("<th> FICHE VISITE </th>");
                out.println("<th> FICHE EVAL ENTR </th>");
                out.println("<th> SONDAGE WEB </th>");
                out.println("<th> RAPPORT RENDU </th>");
                out.println("<th> SOUT </th>");
                out.println("<th> PLANIF </th>");
                out.println("<th> FAITE </th>");
                out.println("<th> DEBUT </th>");
                out.println("<th> FIN </th>");
                out.println("<th> ENTR. </th>");
                out.println("<th> MdS </th>");
                out.println("<th> ADRESSE </th>");
                out.println("<th> NOTE TECH </th>");
                out.println("<th> NOTE COM </th>");
                out.println("</thead>");
                out.println("<tbody>");
                for (InternEntity intern : interns) {
                        out.println("<tr>");
                                out.println("<td>");
                                out.println("<input type='text' name='group" + intern.getInternId() + "' value='" + intern.getGroupe() +  "' size='2' required>");
                                out.println("</td>");
                                out.println("<td>");
                                out.println("<input type='text' name='nom" + intern.getInternId() + "' value='" + intern.getNom() +  "' size='5' required>");
                                out.println("</td>");
                                out.println("<td>");
                                out.println("<input type='text' name='prenom" + intern.getInternId() + "' value='" + intern.getPrenom() +  "' size='5' required>");
                                out.println("</td>");
                                out.println("<td>");
                                if (intern.isCdc())
                                        out.println("<input type='checkbox' id='cdc" + intern.getInternId() + "' name='selectedCdc" + intern.getInternId() +"' checked>");
                                else
                                        out.println("<input type='checkbox' id='cdc" + intern.getInternId() + "' name='selectedCdc" + intern.getInternId() +"'>");
                                out.println("</td>");
                                out.println("<td>");
                                if (intern.isFicheVisite())
                                        out.println("<input type='checkbox' id='ficheVisite" + intern.getInternId() + "' name='selectedFicheVisite" + intern.getInternId() +"' checked>");
                                else
                                        out.println("<input type='checkbox' id='ficheVisite" + intern.getInternId() + "' name='selectedFicheVisite" + intern.getInternId() +"'>");

                                out.println("</td>");
                                out.println("<td>");
                                if (intern.isFicheEvalEntreprise())
                                        out.println("<input type='checkbox' id='ficheEvalEntreprise" + intern.getInternId() + "' name='selectedFicheEvalEntreprise" + intern.getInternId() +"' checked>");
                                else
                                        out.println("<input type='checkbox' id='ficheEvalEntreprise" + intern.getInternId() + "' name='selectedFicheEvalEntreprise" + intern.getInternId() +"'>");
                                out.println("</td>");
                                out.println("<td>");
                                if (intern.isSondageWeb())
                                        out.println("<input type='checkbox' id='sondageWeb" + intern.getInternId() + "' name='selectedSondageWeb" + intern.getInternId() +"' checked>");
                                else
                                        out.println("<input type='checkbox' id='sondageWeb" + intern.getInternId() + "' name='selectedSondageWeb" + intern.getInternId() +"'>");
                                out.println("</td>");
                                out.println("<td>");
                                if (intern.isRapportRendu())
                                        out.println("<input type='checkbox' id='rapportRendu" + intern.getInternId() + "' name='selectedRapportRendu" + intern.getInternId() +"' checked>");
                                else
                                        out.println("<input type='checkbox' id='rapportRendu" + intern.getInternId() + "' name='selectedRapportRendu" + intern.getInternId() +"'>");
                                out.println("</td>");
                                out.println("<td>");
                                if (intern.isSoutenance())
                                        out.println("<input type='checkbox' id='soutenance" + intern.getInternId() + "' name='selectedSoutenance" + intern.getInternId() +"' checked>");
                                else
                                        out.println("<input type='checkbox' id='soutenance" + intern.getInternId() + "' name='selectedSoutenance" + intern.getInternId() +"'>");
                                out.println("</td>");
                                out.println("<td>");
                                if (intern.isPlanifier())
                                        out.println("<input type='checkbox' id='planifier" + intern.getInternId() + "' name='selectedPlanifier" + intern.getInternId() +"' checked>");
                                else
                                        out.println("<input type='checkbox' id='planifier" + intern.getInternId() + "' name='selectedPlanifier" + intern.getInternId() +"'>");
                                out.println("</td>");
                                out.println("<td>");
                                if (intern.isFaite())
                                        out.println("<input type='checkbox' id='faite" + intern.getInternId() + "' name='selectedFaite" + intern.getInternId() +"' checked>");
                                else
                                        out.println("<input type='checkbox' id='faite" + intern.getInternId() + "' name='selectedFaite" + intern.getInternId() +"'>");
                                out.println("</td>");
                                out.println("<td>");
                                if (intern.getDebut() != null)
                                        out.println("<input type='date' name='getDebut" + intern.getInternId() + "' value='" + intern.getDebut() +  "'>");
                                else
                                        out.println("<input type='date' name='getDebut" + intern.getInternId() + "' value=''>");
                                out.println("</td>");
                                out.println("<td>");
                                if (intern.getFin() != null)
                                        out.println("<input type='date' name='getFin" + intern.getInternId() + "' value='" + intern.getFin() +  "'>");
                                else
                                        out.println("<input type='date' name='getFin" + intern.getInternId() + "' value=''>");

                                out.println("</td>");
                                out.println("<td>");
                                if (intern.getEntreprise() != null)
                                        out.println("<input type='text' name='getEntreprise" + intern.getInternId() + "' value='" + intern.getEntreprise() +  "' size='5' >");
                                else
                                        out.println("<input type='text' name='getEntreprise" + intern.getInternId() + "' value='' size='5'>");

                                out.println("</td>");
                                out.println("<td>");
                                if (intern.getMdS() != null)
                                        out.println("<input type='text' name='getMdS" + intern.getInternId() + "' value='" + intern.getMdS() +  "' size='5'>");
                                else
                                        out.println("<input type='text' name='getMdS" + intern.getInternId() + "' value='' size='5'>");

                                out.println("</td>");
                                out.println("<td>");
                                if (intern.getAdresse() != null)
                                        out.println("<input type='text' name='getAdresse" + intern.getInternId() + "' value='" + intern.getAdresse() +  "' size='5'>");
                                else
                                        out.println("<input type='text' name='getAdresse" + intern.getInternId() + "' value='' size='5'>");
                                out.println("</td>");
                                out.println("<td>");
                                if (intern.getNoteTechnique() != null) {
                                        if (intern.getNoteTechnique() != -9999)
                                                out.println("<input type='number' name='getNoteTechnique" + intern.getInternId() + "' value='" + intern.getNoteTechnique() +  "'>");
                                        else
                                                out.println("<input type='number' name='getNoteTechnique" + intern.getInternId() + "' value=''>");

                                }
                                else
                                        out.println("<input type='number' name='getNoteTechnique" + intern.getInternId() + "' value=''>");

                                out.println("</td>");
                                out.println("<td>");
                                if (intern.getNoteCommunication() != null) {
                                        if (intern.getNoteCommunication() != -9999)
                                                out.println("<input type='number' name='getNoteCommunication" + intern.getInternId() + "' value='" + intern.getNoteCommunication() + "'>");
                                        else
                                                out.println("<input type='number' name='getNoteCommunication" + intern.getInternId() + "' value=''>");
                                }
                                else
                                        out.println("<input type='number' name='getNoteCommunication" + intern.getInternId() + "' value=''>");

                                out.println("</td>");
                        out.println("</tr>");
//                        out.println("<tr>");
//                        out.println("</tr>");
                }
                out.println("<tr>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                out.println("<input type='submit' name='ModifyFromUpdate' value='Modify'>");
                out.println("</td>");
                out.println("<td>");
                out.println("<input type='submit' name='CancelFromUpdate' value='Cancel'>");
                out.println("</td>");
                out.println("</tr>");
                out.println("</tbody>");
                out.println("</form>");
                out.println("</table>");
        %>
</div>
</body>
</html>

<style>
        <%@include file="/styles/style.css"%>
        table {
                border-collapse: collapse;
                width: 100%;
        }

        th, td {
                /*padding: 8px;*/
                text-align: left;
                border-bottom: 1px solid #ddd;
                border-left: 1px solid #ddd;
                border-right: 1px solid #ddd;
        }

        th {
                background-color: #f2f2f2;
        }

        /*thead th:first-child, tbody td:first-child {*/
        /*        width: 10%;*/
        /*}*/

        input[type="number"] {
                width: 40px;
        }

        input[type="checkbox"] {
                margin-right: 10px;
        }
</style>