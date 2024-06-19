package kaya_knot.kayaKnot.booking.service.Impl;

import kaya_knot.kayaKnot.booking.entity.HouseStatus;
import kaya_knot.kayaKnot.booking.repo.HouseStatusRepo;
import kaya_knot.kayaKnot.booking.service.HouseStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseStatusServiceImpl implements HouseStatusService {
    @Autowired
    private HouseStatusRepo houseStatusRepo;
    @Override
    public HouseStatus createNewHouseStatus(HouseStatus houseStatus) {
        return houseStatusRepo.save(houseStatus);
    }

    @Override
    public HouseStatus updatePrice(HouseStatus houseStatus) {
        return houseStatusRepo.save(houseStatus);
    }

    @Override
    public HouseStatus fetchHouseStatusById(String id) {
        return houseStatusRepo.fetchHouseStatusById(id);
    }

    @Override
    public HouseStatus fetchHouseStatusByHouse(String unity_id) {
        return houseStatusRepo.fetchHouseStatusByHouseUnityId(unity_id);
    }

    @Override
    public int makeHouseAvailable(String house_id) {
        return houseStatusRepo.settingHouseAvailable(house_id);
    }

    @Override
    public int makeHouseOccupied(String house_id) {
        return houseStatusRepo.settingHouseOccupied(house_id);
    }
}
