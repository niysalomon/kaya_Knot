package kaya_knot.kayaKnot.booking.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HouseStatusDTO {
    private String id;
    private String  houseSingleUnity;
    private String landLordConfirmation;
    private String bookingStatus;
    private Long price;
    private String currency;
}
