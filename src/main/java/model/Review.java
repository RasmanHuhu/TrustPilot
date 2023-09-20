package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review {

    @Column(name = "stars")
    private int starRating;

    @Column(name = "title")
    private String title;

    @Column(length = 1000, name = "review_content")
    private String reviewContent;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_review")
    private LocalDate dateOfReview;

    @Temporal(TemporalType.DATE)
    @Column(name = "modified_date")
    private LocalDate modifiedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Person person;

}
