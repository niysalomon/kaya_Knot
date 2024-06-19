package kaya_knot.kayaKnot.house.service;

import kaya_knot.kayaKnot.house.entity.House;

import java.util.List;

public interface HouseService {
    House createNewHouse(House house);
    House updateHouse(House house);
    House fetchHouseById(String id);
    List<House> fetchingAllHouse();

    List<House> fetchHouseByLandLord(String land_lord);
    List<House> fetchHouseByHouseType(String house_type);


}
