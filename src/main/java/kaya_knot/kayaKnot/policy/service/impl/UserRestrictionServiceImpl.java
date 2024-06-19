package kaya_knot.kayaKnot.policy.service.impl;

import kaya_knot.kayaKnot.policy.entity.UserRestriction;
import kaya_knot.kayaKnot.policy.repo.UserRestrictionRepo;
import kaya_knot.kayaKnot.policy.service.UserRestrictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRestrictionServiceImpl implements UserRestrictionService {
    @Autowired
    private UserRestrictionRepo userRestrictionRepo;
    @Override
    public UserRestriction createNewUserRestriction(UserRestriction userRestriction) {
        return userRestrictionRepo.save(userRestriction);
    }

    @Override
    public UserRestriction updateUserRestriction(UserRestriction userRestriction) {
        return userRestrictionRepo.save(userRestriction);
    }

    @Override
    public UserRestriction fetchSingleUserRestrictionById(String id) {
        return userRestrictionRepo.fetchSingleRestrictionById(id);
    }

    @Override
    public List<UserRestriction> fetchRestrictionsByUser(String user_id) {
        return userRestrictionRepo.fetchSingleRestrictionByUser(user_id);
    }
}
