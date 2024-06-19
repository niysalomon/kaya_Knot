package kaya_knot.kayaKnot.policy.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.policy.entity.CancellationPolicy;
import kaya_knot.kayaKnot.policy.entity.dto.CancellationPolicyDTO;
import kaya_knot.kayaKnot.policy.service.CancellationPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CancellationPolicyController {
    @Autowired
    private CancellationPolicyService cancellationPolicyService;
    @PostMapping("create_cancellation_policy")
    public ResponseEntity<Map<String,Object>> createNewCancellationPolicy(@RequestBody CancellationPolicyDTO cancellationPolicyDTO, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        try {
            CancellationPolicy cancellationPolicy=new CancellationPolicy();
            cancellationPolicy.setCancellation(cancellationPolicyDTO.getCancellation());
            cancellationPolicyService.createNewCancellationPolicy(cancellationPolicy);
            map.put("message","Cancellation policy created successful");
            map.put("status", "success");
            map.put("data",cancellationPolicy);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }
        catch (Exception e) {
            map.put("message", e);
            map.put("status", "fail");
            e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("update_cancellation_policy")
    public ResponseEntity<Map<String,Object>> updateBookingPolicy(@RequestBody CancellationPolicyDTO cancellationPolicyDTO, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        try {
            CancellationPolicy cancellationPolicy=new CancellationPolicy();
            cancellationPolicy.setId(cancellationPolicyDTO.getId());
            cancellationPolicy.setCancellation(cancellationPolicyDTO.getCancellation());
            cancellationPolicyService.updateCancellationPolicy(cancellationPolicy);
            map.put("message","cancellation policy updated successful");
            map.put("status", "success");
            map.put("data",cancellationPolicy);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }
        catch (Exception e) {
            map.put("message", e);
            map.put("status", "fail");
            e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/get_cancellation_policy", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getUsers(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<CancellationPolicy> cancellationPolicies=cancellationPolicyService.fetchAllCancellationPolicies();
            map.put("message","cancellation policies fetched successful");
            map.put("data",cancellationPolicies);
            map.put("status", "success");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", e);
            map.put("status", "fail");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }
}
