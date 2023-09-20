import config.HibernateConfig;
import model.Country;
import model.Person;
import model.Review;

public class Main {

    public static void main(String[] args) {

        HibernateConfig.addAnnotatedClasses(Person.class, Country.class, Review.class);
        emf = HibernateConfig.getEntityManagerFactoryConfig("trustpilot");


    }


}