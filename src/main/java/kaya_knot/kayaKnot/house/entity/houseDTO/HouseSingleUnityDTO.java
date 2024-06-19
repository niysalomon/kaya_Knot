package kaya_knot.kayaKnot.house.entity.houseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HouseSingleUnityDTO {
    private String id;
    private String unityName;
    private String referenceNumber;
    private String unityStatus;
    private String houseId;
    private String unityType; //Commercial,house part, single apartment, shop, office, or residential to display more details
    private int bedrooms;
    private int bathrooms;
    private int salons;
    private int dinningRooms;
    private int kitchen;
    private String description;
    private  boolean isActive;
}
