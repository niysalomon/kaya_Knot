package kaya_knot.kayaKnot.house.repo;

import kaya_knot.kayaKnot.house.entity.HousePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HousePhotoRepo extends JpaRepository<HousePhoto,String> {
    @Query(value = "SELECT * FROM house_photo WHERE house_id=:house_id and is_deleted=0",nativeQuery = true)
   public List<HousePhoto> selectPhotoByHouse(@Param("house_id") String house_id);
    @Query(value = "Update house_photo set is_deleted=true where id=:id",nativeQuery = true)
    int deleteHousePhoto(@Param("id") String id);
}
