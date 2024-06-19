package kaya_knot.kayaKnot.house.repo;

import kaya_knot.kayaKnot.house.entity.House;
import kaya_knot.kayaKnot.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House , String> {
    @Query(value = "SELECT * FROM house  WHERE is_deleted=0 and is_active=1;",nativeQuery = true)
    public List<House> findAllHouse();
    @Query(value = "SELECT * FROM house  WHERE id=:id and is_deleted=0 and is_active=1;",nativeQuery = true)
    public House findHouseById(String id);

    @Query(value = "SELECT * FROM house  WHERE house_type=:house_type and is_deleted=0 and is_active=1;",nativeQuery = true)
    public List<House> findHouseByHouseType(String house_type);

    @Query(value = "SELECT * FROM house  WHERE land_lord=:land_lord and is_deleted=0 and is_active=1;",nativeQuery = true)
    public List<House> findHouseByLandLord(String land_lord);
}
