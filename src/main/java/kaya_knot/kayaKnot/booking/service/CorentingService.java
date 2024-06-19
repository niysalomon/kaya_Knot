package kaya_knot.kayaKnot.booking.service;

import kaya_knot.kayaKnot.booking.entity.Corenting;
import kaya_knot.kayaKnot.booking.entity.dto.CorentingUserHouseDTO;

import java.util.List;

public interface CorentingService {
    Corenting createNewCorenting(Corenting corenting);
    List<CorentingUserHouseDTO> fetchCorentingByHouseStatusId(String house_id);
    CorentingUserHouseDTO fetchCorentingDetailsByHouse(String house_id);

}
