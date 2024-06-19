package kaya_knot.kayaKnot.house.controller;

import javax.servlet.http.HttpServletRequest;
import kaya_knot.kayaKnot.house.entity.HousePhoto;
import kaya_knot.kayaKnot.house.entity.houseDTO.HousePhotoDTO;
import kaya_knot.kayaKnot.house.service.HousePhotoService;
import kaya_knot.kayaKnot.house.service.HouseService;
import kaya_knot.kayaKnot.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HousePhotoController {
    @Autowired
    private HousePhotoService housePhotoService;
    @Autowired
    private HouseService houseService;
    @PostMapping("create_house_photo")
    public ResponseEntity<Map<String,Object>> createNewOffer(@RequestBody HousePhotoDTO housePhotoDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HousePhoto housePhoto= new HousePhoto();

            housePhoto.setHousePhoto(housePhotoDTO.getHousePhoto());
            housePhoto.setHouseId(houseService.fetchHouseById(housePhotoDTO.getHouseId()));
            housePhotoService.createHousePhoto(housePhoto);
             map.put("status","success");
            map.put("data",housePhoto);
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

    @PostMapping("/upload_house_photo")
    public ResponseEntity<HousePhoto> createNewHousePhoto(@RequestPart("file") MultipartFile file,
                                                                  @RequestPart("info") HousePhotoDTO housePhotoDTO, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        System.out.println("=============upload");
        try {
//            HousePhoto housePhoto= new HousePhoto();
//
//            housePhoto.setHousePhoto(housePhotoDTO.getHousePhoto());
//            housePhoto.setHouseId(houseService.fetchHouseById(housePhotoDTO.getHouseId()));
            HousePhoto housePhoto=housePhotoService.uploadHousePhoto(file,housePhotoDTO);
            map.put("status","success");
            map.put("data",housePhoto);
            map.put("message","new photo uploaded successful");
            return ResponseEntity.ok(housePhoto);
        }
        catch   (IOException e) {
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return ResponseEntity.status(500).build();

        }
    }
    @GetMapping("fetch_house_photo/{id}")
    public ResponseEntity<Map<String,Object>> getHousePhotoById(@PathVariable("id") String id, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            List<HousePhoto> housePhoto= housePhotoService.getHousePhotoByHouse(id);
            map.put("status","success");
            map.put("data",housePhoto);
            map.put("message","house photo fetched successful");
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
