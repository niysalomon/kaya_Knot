package kaya_knot.kayaKnot.locations.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NaturalId
    @Column(unique = true, name = "alpha2code")
    private String alpha2Code;

    @Column(unique = true)
    private String alpha3Code;

    @Column(unique = true)
    private String numericCode;

    @Column(name = "name_english")
    private String nameEnglish;

    @Column(name = "name_french")
    private String nameFrench;

    @Column(name = "name_kinyarwanda")
    private String nameKinyarwanda;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "continent_code")
    private String continentCode;
}
