package kaya_knot.kayaKnot.locations.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NaturalId
    @Column(name = "code")
    private String code;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "cell_code", nullable = false, referencedColumnName = "code")
    private Cell cell;
}
