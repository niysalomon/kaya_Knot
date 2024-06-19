package kaya_knot.kayaKnot.house.entity;

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


@Entity
@Getter
@Setter
@NoArgsConstructor
    public class House {
        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid")
        @Column(name = "id", unique = true, updatable = false, nullable = false)
        private String id;
        private String houseName;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "land_lord", nullable = false)
        @JsonManagedReference
        private Users landLordId;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "house_type", nullable = false)
        @JsonManagedReference
        private HouseType houseType;
        private String province;
        private String district;
        private String sector;
        private String cell;
        private String village;
        private String street;
        @Column(name = "is_furnished", columnDefinition = "boolean default false")
        private boolean isFurnished;

        @Column(name = "parking_cars", columnDefinition = "boolean default 0")
        private int parkingCars;
        private boolean isAvailable;
        private String description;
        private String location;
        private String longitude;
        private String latitude;
        @Column(name = "is_active", columnDefinition = "boolean default true")
        private boolean isActive;
        @Column(name = "is_deleted", columnDefinition = "boolean default false")
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

