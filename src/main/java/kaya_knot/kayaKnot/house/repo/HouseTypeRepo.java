package kaya_knot.kayaKnot.house.repo;

import kaya_knot.kayaKnot.house.entity.House;
import kaya_knot.kayaKnot.house.entity.HouseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseTypeRepo extends JpaRepository<HouseType, String> {
    @Query(value = "SELECT * FROM house_type  WHERE is_deleted=0 and is_active=1;",nativeQuery = true)
    public List<HouseType> findAllHouseType();
    @Query(value = "SELECT * FROM house_type WHERE id=:id and is_deleted=0 and is_active=1;",nativeQuery = true)
    public HouseType findHouseTypeById(String id);
}
