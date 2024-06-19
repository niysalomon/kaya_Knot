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

import java.sql.Blob;
import java.sql.Timestamp;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class HousePhoto {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house_id", nullable = false)
    @JsonManagedReference
    private House houseId;
    @Lob
    @Column(name="house_photo" , columnDefinition = "LONGTEXT")
    private String housePhoto;
    private String fileName;
    private String filePath;
    private String description;

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
