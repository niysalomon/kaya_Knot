package kaya_knot.kayaKnot.policy.repo;

import kaya_knot.kayaKnot.policy.entity.SystemBookingPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemBookingPolicyRepo extends JpaRepository<SystemBookingPolicy,String> {
    @Query(value = "SELECT * FROM system_booking_policy WHERE is_deleted=0 and is_active=1 and id=:id", nativeQuery = true)
    public SystemBookingPolicy fetchSystemSinglePolicy(String id);



}
