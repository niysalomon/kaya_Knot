package kaya_knot.kayaKnot.policy.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import kaya_knot.kayaKnot.house.entity.House;
import kaya_knot.kayaKnot.user.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class HouseRestriction {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private String id;
    private String pet;
    private String noise;
    private String smoke;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house_id", nullable = false)
    @JsonManagedReference
    private House houseId;
    private boolean isActive;
    private boolean isDeleted;
    @Column(name = "createdDate")
    @CreatedDate
    private Timestamp createdDate;

    @Column(name = "createdBy")
    @CreatedBy
    private String createdBy;

    @Column(name = "updatedDate")
    @LastModifiedDate
    private Timestamp updatedDate;

    @Column(name = "lastUpdatedBy")
    @LastModifiedBy
    private String lastUpdatedBy;
}
