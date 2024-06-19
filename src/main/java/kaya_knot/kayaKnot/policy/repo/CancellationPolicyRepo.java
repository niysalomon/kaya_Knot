package kaya_knot.kayaKnot.policy.repo;

import kaya_knot.kayaKnot.policy.entity.CancellationPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationPolicyRepo extends JpaRepository<CancellationPolicy,String> {
}
