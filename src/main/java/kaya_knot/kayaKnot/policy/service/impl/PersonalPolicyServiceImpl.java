package kaya_knot.kayaKnot.policy.service.impl;

import kaya_knot.kayaKnot.policy.entity.PersonalPolicy;
import kaya_knot.kayaKnot.policy.repo.PersonalPolicyRepo;
import kaya_knot.kayaKnot.policy.service.PersonalPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalPolicyServiceImpl implements PersonalPolicyService {
    @Autowired
    private PersonalPolicyRepo personalPolicyRepo;
    @Override
    public PersonalPolicy createNewPersonalPolicy(PersonalPolicy personalPolicy) {
        return personalPolicyRepo.save(personalPolicy);
    }

    @Override
    public PersonalPolicy updatePersonalPolicy(PersonalPolicy personalPolicy) {
        return personalPolicyRepo.save(personalPolicy);
    }

    @Override
    public PersonalPolicy fetchPersonalPolicyById(final String id) {
        return personalPolicyRepo.fetchPersonalSinglePolicyById(id);
    }

    @Override
    public List<PersonalPolicy> fetchPersonalPolicyByUser(String user_id) {
        return personalPolicyRepo.fetchPersonalSinglePolicyByUser(user_id);
    }
}
