package kaya_knot.kayaKnot.house.service.impl;

import kaya_knot.kayaKnot.house.entity.House;
import kaya_knot.kayaKnot.house.repo.HouseRepo;
import kaya_knot.kayaKnot.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepo houseRepo;

    @Override
    public House createNewHouse(House house) {
        return houseRepo.save(house);
    }

    @Override
    public House updateHouse(House house) {
        return houseRepo.save(house);
    }

    @Override
    public House fetchHouseById(String id) {
        return houseRepo.findHouseById(id);
    }

    @Override
    public List<House> fetchingAllHouse() {
        return houseRepo.findAllHouse();
    }

    @Override
    public List<House> fetchHouseByLandLord(String land_lord) {
        return houseRepo.findHouseByLandLord(land_lord);
    }

    @Override
    public List<House> fetchHouseByHouseType(String house_type) {
        return houseRepo.findHouseByHouseType(house_type);
    }
}
