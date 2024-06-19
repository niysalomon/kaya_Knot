package kaya_knot.kayaKnot.payload.response;


import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInformation {
    private String id;
    private String userName;
    private String email;
    private String accessToken;
    @Builder.Default
    private Map<String, Object> attributes = new HashMap<>();

    @Override
    public String toString() {
        return "UserInformation{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", attributes=" + attributes.toString() +
                '}';
    }
}

