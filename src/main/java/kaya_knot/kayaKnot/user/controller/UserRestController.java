package kaya_knot.kayaKnot.user.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.user.entity.UserType;
import kaya_knot.kayaKnot.user.entity.Users;
import kaya_knot.kayaKnot.user.entity.userDTO.UsersDTO;
import kaya_knot.kayaKnot.user.repo.UserTypeRepo;
import kaya_knot.kayaKnot.user.service.UserTypeService;
import kaya_knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserRestController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private UserTypeRepo userTypeRepo;
    @Autowired
    private UserTypeService userTypeService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("create_new_user")
    public ResponseEntity<Map<String,Object>> createNewUser(@RequestBody UsersDTO usersDTO, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        try {
            Users users= new Users();
            users.setFirstName(usersDTO.getFirstName());
            users.setLastName(usersDTO.getLastName());
            users.setLandLord(usersDTO.isLandLord());
            users.setGender(usersDTO.getGender());
            users.setNationality(usersDTO.getNationality());
            users.setIdentityType(usersDTO.getIdentityType());
            users.setNidPassport(usersDTO.getNidPassport());
            users.setPhone(usersDTO.getPhone());
            users.setPassword(passwordEncoder.encode( usersDTO.getPassword()));
            users.setUserType(userTypeService.getUserTypeById(usersDTO.getUserType()));
            users.setEmail(usersDTO.getEmail());
            users.setActive(true);
            users.setDeleted(false);
            users.setProfilePicture("usersDTO.getPassword(setProfilePicture)");
            users.setCoverPhoto("usersDTO.getPassword( setCoverPhoto)");
            usersService.createNewUser(users);
            map.put("data", users);
            map.put("message", "user created successful");
            map.put("status", "success");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }
        catch (Exception e) {
            map.put("message", e);
            map.put("status", "fail");
            // e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }

    }
    @RequestMapping(value = "/get_users", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getUsers(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Users> fetchedUsers=usersService.fetchAllUsers();
            map.put("data",fetchedUsers);
            map.put("message","users fetched successful");
            map.put("status", "success");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        } catch (Exception e) {
             e.printStackTrace();
            map.put("message", e);
            map.put("status", "fail");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
}


@GetMapping("get_single_user/{user_id}")
    public ResponseEntity<Map<String,Object>> getSingleUser(@PathVariable("user_id") String user_id,HttpServletRequest request){
        Map<String,Object> map= new HashMap<>();
        try {
            Users users=usersService.fetchUserById(user_id);
            map.put("data",users);
            map.put("message","user fetched successful");
            map.put("status","success");
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);


        }
        catch (Exception e){
            map.put("status","fail");
            map.put("message",e);
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
        }

    }
    }