package kaya_knot.kayaKnot.booking.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.booking.entity.SearchRenting;
import kaya_knot.kayaKnot.booking.entity.dto.SearchingDTO;
import kaya_knot.kayaKnot.booking.service.SearchRentingService;
import kaya_knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/kaya")
public class SearchingController {
    @Autowired
    private SearchRentingService searchRentingService;
    @Autowired
    private UsersService usersService;
    @PostMapping("create_searching")
    public ResponseEntity<Map<String,Object>> createNewHouseType(@RequestBody SearchingDTO searchingDTO, @AuthenticationPrincipal Principal principal, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            SearchRenting searchRenting=new SearchRenting();
            searchRenting.setCountry(searchingDTO.getCountry());
            searchRenting.setProvince(searchingDTO.getProvince());
            searchRenting.setDistrict(searchingDTO.getDistrict());
            searchRenting.setSector(searchingDTO.getSector());
            searchRenting.setCell(searchingDTO.getCell());
            searchRenting.setVillage(searchingDTO.getVillage());
            searchRenting.setMaxBudget(searchingDTO.getMaxBudget());
            searchRenting.setMaxBudget(searchingDTO.getMaxBudget());
            searchRenting.setCurrency(searchingDTO.getCurrency());
            searchRenting.setReadyToMove(searchingDTO.isReadyToMove());
            searchRenting.setRentWithFamily(searchingDTO.isRentWithFamily());
            searchRenting.setActive(true);
            searchRenting.setSearching(true);
            searchRenting.setUserId(usersService.fetchUserById(searchingDTO.getUserId()));
            searchRentingService.creatingNewSearch(searchRenting);
            map.put("status","success");
            map.put("data", searchRenting);
            map.put("message","your search recorded successful");
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
