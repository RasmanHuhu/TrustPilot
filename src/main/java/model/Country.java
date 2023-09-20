package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country {

    @Column(name = "country_name")
    private String countryName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private Set<Person> people;
}
