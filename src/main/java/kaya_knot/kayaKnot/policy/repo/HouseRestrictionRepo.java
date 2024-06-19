package kaya_knot.kayaKnot.policy.repo;

import kaya_knot.kayaKnot.policy.entity.HouseRestriction;
import kaya_knot.kayaKnot.policy.entity.SystemBookingPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRestrictionRepo extends JpaRepository<HouseRestriction,String> {
    @Query(value = "SELECT * FROM house_restriction WHERE is_deleted=0 and is_active=1 and id=:id", nativeQuery = true)
    public HouseRestriction fetchSingleHouseRestriction(String id);

    @Query(value = "SELECT * FROM house_restriction WHERE is_deleted=0 and is_active=1 and house_id=:house_id", nativeQuery = true)
    public List<HouseRestriction> fetchSingleHouseRestrictionByHouse(String house_id);
}
