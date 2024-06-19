package kaya_knot.kayaKnot.booking.service.Impl;

import kaya_knot.kayaKnot.booking.entity.SearchRenting;
import kaya_knot.kayaKnot.booking.repo.SearchRentingRepo;
import kaya_knot.kayaKnot.booking.service.SearchRentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchRentingServiceImpl implements SearchRentingService {
    @Autowired
    private SearchRentingRepo searchRentingRepo;
    @Override
    public SearchRenting creatingNewSearch(SearchRenting searchRenting) {
        return searchRentingRepo.save(searchRenting);
    }
}
