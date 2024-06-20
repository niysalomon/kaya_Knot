package kaya_knot.kayaKnot.policy.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.policy.entity.UserRestriction;
import kaya_knot.kayaKnot.policy.entity.dto.UserRestrictionDTO;
import kaya_knot.kayaKnot.policy.service.UserRestrictionService;
import kaya_knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kaya")
public class UserRestrictionController {
    @Autowired
    private UserRestrictionService userRestrictionService;
    @Autowired
    private UsersService usersService;
    @PostMapping("create_new_personal_restriction")
    public ResponseEntity<Map<String,Object>> createNewPersonalRestriction(@RequestBody UserRestrictionDTO userRestrictionDTO, @AuthenticationPrincipal Principal principal, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            UserRestriction userRestriction= new UserRestriction();
            userRestriction.setNoise(userRestrictionDTO.getNoise());
            userRestriction.setSmoke(userRestrictionDTO.getSmoke());
            userRestriction.setPet(userRestrictionDTO.getPet());
            userRestriction.setCat(userRestrictionDTO.getCat());
            userRestriction.setUserId(usersService.fetchUserById(userRestrictionDTO.getUserId()));
            userRestriction.setActive(true);
            userRestriction.setDeleted(false);

            userRestrictionService.createNewUserRestriction(userRestriction);
            map.put("status","success");
            map.put("data",userRestriction);
            map.put("message","user restriction created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("update_personal_restriction")
    public ResponseEntity<Map<String,Object>> updatePersonalRestriction(@RequestBody UserRestrictionDTO userRestrictionDTO, @AuthenticationPrincipal Principal principal, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            UserRestriction userRestriction= new UserRestriction();
            userRestriction.setId(userRestrictionDTO.getId());
            userRestriction.setNoise(userRestrictionDTO.getNoise());
            userRestriction.setSmoke(userRestrictionDTO.getSmoke());
            userRestriction.setPet(userRestrictionDTO.getPet());
            userRestriction.setCat(userRestrictionDTO.getCat());
            userRestriction.setUserId(usersService.fetchUserById(userRestrictionDTO.getUserId()));
            userRestriction.setActive(true);
            userRestriction.setDeleted(false);

            userRestrictionService.createNewUserRestriction(userRestriction);
            map.put("status","success");
            map.put("data",userRestriction);
            map.put("message","Restriction updated successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("get_single_restriction/{id}")
    public ResponseEntity<Map<String,Object>> getPersonalPolicy(@PathVariable("id") String id,  @AuthenticationPrincipal Principal principal, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            UserRestriction userRestriction=userRestrictionService.fetchSingleUserRestrictionById(id);
            map.put("status","success");
            map.put("data",userRestriction);
            map.put("message","personal policy fetched successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("get_personal_restriction_by_user/{user_id}")
    public ResponseEntity<Map<String,Object>> getPersonalPolicyByUser(@PathVariable("user_id") String user_id, @AuthenticationPrincipal Principal principal, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<UserRestriction> userRestrictionList=userRestrictionService.fetchRestrictionsByUser(user_id);
            map.put("status","success");
            map.put("data",userRestrictionList);
            map.put("message","personal restriction fetched successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
        }
    }
}
