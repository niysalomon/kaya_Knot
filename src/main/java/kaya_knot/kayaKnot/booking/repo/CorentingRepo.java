package kaya_knot.kayaKnot.booking.repo;

import kaya_knot.kayaKnot.booking.entity.Corenting;
import kaya_knot.kayaKnot.booking.entity.dto.CorentingUserHouseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorentingRepo extends JpaRepository<Corenting,String> {
    @Query(value = "SELECT * FROM kaya.corenting,kaya.house_status WHERE corenting.house_status_id=house_status.id and house_status.id=:house_id and corenting.is_deleted=0 and corenting.is_active=1",nativeQuery = true)
    public List<Corenting> findCorentingHouse(String house_id);

//    @Query("SELECT new kaya_knot.kayaKnot.booking.entity.dto.CorentingUserHouseDTO(a.id,a.renterStatus,a.renterComment,u.id,hs.id,h.id) FROM Corenting a JOIN Users u  ON a.renterId.id=u.id JOIN HouseStatus hs ON a.houseStatusId.id=hs.id JOIN HouseSingleUnity h ON a.houseStatusId.houseSingleUnity.id=h.id and a.houseStatusId.id=:status_id")
//    public List<CorentingUserHouseDTO> fetchingHouseStatusId(String status_id);
//
////    value = "SELECT * FROM corenting a inner join users u  ON a.renter_id=u.id inner join house_status h ON a.house_status_id=h.id   LIMIT 1",nativeQuery = true
//    @Query("SELECT new kaya_knot.kayaKnot.booking.entity.dto.CorentingUserHouseDTO(a.id,a.renterStatus,u.firstName,u.email,h.bookingStatus ) FROM Corenting a JOIN Users u  ON a.renterId.id=u.id JOIN HouseStatus h ON a.houseStatusId.id=h.id")
//    public CorentingUserHouseDTO fetchingCorentingDetailsByHouse(String house_id);
}
