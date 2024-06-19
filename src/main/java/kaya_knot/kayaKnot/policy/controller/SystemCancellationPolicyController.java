package kaya_knot.kayaKnot.policy.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.policy.entity.SystemCancellationPolicy;
import kaya_knot.kayaKnot.policy.entity.dto.SystemCancellationPolicyDTO;
import kaya_knot.kayaKnot.policy.service.SystemCancellationPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SystemCancellationPolicyController {
    @Autowired
    private SystemCancellationPolicyService systemCancellationPolicyService;
    @PostMapping("create_new_system_policy")
    public ResponseEntity<Map<String,Object>> createNewSystemPolicy(@RequestBody SystemCancellationPolicyDTO systemCancellationPolicyDTO, HttpServletRequest request){
            Map<String,Object> map=new HashMap<>();
            try {
                SystemCancellationPolicy systemBookingPolicy= new SystemCancellationPolicy();
                systemBookingPolicy.setSystemCancellationPolicy(systemCancellationPolicyDTO.getSystemCancellationPolicy());
                systemBookingPolicy.setActive(true);
                systemBookingPolicy.setDeleted(false);
                systemCancellationPolicyService.createNewSystemPolicy(systemBookingPolicy);
                map.put("status","success");
                map.put("message","system cancellation policy created successful");
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
        @PostMapping("update_cancellationPolicy")
        public ResponseEntity<Map<String,Object>> updateSystemBookingPolicy(@RequestBody SystemCancellationPolicyDTO systemCancellationPolicyDTO, HttpServletRequest request){
            Map<String,Object> map=new HashMap<>();
            try {
                SystemCancellationPolicy systemBookingPolicy= new SystemCancellationPolicy();
                systemBookingPolicy.setSystemCancellationPolicy(systemCancellationPolicyDTO.getSystemCancellationPolicy());
                systemBookingPolicy.setId(systemCancellationPolicyDTO.getId());
                systemCancellationPolicyService.updateSystemPolicy(systemBookingPolicy);
                map.put("status","success");
                map.put("message","system cancellation policy created successful");
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

        @RequestMapping(value = "/get_system_cancellation_policy", method = RequestMethod.GET)
        public ResponseEntity<Map<String, Object>> getUsers(HttpServletRequest request) {
            Map<String, Object> map = new HashMap<String, Object>();
            try {
                List<SystemCancellationPolicy> systemCancellationPolicies=systemCancellationPolicyService.fetchAllSystemPolicies();
                map.put("message","system cancellation policies fetched successful");
                map.put("data",systemCancellationPolicies);
                map.put("status", "success");
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                map.put("message", e);
                map.put("status", "fail");
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
            }
        }

        @PostMapping("get_single_system_cancellation_policy/{id}")
        public ResponseEntity<Map<String,Object>> fetchSingleBookingSystemPolicy(@PathVariable("id") String id, HttpServletRequest request){
            Map<String,Object> map= new HashMap<>();
            try {
                SystemCancellationPolicy systemCancellationPolicy=systemCancellationPolicyService.fetchSinglePolicy(id);
                map.put("data",systemCancellationPolicy);
                map.put("message","system cancellation policy fetched successful");
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