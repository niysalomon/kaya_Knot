package kaya_knot.kayaKnot.policy.service;

import kaya_knot.kayaKnot.policy.entity.UserRestriction;

import java.util.List;

public interface UserRestrictionService {
    UserRestriction createNewUserRestriction(UserRestriction userRestriction);
    UserRestriction updateUserRestriction(UserRestriction userRestriction);
    UserRestriction fetchSingleUserRestrictionById(String id);
    List<UserRestriction> fetchRestrictionsByUser(String user_id);
}
