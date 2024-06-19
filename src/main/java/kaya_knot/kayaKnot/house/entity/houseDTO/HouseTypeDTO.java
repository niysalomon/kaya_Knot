package kaya_knot.kayaKnot.house.entity.houseDTO;

import javax.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class HouseTypeDTO {
    private String id;
    private String houseType;
    private boolean isDeleted;
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;
}
