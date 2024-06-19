package kaya_knot.kayaKnot.policy.service;

import kaya_knot.kayaKnot.policy.entity.HouseRestriction;

import java.util.List;
import java.util.Optional;

public interface HouseRestrictionService {
    HouseRestriction createNewHouseRestriction(HouseRestriction houseRestriction);
    HouseRestriction updateHouseRestriction(HouseRestriction houseRestriction);
     HouseRestriction fetchHouseRestrictionById(final String id);

     List<HouseRestriction> fetchRestrictionByHouse(String house_id);


}
