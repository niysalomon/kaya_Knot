package kaya_knot.kayaKnot.booking.service;

import kaya_knot.kayaKnot.booking.entity.HouseStatus;

public interface HouseStatusService {
    HouseStatus createNewHouseStatus(HouseStatus houseStatus);
    HouseStatus updatePrice(HouseStatus houseStatus);
    HouseStatus fetchHouseStatusById(String id);
    HouseStatus fetchHouseStatusByHouse(String house_id);
    int makeHouseAvailable(String house_id);
    int makeHouseOccupied(String house_id);

}
