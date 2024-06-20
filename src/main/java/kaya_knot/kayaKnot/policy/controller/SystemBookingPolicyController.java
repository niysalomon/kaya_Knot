package kaya_knot.kayaKnot.policy.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.policy.entity.SystemBookingPolicy;
import kaya_knot.kayaKnot.policy.entity.dto.SystemBookingPolicyDTO;
import kaya_knot.kayaKnot.policy.service.SystemBookingPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kaya")
public class SystemBookingPolicyController {
   @Autowired
   private SystemBookingPolicyService systemBookingPolicyService;
    @PostMapping("create_bookingPolicy")
    public ResponseEntity<Map<String,Object>> createNewSystemBookingPolicy(@RequestBody SystemBookingPolicyDTO systemBookingPolicyDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            SystemBookingPolicy systemBookingPolicy = new SystemBookingPolicy();
            systemBookingPolicy.setBookingPolicy(systemBookingPolicyDTO.getBookingPolicy());
            systemBookingPolicy.setActive(true);
            systemBookingPolicy.setDeleted(false);
            systemBookingPolicyService.createNewSystemPolicy(systemBookingPolicy);
            map.put("status","success");
            map.put("message","system policy created successful");
            map.put("data",systemBookingPolicy);

        return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

    }
        catch (Exception e){
        map.put("status", "fail");
        map.put("message", e);
        e.printStackTrace();
        return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

    }
    }
    @PostMapping("update_bookingPolicy")
    public ResponseEntity<Map<String,Object>> updateSystemBookingPolicy(@RequestBody SystemBookingPolicyDTO systemBookingPolicyDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            SystemBookingPolicy systemBookingPolicy = new SystemBookingPolicy();
            systemBookingPolicy.setBookingPolicy(systemBookingPolicyDTO.getBookingPolicy());
            systemBookingPolicyService.updateSystemPolicy(systemBookingPolicy);
            map.put("status","success");
            map.put("message","system policy updated successful");
            map.put("data",systemBookingPolicy);
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @RequestMapping(value = "/get_system_policy", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getUsers(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<SystemBookingPolicy> systemBookingPolicies=systemBookingPolicyService.fetchAllSystemPolicies();
            map.put("message","system policies fetched successful");
            map.put("data",systemBookingPolicies);
            map.put("status", "success");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", e);
            map.put("status", "fail");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("get_single_system_booking_policy/{id}")
    public ResponseEntity<Map<String,Object>> fetchSingleBookingSystemPolicy(@PathVariable("id") String id, HttpServletRequest request){
        Map<String,Object> map= new HashMap<>();
        try {
            SystemBookingPolicy systemBookingPolicy=systemBookingPolicyService.fetchSinglePolicy(id);
            map.put("data",systemBookingPolicy);
            map.put("message","system policy fetched successful");
            map.put("status","success");
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);


        }
        catch (Exception e){
            e.printStackTrace();
            map.put("message", e);
            map.put("status", "fail");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);

        }
    }

}
