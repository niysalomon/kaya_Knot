package kaya_knot.kayaKnot.house.service;

import kaya_knot.kayaKnot.house.entity.HousePhoto;
import kaya_knot.kayaKnot.house.entity.houseDTO.HousePhotoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HousePhotoService {
    HousePhoto createHousePhoto(HousePhoto housePhoto);
    int deleteHousePhoto(String id);
    List<HousePhoto> getHousePhotoByHouse(String house_id);


    HousePhoto uploadHousePhoto(MultipartFile file, HousePhotoDTO housePhotoDTO) throws IOException;
}
