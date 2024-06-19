package kaya_knot.kayaKnot.policy.repo;

import kaya_knot.kayaKnot.policy.entity.BookingPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingPolicyRepo extends JpaRepository<BookingPolicy,String> {
}
