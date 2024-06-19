package kaya_knot.kayaKnot.house.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.house.entity.HouseOffers;
import kaya_knot.kayaKnot.house.entity.houseDTO.HouseOfferDTO;
import kaya_knot.kayaKnot.house.service.HouseOfferService;
import kaya_knot.kayaKnot.house.service.HouseService;
import kaya_knot.kayaKnot.house.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HouseOfferController {
    @Autowired
    private OfferService offerService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseOfferService houseOfferService;
    @PostMapping("create_new_house_offer")
    public ResponseEntity<Map<String,Object>> createNewOffer(@RequestBody HouseOfferDTO houseOfferDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HouseOffers houseOffers = new HouseOffers();
            houseOffers.setHouse(houseService.fetchHouseById(houseOfferDTO.getHouse()));
            houseOffers.setOffer(offerService.fetchSingleOffer(houseOfferDTO.getOffers()));
            houseOffers.setActive(true);
            houseOfferService.createNewHouseOffer(houseOffers);
            map.put("status","success");
            map.put("data",houseOffers);
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

    @GetMapping("get_house_offer_by_house/{house_id}")
    public ResponseEntity<Map<String,Object>> getHouseOfferByHouse(@PathVariable("house_id") String house_id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<HouseOffers> houseOffers=houseOfferService.fetchByHousesId(house_id);
            map.put("status","success");
            map.put("data",houseOffers);
            map.put("message","house offers fetched successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        }
        catch (Exception e){
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("get_house_offer_by_offer/{offer_id}")
    public ResponseEntity<Map<String,Object>> getHouseOfferByOffer(@PathVariable("offer_id") String offer_id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<HouseOffers> houseOffers=houseOfferService.fetchByOffersId(offer_id);
            map.put("status","success");
            map.put("data",houseOffers);
            map.put("message","house offers fetched successful");
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
