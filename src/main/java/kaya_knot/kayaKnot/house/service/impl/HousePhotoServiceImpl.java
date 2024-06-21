package kaya_knot.kayaKnot.house.service.impl;

import kaya_knot.kayaKnot.house.entity.HousePhoto;
import kaya_knot.kayaKnot.house.entity.houseDTO.HousePhotoDTO;
import kaya_knot.kayaKnot.house.repo.HousePhotoRepo;
import kaya_knot.kayaKnot.house.service.HousePhotoService;
import kaya_knot.kayaKnot.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class HousePhotoServiceImpl implements HousePhotoService {
    @Autowired
    private HousePhotoRepo housePhotoRepo;
    @Autowired
    private HouseService houseService;


    @Value("${file.upload-dir}")
    private String uploadDir;

//    public HousePhotoServiceImpl() {
//        createUploadDirIfNotExists();
//    }

    private void createUploadDirIfNotExists() {
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
    @Override
    public HousePhoto createHousePhoto(HousePhoto housePhoto) {
        return housePhotoRepo.save(housePhoto);
    }

    @Override
    public int deleteHousePhoto(String id) {
        return housePhotoRepo.deleteHousePhoto(id);
    }

    @Override
    public List<HousePhoto> getHousePhotoByHouse(String house_id) {
        return housePhotoRepo.selectPhotoByHouse(house_id);
    }

    @Override
    public HousePhoto uploadHousePhoto(MultipartFile file, HousePhotoDTO housePhotoDTO) throws IOException {
        createUploadDirIfNotExists(); // Ensure the directory exists before saving the file
System.out.println("=-------------="+file);
System.out.println("-----------"+housePhotoDTO.getHouseId());
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
//        Files.copy(file.getInputStream(), filePath);

        HousePhoto housePhoto=new HousePhoto();
        housePhoto.setHouseId(houseService.fetchHouseById(housePhotoDTO.getHouseId()));
        housePhoto.setFilePath(filePath.toString());
        housePhoto.setFileName(fileName);
        housePhoto.setDescription(housePhotoDTO.getDescription());

        return housePhotoRepo.save(housePhoto);
    }
}
