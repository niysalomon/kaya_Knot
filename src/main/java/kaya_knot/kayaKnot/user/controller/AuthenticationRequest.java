package kaya_knot.kayaKnot.user.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;

    // getters and setters
}

