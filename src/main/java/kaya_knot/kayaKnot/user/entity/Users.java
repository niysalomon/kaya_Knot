package kaya_knot.kayaKnot.user.entity;

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
public class Users {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private String id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String gender;
    private String martialStatus;
    private String phone;
    private String email;
    private String nationality;
    private String identityType;
    private String nidPassport;
    private boolean isLandLord;
    private String password;
    @Lob
    @Column(name="profile_picture" , columnDefinition = "LONGTEXT")
    private String profilePicture;
    @Lob
    @Column(name="cover_photo" , columnDefinition = "LONGTEXT")
    private String coverPhoto;
    @Column(name = "user_type", columnDefinition = "varchar(50) default 'RENTER'")
    private String userType;
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

    @Column(name = "lastLogin")
    private Timestamp lastLogin;




}
