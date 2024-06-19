package kaya_knot.kayaKnot.house.repo;

import kaya_knot.kayaKnot.house.entity.HouseOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseOfferRepo extends JpaRepository<HouseOffers,String> {
    @Query(value = "SELECT * FROM house_offers  WHERE house=:house_id and is_deleted=0 and is_active=1;",nativeQuery = true)
    public List<HouseOffers> findAllByHouse(String house_id);


    @Query(value = "SELECT * FROM house_offers  WHERE offer=:offer_id and is_deleted=0 and is_active=1;",nativeQuery = true)
    public List<HouseOffers> findHouseByOffer(String offer_id);
}
