package kaya_knot.kayaKnot.house.repo;

import kaya_knot.kayaKnot.house.entity.House;
import kaya_knot.kayaKnot.house.entity.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffersRepo extends JpaRepository<Offers, String> {
    @Query(value = "SELECT * FROM offers  WHERE is_deleted=0 and is_active=1;",nativeQuery = true)
    public List<Offers> findAllOffers();
    @Query(value = "SELECT * FROM offers  WHERE id=:id and is_deleted=0 and is_active=1;",nativeQuery = true)
    public Offers findOfferById(String id);
}
