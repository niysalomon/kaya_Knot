package kaya_knot.kayaKnot.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.Map;
@Setter
@Getter
@NoArgsConstructor
public class CustomPrincipal implements Principal {

    private String user;
    private String names;
    private String type;
    public CustomPrincipal(String user,String names,String type) {
        this.user = user;
        this.names = names;
        this.type = type;
    }
    @Override
    public String getName() {
        return names;
    }


    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }
}
