package kaya_knot.kayaKnot.policy.service.impl;

import kaya_knot.kayaKnot.policy.entity.SystemCancellationPolicy;
import kaya_knot.kayaKnot.policy.repo.SystemCancellationPolicyRepo;
import kaya_knot.kayaKnot.policy.service.SystemCancellationPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemCancellationPolicyServiceImpl implements SystemCancellationPolicyService {
    @Autowired
    private SystemCancellationPolicyRepo systemCancellationPolicyRepo;
    @Override
    public SystemCancellationPolicy createNewSystemPolicy(SystemCancellationPolicy systemCancellationPolicy) {
        return systemCancellationPolicyRepo.save(systemCancellationPolicy);
    }

    @Override
    public SystemCancellationPolicy updateSystemPolicy(SystemCancellationPolicy systemCancellationPolicy) {
        return systemCancellationPolicyRepo.save(systemCancellationPolicy);
    }

    @Override
    public List<SystemCancellationPolicy> fetchAllSystemPolicies() {
        return systemCancellationPolicyRepo.findAll();
    }

    @Override
    public SystemCancellationPolicy fetchSinglePolicy(String id) {
        return systemCancellationPolicyRepo.fetchSystemSinglePolicy(id);
    }
}
