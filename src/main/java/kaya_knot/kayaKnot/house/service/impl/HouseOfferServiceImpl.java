package kaya_knot.kayaKnot.house.service.impl;

import kaya_knot.kayaKnot.house.entity.HouseOffers;
import kaya_knot.kayaKnot.house.repo.HouseOfferRepo;
import kaya_knot.kayaKnot.house.service.HouseOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseOfferServiceImpl implements HouseOfferService {
    @Autowired
    private HouseOfferRepo houseOfferRepo;
    @Override
    public HouseOffers createNewHouseOffer(HouseOffers houseOffers) {
        return houseOfferRepo.save(houseOffers);
    }

    @Override
    public HouseOffers updateHouseOffer(HouseOffers houseOffers) {
        return houseOfferRepo.save(houseOffers);
    }

    @Override
    public List<HouseOffers> fetchByOffersId(String offer_id) {
        return houseOfferRepo.findHouseByOffer(offer_id);
    }

    @Override
    public List<HouseOffers> fetchByHousesId(String house_id) {
        return houseOfferRepo.findAllByHouse(house_id);
    }
}
