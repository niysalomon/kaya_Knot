package kaya_knot.kayaKnot.booking.repo;

import kaya_knot.kayaKnot.booking.entity.SearchRenting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRentingRepo extends JpaRepository<SearchRenting,String> {
}
