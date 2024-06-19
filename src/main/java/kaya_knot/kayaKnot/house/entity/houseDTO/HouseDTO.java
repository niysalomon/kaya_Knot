package kaya_knot.kayaKnot.house.entity.houseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HouseDTO {
    private String id ;
    private String houseName;
    private String landLordId;
    private String houseType;
    private String province;
    private String district;
    private String sector;
    private String cell;
    private String village;
    private boolean isFurnished;
    private int bedrooms;
    private int bathrooms;
    private int parkingCars;
    private boolean isAvailable;
    private String description;
    private String street;
    private String location;
    private String longitude;
    private String latitude;
    private boolean isActive;
    private boolean isDeleted;
}
