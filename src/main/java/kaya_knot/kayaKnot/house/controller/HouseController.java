package kaya_knot.kayaKnot.house.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.house.entity.House;
import kaya_knot.kayaKnot.house.entity.houseDTO.HouseDTO;
import kaya_knot.kayaKnot.house.service.HouseService;
import kaya_knot.kayaKnot.house.service.HouseTypeService;
import kaya_knot.kayaKnot.user.entity.Users;
import kaya_knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kaya")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseTypeService houseTypeService;
    @Autowired
    private UsersService usersService;
    @PostMapping("create_new_house")
    public ResponseEntity<Map<String,Object>> createNewHouseType(@RequestBody HouseDTO houseDTO,  Principal principal, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            Users loggedUser=usersService.findUserByEmail(principal.getName());
            System.out.println("=============="+principal.getName());
            House house=new House();
            house.setHouseType(houseTypeService.fetchHouseById(houseDTO.getHouseType()));
            house.setHouseName(houseDTO.getHouseName());
            house.setAvailable(houseDTO.isAvailable());
            house.setActive(true);
            house.setProvince(houseDTO.getProvince());
            house.setDistrict(houseDTO.getDistrict());
            house.setSector(houseDTO.getSector());
            house.setCell(houseDTO.getCell());
            house.setVillage(houseDTO.getVillage());
            house.setDescription(houseDTO.getDescription());
            house.setLocation(houseDTO.getLocation());
            house.setFurnished(houseDTO.isFurnished());
            house.setCreatedBy(loggedUser.getId());
            house.setLastUpdatedBy(loggedUser.getId());
            house.setCreatedDate(new Timestamp(new Date().getTime()));
            house.setUpdatedDate(new Timestamp(new Date().getTime()));
            house.setLandLordId(usersService.fetchUserById(houseDTO.getLandLordId()));
            houseService.createNewHouse(house);
            map.put("status","success");
            map.put("data",house);
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

    @PostMapping("update_house")
    public ResponseEntity<Map<String,Object>> updateHouseType(@RequestBody HouseDTO houseDTO,  Principal principal, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            House house=new House();
            Users loggedUser=usersService.findUserByEmail(principal.getName());
            house.setHouseType(houseTypeService.fetchHouseById(houseDTO.getHouseType()));
            house.setId(houseDTO.getId());
            house.setHouseName(houseDTO.getHouseName());
            house.setAvailable(houseDTO.isAvailable());
            house.setProvince(houseDTO.getProvince());
            house.setDistrict(houseDTO.getDistrict());
            house.setSector(houseDTO.getSector());
            house.setCell(houseDTO.getCell());
            house.setVillage(houseDTO.getVillage());
            house.setDescription(houseDTO.getDescription());
            house.setFurnished(houseDTO.isFurnished());
            house.setLastUpdatedBy(loggedUser.getId());
            house.setUpdatedDate(new Timestamp(new Date().getTime()));
            house.setLandLordId(usersService.fetchUserById(houseDTO.getLandLordId()));
            houseService.updateHouse(house);
            map.put("status","success");
            map.put("data",house);
            map.put("message","house updated successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("fetch_house/{id}")
    public ResponseEntity<Map<String,Object>> getHouseTypeById(@PathVariable("id") String id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            House house=houseService.fetchHouseById(id);
            map.put("status","success");
            map.put("data",house);
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

    @GetMapping("fetch_house_land_lord/{land_id}")
    public ResponseEntity<Map<String,Object>> getHouseTypeByLandLord(@PathVariable("land_id") String land_id, @AuthenticationPrincipal Principal principal, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<House> house=houseService.fetchHouseByLandLord(land_id);
            map.put("status","success");
            map.put("data",house);
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

    @GetMapping("get_all_house")
    public ResponseEntity<Map<String,Object>> getPersonalPolicyByUser( HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<House> houseList=houseService.fetchingAllHouse();
            map.put("status","success");
            map.put("data",houseList);
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
