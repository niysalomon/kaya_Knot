package kaya_knot.kayaKnot.house.service;

import kaya_knot.kayaKnot.house.entity.HouseSingleUnity;

import java.util.List;

public interface HouseSingleUnityService {
    HouseSingleUnity createNewUnity(HouseSingleUnity houseSingleUnity);
    HouseSingleUnity updateHouseUnity(HouseSingleUnity houseSingleUnity);
    HouseSingleUnity fetchUnityHouseById(String id);
    List<HouseSingleUnity> getAllUnityByHouse(String house_id);
    List<HouseSingleUnity> getAllUnityByLandLord(String landLord_id);

}
