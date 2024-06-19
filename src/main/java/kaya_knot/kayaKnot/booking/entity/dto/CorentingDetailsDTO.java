package kaya_knot.kayaKnot.booking.entity.dto;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CorentingDetailsDTO {
        private String corentingId;
        private String renterStatus;
        private String renterFirstName;
        private String email;
        private String houseStatus;
}
