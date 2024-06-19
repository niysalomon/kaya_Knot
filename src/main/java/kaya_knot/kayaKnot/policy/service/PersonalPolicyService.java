package kaya_knot.kayaKnot.policy.service;

import kaya_knot.kayaKnot.policy.entity.PersonalPolicy;

import java.util.List;
import java.util.Optional;

public interface PersonalPolicyService {
    PersonalPolicy createNewPersonalPolicy(PersonalPolicy personalPolicy);
    PersonalPolicy updatePersonalPolicy(PersonalPolicy personalPolicy);
  PersonalPolicy fetchPersonalPolicyById(final String id);
    List<PersonalPolicy> fetchPersonalPolicyByUser(String user_id);


}
