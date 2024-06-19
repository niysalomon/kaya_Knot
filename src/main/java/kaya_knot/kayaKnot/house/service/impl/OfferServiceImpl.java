package kaya_knot.kayaKnot.house.service.impl;

import kaya_knot.kayaKnot.house.entity.Offers;
import kaya_knot.kayaKnot.house.repo.OffersRepo;
import kaya_knot.kayaKnot.house.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OffersRepo offersRepo;
    @Override
    public Offers createNewOffer(Offers offers) {
        return offersRepo.save(offers);
    }

    @Override
    public Offers updateOffer(Offers offers) {
          return offersRepo.save(offers);

    }

    @Override
    public List<Offers> fetchAllOffers() {
        return offersRepo.findAllOffers();
    }

    @Override
    public Offers fetchSingleOffer(String id) {
        return offersRepo.findOfferById(id);
    }
}
