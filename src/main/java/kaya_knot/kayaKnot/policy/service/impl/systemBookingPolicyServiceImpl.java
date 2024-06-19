package kaya_knot.kayaKnot.policy.service.impl;

import kaya_knot.kayaKnot.policy.entity.SystemBookingPolicy;
import kaya_knot.kayaKnot.policy.repo.SystemBookingPolicyRepo;
import kaya_knot.kayaKnot.policy.service.SystemBookingPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class systemBookingPolicyServiceImpl implements SystemBookingPolicyService {
    @Autowired
    private SystemBookingPolicyRepo systemBookingPolicyRepo;
    @Override
    public SystemBookingPolicy createNewSystemPolicy(SystemBookingPolicy systemBookingPolicy) {
        return systemBookingPolicyRepo.save(systemBookingPolicy);
    }

    @Override
    public SystemBookingPolicy updateSystemPolicy(SystemBookingPolicy systemBookingPolicy) {
        return systemBookingPolicyRepo.save(systemBookingPolicy);
    }

    @Override
    public List<SystemBookingPolicy> fetchAllSystemPolicies() {
        return systemBookingPolicyRepo.findAll();
    }

    @Override
    public SystemBookingPolicy fetchSinglePolicy(String id) {
        return systemBookingPolicyRepo.fetchSystemSinglePolicy(id);
    }
}
