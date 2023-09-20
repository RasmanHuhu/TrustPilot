package dao;

import jakarta.persistence.EntityManagerFactory;
import model.Person;

import java.math.BigDecimal;

public class personDAO {

    private static personDAO instance;
    private static EntityManagerFactory emf;


    public static personDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new personDAO();
        }
        return instance;
    }

//CRUD-metoder til databasen
     public int savePerson(Person person) {

            try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
        return person.getId();

    }

    public Person getPersonById(String id) {
        Person person = null;

        try (var em = emf.createEntityManager()) {
            person = em.find(Person.class, id);

        }
        return person;
    }

    public Person updatePerson(Person person) {

        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        }
        return person;
    }

    public void deletePerson(String id) {

        try (var em = emf.createEntityManager()) {

            em.getTransaction().begin();
            Person person = getPersonById(id);
            if (person != null) {
                em.remove(person);
            }
            em.getTransaction().commit();
        }
        }
}
