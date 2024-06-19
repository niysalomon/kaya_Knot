package kaya_knot.kayaKnot.booking.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
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
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SearchRenting {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    private Users userId;
    private Date minDateToMove;
    private Date maxDateToMove;
    private boolean rentWithFamily;
    private Long minBudget;
    private Long maxBudget;
    private String currency;
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
    private boolean readyToMove;
    private String country;
    private String province;
    private String district;
    private String Sector;
    private String cell;
    private String village;
    private boolean isSearching;
    private boolean isActive;
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
