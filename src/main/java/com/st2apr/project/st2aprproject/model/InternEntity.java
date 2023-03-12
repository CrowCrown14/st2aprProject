package com.st2apr.project.st2aprproject.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Intern", schema = "st2aprProject", catalog = "")
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
    private byte cdc;
    @Basic
    @Column(name = "ficheVisite", nullable = false)
    private byte ficheVisite;
    @Basic
    @Column(name = "sondageWeb", nullable = false)
    private byte sondageWeb;
    @Basic
    @Column(name = "rapportRendu", nullable = false)
    private byte rapportRendu;
    @Basic
    @Column(name = "soutenance", nullable = false)
    private byte soutenance;
    @Basic
    @Column(name = "planifier", nullable = false)
    private byte planifier;
    @Basic
    @Column(name = "faite", nullable = false)
    private byte faite;
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

    public byte getCdc() {
        return cdc;
    }

    public void setCdc(byte cdc) {
        this.cdc = cdc;
    }

    public byte getFicheVisite() {
        return ficheVisite;
    }

    public void setFicheVisite(byte ficheVisite) {
        this.ficheVisite = ficheVisite;
    }

    public byte getSondageWeb() {
        return sondageWeb;
    }

    public void setSondageWeb(byte sondageWeb) {
        this.sondageWeb = sondageWeb;
    }

    public byte getRapportRendu() {
        return rapportRendu;
    }

    public void setRapportRendu(byte rapportRendu) {
        this.rapportRendu = rapportRendu;
    }

    public byte getSoutenance() {
        return soutenance;
    }

    public void setSoutenance(byte soutenance) {
        this.soutenance = soutenance;
    }

    public byte getPlanifier() {
        return planifier;
    }

    public void setPlanifier(byte planifier) {
        this.planifier = planifier;
    }

    public byte getFaite() {
        return faite;
    }

    public void setFaite(byte faite) {
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

        InternEntity that = (InternEntity) o;

        if (internId != that.internId) return false;
        if (cdc != that.cdc) return false;
        if (ficheVisite != that.ficheVisite) return false;
        if (sondageWeb != that.sondageWeb) return false;
        if (rapportRendu != that.rapportRendu) return false;
        if (soutenance != that.soutenance) return false;
        if (planifier != that.planifier) return false;
        if (faite != that.faite) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (groupe != null ? !groupe.equals(that.groupe) : that.groupe != null) return false;
        if (debut != null ? !debut.equals(that.debut) : that.debut != null) return false;
        if (fin != null ? !fin.equals(that.fin) : that.fin != null) return false;
        if (entreprise != null ? !entreprise.equals(that.entreprise) : that.entreprise != null) return false;
        if (mdS != null ? !mdS.equals(that.mdS) : that.mdS != null) return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        if (noteTechnique != null ? !noteTechnique.equals(that.noteTechnique) : that.noteTechnique != null)
            return false;
        if (noteCommunication != null ? !noteCommunication.equals(that.noteCommunication) : that.noteCommunication != null)
            return false;
        if (descriptionMission != null ? !descriptionMission.equals(that.descriptionMission) : that.descriptionMission != null)
            return false;
        if (commentaire != null ? !commentaire.equals(that.commentaire) : that.commentaire != null) return false;
        if (tutorUsername != null ? !tutorUsername.equals(that.tutorUsername) : that.tutorUsername != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = internId;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (groupe != null ? groupe.hashCode() : 0);
        result = 31 * result + (int) cdc;
        result = 31 * result + (int) ficheVisite;
        result = 31 * result + (int) sondageWeb;
        result = 31 * result + (int) rapportRendu;
        result = 31 * result + (int) soutenance;
        result = 31 * result + (int) planifier;
        result = 31 * result + (int) faite;
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
