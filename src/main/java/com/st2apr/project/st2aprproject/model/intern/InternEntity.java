package com.st2apr.project.st2aprproject.model.intern;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "`Intern`", schema = "st2aprProject", catalog = "")
public class InternEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "internId", nullable = false)
    private int internId;
    @Basic
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;
    @Basic
    @Column(name = "groupe", nullable = false, length = 10)
    private String groupe;
    @Basic
    @Column(name = "cdc", nullable = false)
    private boolean cdc;
    @Basic
    @Column(name = "ficheVisite", nullable = false)
    private boolean ficheVisite;
    @Basic
    @Column(name = "ficheEvalEntreprise", nullable = false)
    private boolean ficheEvalEntreprise;
    @Basic
    @Column(name = "sondageWeb", nullable = false)
    private boolean sondageWeb;
    @Basic
    @Column(name = "rapportRendu", nullable = false)
    private boolean rapportRendu;
    @Basic
    @Column(name = "soutenance", nullable = false)
    private boolean soutenance;
    @Basic
    @Column(name = "planifier", nullable = false)
    private boolean planifier;
    @Basic
    @Column(name = "faite", nullable = false)
    private boolean faite;
    @Basic
    @Column(name = "debut", nullable = true)
    private Date debut;
    @Basic
    @Column(name = "fin", nullable = true)
    private Date fin;
    @Basic
    @Column(name = "entreprise", nullable = true, length = 50)
    private String entreprise;
    @Basic
    @Column(name = "mdS", nullable = true, length = 50)
    private String mdS;
    @Basic
    @Column(name = "adresse", nullable = true, length = -1)
    private String adresse;
    @Basic
    @Column(name = "noteTechnique", nullable = true)
    private Integer noteTechnique;
    @Basic
    @Column(name = "noteCommunication", nullable = true)
    private Integer noteCommunication;
    @Basic
    @Column(name = "descriptionMission", nullable = true, length = -1)
    private String descriptionMission;
    @Basic
    @Column(name = "commentaire", nullable = true, length = -1)
    private String commentaire;
    @Basic
    @Column(name = "tutorUsername", nullable = false, length = 50)
    private String tutorUsername;

    public int getInternId() {
        return internId;
    }

    public void setInternId(int internId) {
        this.internId = internId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public boolean isCdc() {
        return cdc;
    }

    public void setCdc(boolean cdc) {
        this.cdc = cdc;
    }

    public boolean isFicheVisite() {
        return ficheVisite;
    }

    public void setFicheVisite(boolean ficheVisite) {
        this.ficheVisite = ficheVisite;
    }

    public boolean isFicheEvalEntreprise() {
        return ficheEvalEntreprise;
    }

    public void setFicheEvalEntreprise(boolean ficheEvalEntreprise) {
        this.ficheEvalEntreprise = ficheEvalEntreprise;
    }

    public boolean isSondageWeb() {
        return sondageWeb;
    }

    public void setSondageWeb(boolean sondageWeb) {
        this.sondageWeb = sondageWeb;
    }

    public boolean isRapportRendu() {
        return rapportRendu;
    }

    public void setRapportRendu(boolean rapportRendu) {
        this.rapportRendu = rapportRendu;
    }

    public boolean isSoutenance() {
        return soutenance;
    }

    public void setSoutenance(boolean soutenance) {
        this.soutenance = soutenance;
    }

    public boolean isPlanifier() {
        return planifier;
    }

    public void setPlanifier(boolean planifier) {
        this.planifier = planifier;
    }

    public boolean isFaite() {
        return faite;
    }

    public void setFaite(boolean faite) {
        this.faite = faite;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getMdS() {
        return mdS;
    }

    public void setMdS(String mdS) {
        this.mdS = mdS;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getNoteTechnique() {
        return noteTechnique;
    }

    public void setNoteTechnique(Integer noteTechnique) {
        this.noteTechnique = noteTechnique;
    }

    public Integer getNoteCommunication() {
        return noteCommunication;
    }

    public void setNoteCommunication(Integer noteCommunication) {
        this.noteCommunication = noteCommunication;
    }

    public String getDescriptionMission() {
        return descriptionMission;
    }

    public void setDescriptionMission(String descriptionMission) {
        this.descriptionMission = descriptionMission;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getTutorUsername() {
        return tutorUsername;
    }

    public void setTutorUsername(String tutorUsername) {
        this.tutorUsername = tutorUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InternEntity intern = (InternEntity) o;

        if (internId != intern.internId) return false;
        if (cdc != intern.cdc) return false;
        if (ficheVisite != intern.ficheVisite) return false;
        if (ficheEvalEntreprise != intern.ficheEvalEntreprise) return false;
        if (sondageWeb != intern.sondageWeb) return false;
        if (rapportRendu != intern.rapportRendu) return false;
        if (soutenance != intern.soutenance) return false;
        if (planifier != intern.planifier) return false;
        if (faite != intern.faite) return false;
        if (nom != null ? !nom.equals(intern.nom) : intern.nom != null) return false;
        if (prenom != null ? !prenom.equals(intern.prenom) : intern.prenom != null) return false;
        if (groupe != null ? !groupe.equals(intern.groupe) : intern.groupe != null) return false;
        if (debut != null ? !debut.equals(intern.debut) : intern.debut != null) return false;
        if (fin != null ? !fin.equals(intern.fin) : intern.fin != null) return false;
        if (entreprise != null ? !entreprise.equals(intern.entreprise) : intern.entreprise != null) return false;
        if (mdS != null ? !mdS.equals(intern.mdS) : intern.mdS != null) return false;
        if (adresse != null ? !adresse.equals(intern.adresse) : intern.adresse != null) return false;
        if (noteTechnique != null ? !noteTechnique.equals(intern.noteTechnique) : intern.noteTechnique != null)
            return false;
        if (noteCommunication != null ? !noteCommunication.equals(intern.noteCommunication) : intern.noteCommunication != null)
            return false;
        if (descriptionMission != null ? !descriptionMission.equals(intern.descriptionMission) : intern.descriptionMission != null)
            return false;
        if (commentaire != null ? !commentaire.equals(intern.commentaire) : intern.commentaire != null) return false;
        if (tutorUsername != null ? !tutorUsername.equals(intern.tutorUsername) : intern.tutorUsername != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = internId;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (groupe != null ? groupe.hashCode() : 0);
        result = 31 * result + (cdc ? 1 : 0);
        result = 31 * result + (ficheVisite ? 1 : 0);
        result = 31 * result + (ficheEvalEntreprise ? 1 : 0);
        result = 31 * result + (sondageWeb ? 1 : 0);
        result = 31 * result + (rapportRendu ? 1 : 0);
        result = 31 * result + (soutenance ? 1 : 0);
        result = 31 * result + (planifier ? 1 : 0);
        result = 31 * result + (faite ? 1 : 0);
        result = 31 * result + (debut != null ? debut.hashCode() : 0);
        result = 31 * result + (fin != null ? fin.hashCode() : 0);
        result = 31 * result + (entreprise != null ? entreprise.hashCode() : 0);
        result = 31 * result + (mdS != null ? mdS.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (noteTechnique != null ? noteTechnique.hashCode() : 0);
        result = 31 * result + (noteCommunication != null ? noteCommunication.hashCode() : 0);
        result = 31 * result + (descriptionMission != null ? descriptionMission.hashCode() : 0);
        result = 31 * result + (commentaire != null ? commentaire.hashCode() : 0);
        result = 31 * result + (tutorUsername != null ? tutorUsername.hashCode() : 0);
        return result;
    }
}
