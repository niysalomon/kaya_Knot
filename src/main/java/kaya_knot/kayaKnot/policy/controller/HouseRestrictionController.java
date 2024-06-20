package kaya_knot.kayaKnot.policy.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.house.service.HouseService;
import kaya_knot.kayaKnot.policy.entity.HouseRestriction;
import kaya_knot.kayaKnot.policy.entity.dto.HouseRestrictionDTO;
import kaya_knot.kayaKnot.policy.service.HouseRestrictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kaya")
public class HouseRestrictionController {
    @Autowired
    private HouseRestrictionService houseRestrictionService;
    @Autowired
    private HouseService houseService;

    @PostMapping("create_house_restriction")
    public ResponseEntity<Map<String,Object>> createNewHouseRestriction(@RequestBody HouseRestrictionDTO houseRestrictionDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseRestriction houseRestriction=new HouseRestriction();
            houseRestriction.setPet(houseRestrictionDTO.getPet());
            houseRestriction.setSmoke(houseRestrictionDTO.getSmoke());
            houseRestriction.setNoise(houseRestrictionDTO.getNoise());
            houseRestriction.setActive(true);
            houseRestriction.setHouseId(houseService.fetchHouseById(houseRestrictionDTO.getHouseId()));
             houseRestrictionService.createNewHouseRestriction(houseRestriction);
            map.put("status","success");
            map.put("data",houseRestriction);
            map.put("message","house restriction created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("update_house_restriction")
    public ResponseEntity<Map<String,Object>> updatePersonalPolicy(@RequestBody HouseRestrictionDTO houseRestrictionDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseRestriction houseRestriction=new HouseRestriction();
            houseRestriction.setId(houseRestrictionDTO.getId());
            houseRestriction.setPet(houseRestrictionDTO.getPet());
            houseRestriction.setSmoke(houseRestrictionDTO.getSmoke());
            houseRestriction.setNoise(houseRestrictionDTO.getNoise());
            houseRestriction.setActive(true);
            houseRestriction.setHouseId(houseService.fetchHouseById(houseRestrictionDTO.getHouseId()));
            houseRestrictionService.updateHouseRestriction(houseRestriction);
            map.put("status","success");
            map.put("data",houseRestriction);
            map.put("message","house restriction updated successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("get_house_by_id/{id}")
    public ResponseEntity<Map<String,Object>> getSingleRestriction(@PathVariable("id") String id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseRestriction houseRestriction=houseRestrictionService.fetchHouseRestrictionById(id);
            map.put("status","success");
            map.put("data",houseRestriction);
            map.put("message","house restriction fetched successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("get_house_restriction_by_house/{house_id}")
    public ResponseEntity<Map<String,Object>> getHouseRestrictionByHouse(@PathVariable("house_id") String house_id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<HouseRestriction> houseRestrictionList=houseRestrictionService.fetchRestrictionByHouse(house_id);
            map.put("status","success");
            map.put("data",houseRestrictionList);
            map.put("message","house restriction fetched successful");
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
