package kaya_knot.kayaKnot.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String username;
    private String message;
    private int status;

    public JwtResponse(String token, String username, String message ,int status) {
        this.token = token;
        this.username = username;
        this.message = message;
        this.status=status;
    }

    // Getters and setters
}
