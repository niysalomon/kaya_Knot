package kaya_knot.kayaKnot.booking.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
 public class UserHouseJoinDTO {
    private String id;
    private String houseStatusId;
    private String renterId;
    private String renterStatus;
    private String renterComment;
}
