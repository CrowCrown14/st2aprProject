<%@ page import="com.st2apr.project.st2aprproject.model.intern.InternEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
<%
    ArrayList<InternEntity> interns = (ArrayList<InternEntity>) request.getAttribute("interns");


        out.println("<table>");
        out.println("<form name='deleteForm' action='deleteIntern' method='POST'>");
        out.println("<thead>");
        out.println("<th> Select </th>");
        out.println("<th> Gr </th>");
        out.println("<th> NOM </th>");
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
        for (int i = 0 ; i < interns.size() ; i++) {
            out.println("<tr>");
                out.println("<td>");
                out.println("<input type=\"checkbox\" id=\"intern" +  interns.get(i).getInternId() +"\" name=\"selectedInterns\" value=\""+ interns.get(i).getInternId() +"\">");
                out.println("</td>");
                out.println("<td>");
                out.println(interns.get(i).getGroupe());
                out.println("</td>");
                out.println("<td>");
                out.println(interns.get(i).getNom());
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).isCdc())
                    out.println("OUI");
                else
                   out.println("NON");
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).isFicheVisite())
                    out.println("OUI");
                else
                    out.println("NON");
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).isFicheEvalEntreprise())
                    out.println("OUI");
                else
                    out.println("NON");
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).isSondageWeb())
                    out.println("OUI");
                else
                    out.println("NON");
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).isRapportRendu())
                    out.println("OUI");
                else
                    out.println("NON");
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).isSoutenance())
                    out.println("OUI");
                else
                    out.println("NON");
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).isPlanifier())
                    out.println("OUI");
                else
                    out.println("NON");
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).isFaite())
                    out.println("OUI");
                else
                    out.println("NON");
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).getDebut() != null)
                    out.println(interns.get(i).getDebut());
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).getFin() != null)
                    out.println(interns.get(i).getFin());
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).getEntreprise() != null)
                    out.println(interns.get(i).getEntreprise());
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).getMdS() != null)
                    out.println(interns.get(i).getMdS());
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).getAdresse() != null)
                    out.println(interns.get(i).getAdresse());
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).getNoteTechnique() != null)
                    out.println(interns.get(i).getNoteTechnique());
                out.println("</td>");
                out.println("<td>");
                if (interns.get(i).getNoteCommunication() != null)
                    out.println(interns.get(i).getNoteCommunication());
                out.println("</td>");
            out.println("</tr>");
        }
        if (interns.size() > 0) {
            out.println("<tr>");
            out.println("<td>");
            out.println("<input type='submit' name='formAction' value='Modify'>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type='submit' name='formAction' value='Delete'>");
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</form>");
        out.println("</table>");
%>
</div>

<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
    }

    thead th:first-child, tbody td:first-child {
        width: 10%;
    }

    input[type="checkbox"] {
        margin-right: 10px;
    }
</style>