package kaya_knot.kayaKnot.house.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.house.entity.HouseSingleUnity;
import kaya_knot.kayaKnot.house.entity.houseDTO.HouseSingleUnityDTO;
import kaya_knot.kayaKnot.house.service.HouseService;
import kaya_knot.kayaKnot.house.service.HouseSingleUnityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kaya")
public class singleHouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseSingleUnityService houseSingleUnityService;
    @PostMapping("create_new_unity")
    public ResponseEntity<Map<String,Object>> createNewHouseUnity(@RequestBody HouseSingleUnityDTO houseSingleUnityDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            HouseSingleUnity houseSingleUnity =new HouseSingleUnity();
            houseSingleUnity.setUnityName(houseSingleUnityDTO.getUnityName());
            houseSingleUnity.setReferenceNumber(houseSingleUnityDTO.getReferenceNumber());
            houseSingleUnity.setHouseId(houseService.fetchHouseById(houseSingleUnityDTO.getHouseId()));
            houseSingleUnity.setBathrooms(houseSingleUnityDTO.getBathrooms());
            houseSingleUnity.setBedrooms(houseSingleUnityDTO.getBedrooms());
            houseSingleUnity.setDinningRooms(houseSingleUnityDTO.getDinningRooms());
            houseSingleUnity.setKitchen(houseSingleUnityDTO.getKitchen());
            houseSingleUnity.setSalons(houseSingleUnityDTO.getSalons());
            houseSingleUnity.setDescription(houseSingleUnityDTO.getDescription());
            houseSingleUnity.setUnityType(houseSingleUnityDTO.getUnityType());
            houseSingleUnity.setActive(true);
            houseSingleUnity.setCreatedDate(timestamp);
            houseSingleUnity.setUpdatedDate(timestamp);
            houseSingleUnityService.createNewUnity(houseSingleUnity);
            map.put("status","success");
            map.put("data",houseSingleUnity);
            map.put("message","house created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }
    @PostMapping("update_new_unity")
    public ResponseEntity<Map<String,Object>> updateHouseUnity(@RequestBody HouseSingleUnityDTO houseSingleUnityDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            HouseSingleUnity houseSingleUnity =new HouseSingleUnity();
            houseSingleUnity.setId(houseSingleUnityDTO.getId());
            houseSingleUnity.setUnityName(houseSingleUnityDTO.getUnityName());
            houseSingleUnity.setReferenceNumber(houseSingleUnityDTO.getReferenceNumber());
            houseSingleUnity.setHouseId(houseService.fetchHouseById(houseSingleUnityDTO.getHouseId()));
            houseSingleUnity.setBathrooms(houseSingleUnityDTO.getBathrooms());
            houseSingleUnity.setBedrooms(houseSingleUnityDTO.getBedrooms());
            houseSingleUnity.setDinningRooms(houseSingleUnityDTO.getDinningRooms());
            houseSingleUnity.setSalons(houseSingleUnityDTO.getSalons());
            houseSingleUnity.setDescription(houseSingleUnityDTO.getDescription());
            houseSingleUnity.setUnityType(houseSingleUnityDTO.getUnityType());
            houseSingleUnity.setActive(true);
            houseSingleUnity.setCreatedDate(timestamp);
            houseSingleUnity.setUpdatedDate(timestamp);
            houseSingleUnityService.updateHouseUnity(houseSingleUnity);
            map.put("status","success");
            map.put("data",houseSingleUnity);
            map.put("message","unity created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("get_unity_by_house/{house_id}")
    public ResponseEntity<Map<String,Object>> getAllUnities(@PathVariable("house_id") String house_id, HttpServletRequest request){
        Map<String,Object> map= new HashMap<>();
        try {
            List<HouseSingleUnity> getUnitiesByHouse=houseSingleUnityService.getAllUnityByHouse(house_id);
            map.put("data",getUnitiesByHouse);
            map.put("message","unity fetched successful");
            map.put("status","success");
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
        }
        catch (Exception e){
            map.put("status","fail");
            map.put("message",e);
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("get_unity_by_landLord/{landLord_id}")
    public ResponseEntity<Map<String,Object>> getAllUnitiesByLandLord(@PathVariable("landLord_id") String landLord_id, HttpServletRequest request){
        Map<String,Object> map= new HashMap<>();
        try {
            List<HouseSingleUnity> getUnitiesByHouse=houseSingleUnityService.getAllUnityByLandLord(landLord_id);
            map.put("data",getUnitiesByHouse);
            map.put("message","unity fetched successful");
            map.put("status","success");
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
        }
        catch (Exception e){
            map.put("status","fail");
            map.put("message",e);
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("get_unity_by_id/{id}")
    public ResponseEntity<Map<String,Object>> getAllSingleUnit(@PathVariable("id") String id, HttpServletRequest request){
        Map<String,Object> map= new HashMap<>();
        try {
             HouseSingleUnity singleUnity=houseSingleUnityService.fetchUnityHouseById(id);
            map.put("data",singleUnity);
            map.put("message","single unity fetched successful");
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
