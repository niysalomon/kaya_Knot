package kaya_knot.kayaKnot.house.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
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
public class HouseSingleUnity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private String id;
    private String unityName;
    private String referenceNumber;
    private String unityStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house_id", nullable = false)
    @JsonManagedReference
    private House houseId;
    private String unityType; //Commercial,house part, single apartment, shop, office, or residential to display more details
    @Column(name = "bedrooms", columnDefinition = "boolean default 0")
    private int bedrooms;
    @Column(name = "bathrooms", columnDefinition = "boolean default 0")
    private int bathrooms;

    @Column(name = "salon", columnDefinition = "boolean default 0")
    private int salons;
    @Column(name = "dinning_room", columnDefinition = "boolean default 0")
    private int dinningRooms;
    @Column(name = "kitchen", columnDefinition = "boolean default 0")
    private int kitchen;
    private String description;
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
