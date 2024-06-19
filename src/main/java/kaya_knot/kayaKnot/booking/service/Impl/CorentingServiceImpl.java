package kaya_knot.kayaKnot.booking.service.Impl;

import kaya_knot.kayaKnot.booking.entity.Corenting;
import kaya_knot.kayaKnot.booking.entity.dto.CorentingUserHouseDTO;
import kaya_knot.kayaKnot.booking.repo.CorentingRepo;
import kaya_knot.kayaKnot.booking.service.CorentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorentingServiceImpl implements CorentingService {
    @Autowired
    private CorentingRepo corentingRepo;
    @Override
    public Corenting createNewCorenting(Corenting corenting) {
        return corentingRepo.save(corenting);
    }

    @Override
    public List<CorentingUserHouseDTO> fetchCorentingByHouseStatusId(String status_id) {
//        return corentingRepo.fetchingHouseStatusId(status_id).stream().distinct().collect(Collectors.toList());
        return  null;
    }

    @Override
    public CorentingUserHouseDTO fetchCorentingDetailsByHouse(String house_id) {
//        return corentingRepo.fetchingCorentingDetailsByHouse(house_id);
        return null;
    }

}
