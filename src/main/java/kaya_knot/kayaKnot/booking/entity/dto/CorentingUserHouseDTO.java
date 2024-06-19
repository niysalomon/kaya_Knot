package kaya_knot.kayaKnot.booking.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CorentingUserHouseDTO {
    private String corentingId;
    private String renterStatus;
    private String renterComment;
     private String renterId;
     private String houseStatusId;
     private String houseSingleUnity;

    public CorentingUserHouseDTO(String corentingId, String renterStatus, String renterComment, String renterId, String houseStatusId, String houseSingleUnity) {
        this.corentingId = corentingId;
        this.renterStatus = renterStatus;
        this.renterComment = renterComment;
        this.renterId = renterId;
        this.houseStatusId = houseStatusId;
        this.houseSingleUnity = houseSingleUnity;
    }
}
