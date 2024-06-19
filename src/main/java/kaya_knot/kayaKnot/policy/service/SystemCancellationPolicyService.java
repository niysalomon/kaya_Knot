package kaya_knot.kayaKnot.policy.service;

import kaya_knot.kayaKnot.policy.entity.SystemCancellationPolicy;

import java.util.List;

public interface SystemCancellationPolicyService {
    SystemCancellationPolicy createNewSystemPolicy(SystemCancellationPolicy systemCancellationPolicy);
    SystemCancellationPolicy updateSystemPolicy(SystemCancellationPolicy systemCancellationPolicy);
    List<SystemCancellationPolicy> fetchAllSystemPolicies();
    SystemCancellationPolicy fetchSinglePolicy(String id);
}
