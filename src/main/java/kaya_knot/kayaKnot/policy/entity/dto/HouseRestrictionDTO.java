package kaya_knot.kayaKnot.policy.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
 public class HouseRestrictionDTO {
    private String id;
    private String pet;
    private String noise;
    private String smoke;

    private String houseId;
}
