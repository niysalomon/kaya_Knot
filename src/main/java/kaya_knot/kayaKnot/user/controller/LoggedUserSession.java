package kaya_knot.kayaKnot.user.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kaya_knot.kayaKnot.user.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@NoArgsConstructor
public class LoggedUserSession {
    private Users users;

}
