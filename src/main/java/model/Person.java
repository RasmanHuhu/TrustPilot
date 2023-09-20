package model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "person")
public class Person {

    @Column(name = "name")
    private String nameOfRegistrant;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Country country;

    @Column(name = "number_of_reviews")
    private int numbersOfReviews;

    @OneToMany(mappedBy = "person")
    private Set<Review> reviews;

@Builder
    public Person(String nameOfRegistrant, Country country, int numbersOfReviews) {
        this.nameOfRegistrant = nameOfRegistrant;
        this.country = country;
        this.numbersOfReviews = numbersOfReviews;
    }
}
