package kaya_knot.kayaKnot.house.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.house.entity.Offers;
import kaya_knot.kayaKnot.house.entity.houseDTO.OfferDTO;
import kaya_knot.kayaKnot.house.service.OfferService;
import kaya_knot.kayaKnot.policy.entity.HouseRestriction;
import kaya_knot.kayaKnot.policy.entity.dto.HouseRestrictionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;
    @PostMapping("create_new_offer")
    public ResponseEntity<Map<String,Object>> createNewOffer(@RequestBody OfferDTO offerDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            Offers offers=new Offers();
            offers.setOffer(offerDTO.getOffer());
            offers.setActive(true);
            offerService.createNewOffer(offers);
            map.put("status","success");
            map.put("data",offers);
            map.put("message","new offer created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("update_offer")
    public ResponseEntity<Map<String,Object>> updatePersonalPolicy(@RequestBody OfferDTO offerDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            Offers offers=new Offers();
            offers.setId(offerDTO.getId());
            offers.setOffer(offerDTO.getOffer());
            offers.setActive(true);
            offerService.createNewOffer(offers);
            map.put("status","success");
            map.put("data",offers);
            map.put("message","new offer created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("get_offer_by_id/{id}")
    public ResponseEntity<Map<String,Object>> getSingleRestriction(@PathVariable("id") String id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            Offers offers=offerService.fetchSingleOffer(id);
            map.put("status","success");
            map.put("data",offers);
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

    @GetMapping("get_all_offers")
    public ResponseEntity<Map<String,Object>> getSingleRestriction(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<Offers> offers=offerService.fetchAllOffers();
            map.put("status","success");
            map.put("data",offers);
            map.put("message","offers fetched successful");
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
