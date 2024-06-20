package kaya_knot.kayaKnot.configurations;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kaya_knot.kayaKnot.payload.response.CustomPrincipal;
import kaya_knot.kayaKnot.user.entity.Users;
import kaya_knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

@Autowired
private UsersService usersService;
    private String SECRET_KEY = "YAKAKNOT";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        String type=claims.get("type",String.class);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username) {
        Users users=usersService.findUserByEmail(username);
        Map<String, Object> claims = new HashMap<>();
        claims.put("user",users.getId());
        claims.put("type",users.getUserType());
        claims.put("names",users.getFirstName()+' '+users.getLastName());
    return createToken(claims, username);
    }
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    public CustomPrincipal getCustomPrincipalFromToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        String username = String.valueOf(getAllClaimsFromToken(token));
        String names = String.valueOf(getAllClaimsFromToken(token));
        String type = String.valueOf(getAllClaimsFromToken(token));
        Map<String, Object> additionalInfo = claims;

        return new CustomPrincipal(username, names,type);
    }
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }
}

