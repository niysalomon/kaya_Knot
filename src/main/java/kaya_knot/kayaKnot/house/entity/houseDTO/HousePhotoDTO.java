package kaya_knot.kayaKnot.house.entity.houseDTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HousePhotoDTO {
    private String id;
    private String houseId;
    private String housePhoto;
    private String fileName;
    private String filePath;
    private String description;
}
