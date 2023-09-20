package dao;

import jakarta.persistence.EntityManagerFactory;
import model.Country;
import model.Person;

public class countryDAO {

    private static countryDAO instance;
    private static EntityManagerFactory emf;

    public static countryDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new countryDAO();
        }
        return instance;
    }

    public int saveCountry(Country country) {

        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();
        }
        return country.getId();

    }
}
