package kaya_knot.kayaKnot.house.controller;

import javax.servlet.http.HttpServletRequest;

import kaya_knot.kayaKnot.house.entity.House;
import kaya_knot.kayaKnot.house.entity.HousePhoto;
import kaya_knot.kayaKnot.house.entity.houseDTO.HousePhotoDTO;
import kaya_knot.kayaKnot.house.service.HousePhotoService;
import kaya_knot.kayaKnot.house.service.HouseService;
import kaya_knot.kayaKnot.user.entity.Users;
import kaya_knot.kayaKnot.user.service.UsersService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kaya")
public class HousePhotoController {
    @Autowired
    private HousePhotoService housePhotoService;
    @Autowired
    private HouseService houseService;
    @Value("${file.upload-dir}")
    private String uploadDir;
    @Autowired
    private UsersService usersService;
    private static String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads";

    @PostMapping("/uploading")
    public ResponseEntity<Map<String,Object>> uploadFile(
            @RequestParam("file") MultipartFile[] files,
            @RequestParam("houseId") String houseId , Principal principal) {

        Map<String,Object> map=new HashMap<>();
        Users loggedUser=usersService.findUserByEmail(principal.getName());
        if (files.length<1) {
            map.put("status", "warning");
            map.put("message", "please select a ny attachment!");
        }
        House house=houseService.fetchHouseById(houseId);

        try {

            for (MultipartFile file : files) {
                Path path = Paths.get(UPLOAD_DIR + "/" + file.getOriginalFilename());
                file.transferTo(new File(path.toString()));
                String fileName = file.getOriginalFilename();
                Path filePath = Paths.get(uploadDir, fileName);
                Long size=file.getSize();
                String extension=file.getContentType();
                HousePhoto housePhoto=new HousePhoto();
                housePhoto.setHouseId(house);
                housePhoto.setFilePath(filePath.toString());
                housePhoto.setFileName(fileName);
                housePhoto.setSize(size);
                housePhoto.setExtension(extension);
                housePhoto.setCreatedBy(loggedUser.getId());
                housePhoto.setLastUpdatedBy(loggedUser.getId());
                housePhoto.setCreatedDate(new Timestamp(new Date().getTime()));
                housePhoto.setUpdatedDate(new Timestamp(new Date().getTime()));
                housePhoto.setDeleted(false);
                housePhotoService.createHousePhoto(housePhoto);
            }
            map.put("status","success");
            map.put("message","new offer created successful");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

        } catch (IOException e) {
            map.put("status", "fail");
            map.put("message", e);
            e.printStackTrace();
            return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);

        }}

    @PostMapping("create_house_photo")
    public ResponseEntity<Map<String,Object>> createNewOffer(@RequestBody HousePhotoDTO housePhotoDTO, @AuthenticationPrincipal Principal principal, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            HousePhoto housePhoto= new HousePhoto();
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


    @GetMapping("fetch_house_photo/{id}")
    public ResponseEntity<Map<String,Object>> getHousePhotoById(@PathVariable("id") String id, @AuthenticationPrincipal Principal principal, HttpServletRequest request){
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
    private void createUploadDirIfNotExists() {
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}
