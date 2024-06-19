package kaya_knot.kayaKnot.policy.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.policy.entity.BookingPolicy;
import kaya_knot.kayaKnot.policy.entity.dto.BookingPolicyDTO;
import kaya_knot.kayaKnot.policy.service.BookingPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookingPolicyController {
    @Autowired
    private BookingPolicyService bookingPolicyService;
    @PostMapping("create_booking_policy")
    public ResponseEntity<Map<String,Object>> createNewBookingPolicy(@RequestBody BookingPolicyDTO bookingPolicyDTO, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        try {
            BookingPolicy bookingPolicy=new BookingPolicy();
            bookingPolicy.setBookingPolicy(bookingPolicyDTO.getBookingPolicy());
            bookingPolicyService.createNewBookingPolicy(bookingPolicy);
            map.put("message","booking policy created successful");
            map.put("status", "success");
            map.put("data",bookingPolicy);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }
        catch (Exception e) {
            map.put("message", e);
            map.put("status", "fail");
             e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
        }

    @PostMapping("update_booking_policy")
    public ResponseEntity<Map<String,Object>> updateBookingPolicy(@RequestBody BookingPolicyDTO bookingPolicyDTO, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        try {
            BookingPolicy bookingPolicy=new BookingPolicy();
            bookingPolicy.setBookingPolicy(bookingPolicyDTO.getId());
            bookingPolicy.setBookingPolicy(bookingPolicyDTO.getBookingPolicy());
            bookingPolicyService.createNewBookingPolicy(bookingPolicy);
            map.put("message","booking policy updated successful");
            map.put("status", "success");
            map.put("data",bookingPolicy);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }
        catch (Exception e) {
            map.put("message", e);
            map.put("status", "fail");
            e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/get_booking_policy", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getUsers(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<BookingPolicy> bookingPolicies=bookingPolicyService.fetchingBookingPolicy();
            map.put("message","Booking policies fetched successful");
            map.put("data",bookingPolicies);
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
