package kaya_knot.kayaKnot.house.service;

import kaya_knot.kayaKnot.house.entity.Offers;

import java.util.List;

public interface OfferService {
    Offers createNewOffer(Offers offers);
    Offers updateOffer(Offers offers);
    List<Offers> fetchAllOffers();

    Offers fetchSingleOffer(String id);
    
}
