package dao;

import jakarta.persistence.EntityManagerFactory;
import model.Person;
import model.Review;

public class reviewDAO {

    private static reviewDAO instance;
    private static EntityManagerFactory emf;

    public static reviewDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new reviewDAO();
        }
        return instance;
    }

    public int saveReview(Review review) {

        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(review);
            em.getTransaction().commit();
        }
        return review.getId();

    }

    public Review getReviewById(String id) {
        Review review = null;

        try (var em = emf.createEntityManager()) {
           review = em.find(Review.class, id);

        }
        return review;
    }

    public Review updateReview(Review review) {

        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(review);
            em.getTransaction().commit();
        }
        return review;
    }

    public void deleteReview(String id) {

        try (var em = emf.createEntityManager()) {

            em.getTransaction().begin();
            Review review = getReviewById(id);
            if (review != null) {
                em.remove(review);
            }
            em.getTransaction().commit();
        }
    }
}
