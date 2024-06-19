package kaya_knot.kayaKnot.user.service.impl;

import kaya_knot.kayaKnot.user.entity.Users;
import kaya_knot.kayaKnot.user.repo.UserRepo;
import kaya_knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Users createNewUser(Users users) {
        return userRepo.save(users);
    }

    @Override
    public Users updateUser(Users users) {
        return userRepo.save(users);
    }

    @Override
    public List<Users> fetchAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Users findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    @Override
    public Users fetchUserById(String id) {
        return userRepo.findUserById(id);
    }
}
