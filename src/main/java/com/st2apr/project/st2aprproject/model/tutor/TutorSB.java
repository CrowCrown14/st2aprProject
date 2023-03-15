package com.st2apr.project.st2aprproject.model.tutor;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class TutorSB {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<TutorEntity> getSpecificTutor(String username) {
        Query q = em
                .createQuery("select e from TutorEntity e where e.username = :username")
                .setParameter("username",username);
        return q.getResultList();
    }

    public void insertOrUpdateTutor(TutorEntity tutor) {

        em.persist(tutor);
    }
}
