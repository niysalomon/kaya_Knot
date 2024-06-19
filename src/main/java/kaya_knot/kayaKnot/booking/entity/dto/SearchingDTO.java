package kaya_knot.kayaKnot.booking.entity.dto;

import kaya_knot.kayaKnot.user.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor

public class SearchingDTO {
    private String id;
    private String userId;
    private Date minDateToMove;
    private Date maxDateToMove;
    private boolean rentWithFamily;
    private Long minBudget;
    private Long maxBudget;
    private String currency;
    private boolean readyToMove;
    private String country;
    private String province;
    private String district;
    private String Sector;
    private String cell;
    private String village;
    private boolean isSearching;
}
