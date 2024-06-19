package kaya_knot.kayaKnot.booking.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.booking.entity.HouseStatus;
import kaya_knot.kayaKnot.booking.entity.dto.HouseStatusDTO;
import kaya_knot.kayaKnot.booking.service.HouseStatusService;
import kaya_knot.kayaKnot.house.service.HouseService;
import kaya_knot.kayaKnot.house.service.HouseSingleUnityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HouseStatusController {
    @Autowired
    private HouseStatusService houseStatusService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseSingleUnityService houseSingleUnityService;
    @PostMapping("create_new_house_status")
    public ResponseEntity<Map<String,Object>> createNewHouseType(@RequestBody HouseStatusDTO houseStatusDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseStatus houseStatus=new HouseStatus();

            houseStatus.setCurrency(houseStatusDTO.getCurrency());
            houseStatus.setLandLordConfirmation("AVAILABLE");
            houseStatus.setBookingStatus("NOT BOOKED");
            houseStatus.setLandLordConfirmation("PENDING");
            houseStatus.setPrice(houseStatusDTO.getPrice());
            houseStatus.setActive(true);
            System.out.println("-----"+houseSingleUnityService.fetchUnityHouseById(houseStatusDTO.getHouseSingleUnity()));
            houseStatus.setHouseSingleUnity(houseSingleUnityService.fetchUnityHouseById(houseStatusDTO.getHouseSingleUnity()));
            houseStatusService.createNewHouseStatus(houseStatus);
            map.put("status","success");
            map.put("data",houseStatus);
            map.put("message","house status created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("fetch_houseStatus_by_id/{id}")
    public ResponseEntity<Map<String,Object>> getHouseStatusById(@PathVariable("id") String id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseStatus houseStatus=houseStatusService.fetchHouseStatusById(id);
            map.put("status","success");
            map.put("data",houseStatus);
            map.put("message","house fetched successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("fetch_houseStatus_by_house/{house_id}")
    public ResponseEntity<Map<String,Object>> getHouseStatusByUserId(@PathVariable("house_id") String house_id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseStatus houseStatus=houseStatusService.fetchHouseStatusByHouse(house_id);
            map.put("status","success");
            map.put("data",houseStatus);
            map.put("message","house fetched successful");
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
