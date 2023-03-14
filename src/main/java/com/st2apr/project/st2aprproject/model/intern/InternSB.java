package com.st2apr.project.st2aprproject.model.intern;

import com.st2apr.project.st2aprproject.model.intern.InternEntity;
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
        Query q = em.createNativeQuery("SELECT * FROM `Intern` WHERE tutorUsername = ?", InternEntity.class)
                .setParameter(1, username);
        return q.getResultList();
    }

    public List<InternEntity> getSpecificInternFromTutor(String username, String internId) {
        Query q = em.createNativeQuery("SELECT * FROM `Intern` WHERE tutorUsername = ? and internId = ?", InternEntity.class)
                .setParameter(1, username)
                .setParameter(2, Integer.parseInt(internId));
        return q.getResultList();
    }

    public void deleteIntern(String internId) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM `Intern` WHERE internId = ?")
                .setParameter(1, Integer.parseInt(internId));

        q.executeUpdate();
        em.getTransaction().commit();
    }

    public void updateIntern(InternEntity internEntity) {

        em.getTransaction().begin();
        Query q = em.createNativeQuery("UPDATE `Intern` SET groupe = ?, nom = ?, prenom = ?, cdc = ?, ficheVisite = ?, ficheEvalEntreprise = ?, sondageWeb = ?, rapportRendu = ?, soutenance = ?, planifier = ?, faite = ?, debut = ?, fin  = ?, entreprise = ?,mdS = ?, adresse = ?, noteTechnique = ?, noteCommunication = ? WHERE  internId = ?")
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
                .setParameter(17,(internEntity.getNoteTechnique() == -9999) ? null : internEntity.getNoteTechnique())
                .setParameter(18,(internEntity.getNoteCommunication() == -9999) ? null : internEntity.getNoteCommunication())
                .setParameter(19,internEntity.getInternId());
        q.executeUpdate();
        em.getTransaction().commit();
    }
}
