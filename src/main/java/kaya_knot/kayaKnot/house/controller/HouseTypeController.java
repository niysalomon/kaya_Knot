package kaya_knot.kayaKnot.house.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.house.entity.HouseType;
import kaya_knot.kayaKnot.house.entity.houseDTO.HouseTypeDTO;
import kaya_knot.kayaKnot.house.service.HouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HouseTypeController {
    @Autowired
    private HouseTypeService houseTypeService;
    @PostMapping("create_new_house_type")
    public ResponseEntity<Map<String,Object>> createNewHouseType(@RequestBody HouseTypeDTO houseTypeDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseType houseType=new HouseType();
            houseType.setHouseType(houseTypeDTO.getHouseType());
            houseType.setActive(true);
            houseTypeService.createNewHouseType(houseType);
            map.put("status","success");
            map.put("data",houseType);
            map.put("message","house type created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("update_house_type")
    public ResponseEntity<Map<String,Object>> updateHouseType(@RequestBody HouseTypeDTO houseTypeDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseType houseType=new HouseType();
            houseType.setHouseType(houseTypeDTO.getHouseType());
            houseType.setId(houseTypeDTO.getId());
            houseTypeService.createNewHouseType(houseType);
            map.put("status","success");
            map.put("data",houseType);
            map.put("message","house type updated successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("fetch_house_type/{id}")
    public ResponseEntity<Map<String,Object>> getHouseTypeById(@PathVariable("id") String id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseType houseType=houseTypeService.fetchHouseById(id);
            map.put("status","success");
            map.put("data",houseType);
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

    @GetMapping("get_all_house_type")
    public ResponseEntity<Map<String,Object>> getPersonalPolicyByUser( HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<HouseType> houseTypeList= houseTypeService.fetchAllHouseTypes();
            map.put("status","success");
            map.put("data",houseTypeList);
            map.put("message","house types fetched successful");
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
