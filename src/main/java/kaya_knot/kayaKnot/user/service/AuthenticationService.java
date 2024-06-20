package kaya_knot.kayaKnot.user.service;

import kaya_knot.kayaKnot.configurations.JwtUtil;
import kaya_knot.kayaKnot.payload.response.JwtResponse;
import kaya_knot.kayaKnot.user.controller.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public JwtResponse authenticateUser(AuthenticationRequest authenticationRequest) {
        Authentication authenticate;
        String jwt="";
        String user="";
        String message="";
        int status=0;
        try {
            authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
if( authenticate.getPrincipal()!="") {
                UserDetails userDetails = (UserDetails) authenticate.getPrincipal();
                 jwt = jwtUtil.generateToken(userDetails.getUsername());
                    user= userDetails.getUsername();
                    status=200;

                // Custom message and roles
                 message = "Authentication successful";
            }
            else{
    message = "Authentication Failed";

            }

        } catch (Exception e) {
            message = "Authentication Failed";
            status=501;
            return new JwtResponse(jwt, user, message,status);
        }
 return new JwtResponse(jwt, user, message, status);
    }
}

