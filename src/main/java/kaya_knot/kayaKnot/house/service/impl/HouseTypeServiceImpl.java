package kaya_knot.kayaKnot.house.service.impl;

import kaya_knot.kayaKnot.house.entity.HouseType;
import kaya_knot.kayaKnot.house.repo.HouseTypeRepo;
import kaya_knot.kayaKnot.house.service.HouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseTypeServiceImpl implements HouseTypeService {
    @Autowired
    private HouseTypeRepo houseTypeRepo;
    @Override
    public HouseType createNewHouseType(HouseType houseType) {
        return houseTypeRepo.save(houseType);
    }

    @Override
    public HouseType updateHouseType(HouseType houseType) {
        return houseTypeRepo.save(houseType);
    }

    @Override
    public HouseType fetchHouseById(String id) {
        return houseTypeRepo.findHouseTypeById(id);
    }

    @Override
    public List<HouseType> fetchAllHouseTypes() {
        return houseTypeRepo.findAllHouseType();
    }
}
