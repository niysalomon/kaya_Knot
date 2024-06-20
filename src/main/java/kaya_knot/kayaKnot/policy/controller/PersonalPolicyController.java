package kaya_knot.kayaKnot.policy.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.policy.entity.PersonalPolicy;
import kaya_knot.kayaKnot.policy.entity.dto.PersonalPolicyDTO;
import kaya_knot.kayaKnot.policy.service.PersonalPolicyService;
import kaya_knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kaya")
public class PersonalPolicyController {
    @Autowired
    private PersonalPolicyService personalPolicyService;
    @Autowired
    private UsersService usersService;
    @PostMapping("create_new_personal_policy")
    public ResponseEntity<Map<String,Object>> createNewPersonalPolicy(@RequestBody PersonalPolicyDTO personalPolicyDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            PersonalPolicy personalPolicy= new PersonalPolicy();
            personalPolicy.setPersonalPolicy(personalPolicyDTO.getPersonalPolicy());
            personalPolicy.setActive(true);
            personalPolicy.setUserId(usersService.fetchUserById(personalPolicyDTO.getUserId()));

            personalPolicyService.createNewPersonalPolicy(personalPolicy);
            map.put("status","success");
            map.put("data",personalPolicy);
            map.put("message","personal policy created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("update_personal_policy")
    public ResponseEntity<Map<String,Object>> updatePersonalPolicy(@RequestBody PersonalPolicyDTO personalPolicyDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            PersonalPolicy personalPolicy= new PersonalPolicy();
            personalPolicy.setPersonalPolicy(personalPolicyDTO.getPersonalPolicy());
            personalPolicy.setId(personalPolicyDTO.getId());
            personalPolicy.setUserId(usersService.fetchUserById(personalPolicyDTO.getUserId()));
            personalPolicyService.createNewPersonalPolicy(personalPolicy);
            map.put("status","success");
            map.put("data",personalPolicy);
            map.put("message","personal policy created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("get_personal_policy/{id}")
    public ResponseEntity<Map<String,Object>> getPersonalPolicy(@PathVariable("id") String id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            PersonalPolicy personalPolicy= personalPolicyService.fetchPersonalPolicyById(id);
            map.put("status","success");
            map.put("data",personalPolicy);
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

    @PostMapping("get_personal_policy_by_user/{id}")
    public ResponseEntity<Map<String,Object>> getPersonalPolicyByUser(@PathVariable("id") String user_id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<PersonalPolicy> personalPolicy= personalPolicyService.fetchPersonalPolicyByUser(user_id);
            map.put("status","success");
            map.put("data",personalPolicy);
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


}
