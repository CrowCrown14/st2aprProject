package com.st2apr.project.st2aprproject.model.intern;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class InternSB {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<InternEntity> getAllInternFromATutor(String username) {
//        Query q = em.createNativeQuery("SELECT * FROM `Intern` WHERE tutorUsername = ?", InternEntity.class)
//                .setParameter(1, username);

        Query q = em.createQuery("SELECT e FROM InternEntity e WHERE e.tutorUsername = :tutorUsername")
                .setParameter("tutorUsername",username);
        return q.getResultList();
    }

    public List<InternEntity> getSpecificInternFromTutor(String username, String internId) {
//        Query q = em.createNativeQuery("SELECT * FROM `Intern` WHERE tutorUsername = ? and internId = ?", InternEntity.class)
//                .setParameter(1, username)
//                .setParameter(2, Integer.parseInt(internId));

        Query q = em.createQuery("SELECT e FROM InternEntity e WHERE e.tutorUsername = :tutorUsername and e.internId = :internId")
                .setParameter("tutorUsername", username)
                .setParameter("internId", Integer.parseInt(internId));
        return q.getResultList();
    }

    public void deleteIntern(String internId) {
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM InternEntity e WHERE e.internId = :internId")
                .setParameter("internId", Integer.parseInt(internId));

        q.executeUpdate();
        em.getTransaction().commit();
    }

    public void updateIntern(InternEntity internEntity) {

        em.getTransaction().begin();
        Query q = em.createQuery("update InternEntity e SET e.groupe = :groupe, e.nom = :nom, e.prenom = :prenom, e.cdc = :cdc, e.ficheVisite = :ficheVisite, e.ficheEvalEntreprise = :ficheEvalEntreprise, e.sondageWeb = :sondageWeb, e.rapportRendu = :rapportRendu, e.soutenance = :soutenance, e.planifier = :planifier, e.faite = :faite, e.debut = :debut, e.fin = :fin, e.entreprise = :entreprise, e.mdS = :mdS, e.adresse = :adresse, e.noteTechnique = :noteTechnique, e.noteCommunication = :noteCommunication where e.internId = :internId")
                .setParameter("groupe", internEntity.getGroupe())
                .setParameter("nom", internEntity.getNom())
                .setParameter("prenom", internEntity.getPrenom())
                .setParameter("cdc",internEntity.isCdc())
                .setParameter("ficheVisite",internEntity.isFicheVisite())
                .setParameter("ficheEvalEntreprise",internEntity.isFicheEvalEntreprise())
                .setParameter("sondageWeb",internEntity.isSondageWeb())
                .setParameter("rapportRendu",internEntity.isRapportRendu())
                .setParameter("soutenance",internEntity.isSoutenance())
                .setParameter("planifier",internEntity.isPlanifier())
                .setParameter("faite",internEntity.isFaite())
                .setParameter("debut",internEntity.getDebut())
                .setParameter("fin",internEntity.getFin())
                .setParameter("entreprise",internEntity.getEntreprise())
                .setParameter("mdS",internEntity.getMdS())
                .setParameter("adresse",internEntity.getAdresse())
                .setParameter("noteTechnique",internEntity.getNoteTechnique())
                .setParameter("noteCommunication",internEntity.getNoteCommunication())
                .setParameter("internId",internEntity.getInternId());
        q.executeUpdate();
        em.getTransaction().commit();
    }

    private int getNewId() {
        Query q = em.createQuery("SELECT max(e.internId) from InternEntity e");
        List<Integer> qIntegers = q.getResultList();

        int newId = 1;

        for (int integer : qIntegers) {
            newId = integer + 1;
        }

        return newId;
    }
    public void insertIntern(InternEntity internEntity) {

        internEntity.setInternId(getNewId());

        em.getTransaction().begin();

        Query q = em.createNativeQuery("INSERT INTO `Intern`(`groupe`,`nom`,`prenom`,`cdc`,`ficheVisite`,`ficheEvalEntreprise`, `sondageWeb`, `rapportRendu`, `soutenance`, `planifier`, `faite`, `debut`, `fin`, `entreprise`,`mdS`, `adresse`, `noteTechnique`, `noteCommunication`, `internId`,`tutorUsername`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")
                .setParameter(1, internEntity.getGroupe())
                .setParameter(2, internEntity.getNom())
                .setParameter(3, internEntity.getPrenom())
                .setParameter(4,(internEntity.isCdc()) ? 1 : 0)
                .setParameter(5,(internEntity.isFicheVisite()) ? 1 : 0)
                .setParameter(6,(internEntity.isFicheEvalEntreprise()) ? 1 : 0)
                .setParameter(7,(internEntity.isSondageWeb()) ? 1 : 0)
                .setParameter(8,(internEntity.isRapportRendu()) ? 1 : 0)
                .setParameter(9,(internEntity.isSoutenance()) ? 1 : 0)
                .setParameter(10,(internEntity.isPlanifier()) ? 1 : 0)
                .setParameter(11,(internEntity.isFaite()) ? 1 : 0)
                .setParameter(12,internEntity.getDebut())
                .setParameter(13,internEntity.getFin())
                .setParameter(14,internEntity.getEntreprise())
                .setParameter(15,internEntity.getMdS())
                .setParameter(16,internEntity.getAdresse())
                .setParameter(17,internEntity.getNoteTechnique())
                .setParameter(18,internEntity.getNoteCommunication())
                .setParameter(19,internEntity.getInternId())
                .setParameter(20,internEntity.getTutorUsername());
        q.executeUpdate();
        em.getTransaction().commit();
    }
}
