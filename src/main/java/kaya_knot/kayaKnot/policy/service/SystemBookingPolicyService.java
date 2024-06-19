package kaya_knot.kayaKnot.policy.service;

import kaya_knot.kayaKnot.policy.entity.SystemBookingPolicy;

import java.util.List;

public interface SystemBookingPolicyService {
    SystemBookingPolicy createNewSystemPolicy(SystemBookingPolicy systemBookingPolicy);
    SystemBookingPolicy updateSystemPolicy(SystemBookingPolicy systemBookingPolicy);
    List<SystemBookingPolicy> fetchAllSystemPolicies();
    SystemBookingPolicy fetchSinglePolicy(String id);
}
