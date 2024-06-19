package kaya_knot.kayaKnot.policy.repo;

import kaya_knot.kayaKnot.policy.entity.PersonalPolicy;
import kaya_knot.kayaKnot.policy.entity.UserRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRestrictionRepo extends JpaRepository<UserRestriction, String> {
    @Query(value = "SELECT * FROM user_restriction WHERE is_deleted=0 and is_active=1 and id=:id", nativeQuery = true)
    public UserRestriction fetchSingleRestrictionById(String id);

    @Query(value = "SELECT * FROM user_restriction WHERE is_deleted=0 and is_active=1 and user_id=:user_id", nativeQuery = true)
    public List<UserRestriction> fetchSingleRestrictionByUser(String user_id);
}
