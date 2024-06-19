package kaya_knot.kayaKnot.booking.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import kaya_knot.kayaKnot.house.entity.HouseSingleUnity;
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
public class HouseStatus {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private String id;
    private String houseUnity;// main ,unity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house_single_unity", nullable = false)
    @JsonManagedReference
    private HouseSingleUnity houseSingleUnity;
    private String landLordConfirmation;
    private String bookingStatus;
    private Long price;
    private String currency;
    private  boolean isActive;
    private boolean isDeleted;
    @Column(name = "createdDate")
    @CreatedDate
    private Timestamp createdDate;

    @Column(name = "createdBy")
    @CreatedBy
    private long createdBy;

    @Column(name = "updatedDate")
    @LastModifiedDate
    private Timestamp updatedDate;

    @Column(name = "lastUpdatedBy")
    @LastModifiedBy
    private long lastUpdatedBy;

}
