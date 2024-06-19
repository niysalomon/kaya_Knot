package kaya_knot.kayaKnot.policy.service.impl;

import kaya_knot.kayaKnot.policy.entity.CancellationPolicy;
import kaya_knot.kayaKnot.policy.repo.CancellationPolicyRepo;
import kaya_knot.kayaKnot.policy.service.CancellationPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CancellationPolicyServiceImpl implements CancellationPolicyService {
    @Autowired
    private CancellationPolicyRepo cancellationPolicyRepo;
    @Override
    public CancellationPolicy createNewCancellationPolicy(CancellationPolicy cancellationPolicy) {
        return cancellationPolicyRepo.save(cancellationPolicy);
    }

    @Override
    public CancellationPolicy updateCancellationPolicy(CancellationPolicy cancellationPolicy) {
        return cancellationPolicyRepo.save(cancellationPolicy);
    }

    @Override
    public List<CancellationPolicy> fetchAllCancellationPolicies() {
        return cancellationPolicyRepo.findAll();
    }

    @Override
    public Optional<CancellationPolicy> fetchCancellationPoliciesById(final String id) {
        return cancellationPolicyRepo.findById(id);
    }
}
