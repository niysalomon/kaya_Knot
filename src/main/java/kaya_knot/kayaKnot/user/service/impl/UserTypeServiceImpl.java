package kaya_knot.kayaKnot.user.service.impl;

import kaya_knot.kayaKnot.user.entity.UserType;
import kaya_knot.kayaKnot.user.repo.UserTypeRepo;
import kaya_knot.kayaKnot.user.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class UserTypeServiceImpl implements UserTypeService {
@Autowired
    private UserTypeRepo userTypeRepo;


    @Override
    public UserType getUserTypeById(final String id) {
        return userTypeRepo.fetchUserType(id);
    }

    @Override
    public UserType createNewUserType(UserType userType) {
        return userTypeRepo.save(userType);
    }

    @Override
    public List<UserType> fetchUserTypes() {
        return userTypeRepo.findAll();
    }
}
