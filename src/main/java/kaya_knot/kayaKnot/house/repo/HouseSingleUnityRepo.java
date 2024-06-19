package kaya_knot.kayaKnot.house.repo;

import kaya_knot.kayaKnot.house.entity.House;
import kaya_knot.kayaKnot.house.entity.HouseSingleUnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface HouseSingleUnityRepo extends JpaRepository<HouseSingleUnity,String> {
    @Query(value = "SELECT * FROM house_single_unity  WHERE id=:id ;",nativeQuery = true)
    public HouseSingleUnity findHouseUnityById(String id);

    @Query(value = "SELECT * FROM house_single_unity  WHERE house_id=:house_id and is_deleted=0 and is_active=1;",nativeQuery = true)
    public List<HouseSingleUnity> findAllHouseUnityByHouse(String house_id);

    @Query(value = "SELECT * FROM house_single_unity,house  WHERE house_single_unity.house_id=house.id and house.land_lord=:landLord_id and house_single_unity.is_deleted=0 and house_single_unity.is_active=1;",nativeQuery = true)
    public List<HouseSingleUnity> findAllHouseUnityByLandLord(String landLord_id);
}
