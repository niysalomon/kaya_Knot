package kaya_knot.kayaKnot.user.controller;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import kaya_knot.kayaKnot.configurations.JwtUtil;
import kaya_knot.kayaKnot.user.entity.UserType;
import kaya_knot.kayaKnot.user.entity.Users;
import kaya_knot.kayaKnot.user.entity.userDTO.UserTypeDTO;
import kaya_knot.kayaKnot.user.entity.userDTO.UsersDTO;
import kaya_knot.kayaKnot.user.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserTypeController {
    @Autowired
    private UserTypeService userTypeService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("create_new_user_type")
    public ResponseEntity<Map<String,Object>> createNewUser(@RequestBody UserTypeDTO userTypeDTO, Principal principal, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        try {
            System.out.println("principal======"+principal.getName());
            UserType userType= new UserType();
            userType.setUserType(userTypeDTO.getUserType());
            userTypeService.createNewUserType(userType);
            map.put("data", userType);
            map.put("status", "success");
            map.put("message", "user type created successful");

            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }
        catch (Exception e) {
            map.put("message", e);
            map.put("status", "fail");
             e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
        }

    @RequestMapping(value = "/get_users_types", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getUserTypes(Principal principal,  HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
            try {
                System.out.println("principal======"+principal.getName());
                List<UserType> userTypes=userTypeService.fetchUserTypes();
                map.put("message","user type fetched successful");
                map.put("userTypes",userTypes);
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            } catch (Exception e) {
                 e.printStackTrace();
                map.put("message", e);
                map.put("status", "fail");
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
            }

            }
}
