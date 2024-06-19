package kaya_knot.kayaKnot.policy.repo;

import kaya_knot.kayaKnot.policy.entity.PersonalPolicy;
import kaya_knot.kayaKnot.policy.entity.SystemCancellationPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalPolicyRepo extends JpaRepository<PersonalPolicy, String> {
    @Query(value = "SELECT * FROM personal_policy WHERE is_deleted=0 and is_active=1 and id=:id", nativeQuery = true)
    public PersonalPolicy fetchPersonalSinglePolicyById(String id);

    @Query(value = "SELECT * FROM personal_policy WHERE is_deleted=0 and is_active=1 and user_id=:user_id", nativeQuery = true)
    public List<PersonalPolicy> fetchPersonalSinglePolicyByUser(String user_id);
}
