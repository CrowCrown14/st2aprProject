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

    public void deleteIntern(String internId) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM `Intern` WHERE internId = ?")
                .setParameter(1, Integer.parseInt(internId));

        q.executeUpdate();
        em.getTransaction().commit();
    }
}
