package kaya_knot.kayaKnot.payload.response;

import lombok.*;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RequestResponse {
    private HttpStatus status;
    private String message;
    private Object data;
}
