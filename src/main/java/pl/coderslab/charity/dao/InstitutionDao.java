package pl.coderslab.charity.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.Institution;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


    @Repository
    @Transactional
    public class InstitutionDao  {

        @PersistenceContext
        private EntityManager entityManager;

        public void saveInstitution(Institution institution) {
            entityManager.persist(institution);
        }
        public List<Institution> findAll() {
            return entityManager.createQuery("SELECT i FROM Institution i", Institution.class).getResultList();
        }
    }
