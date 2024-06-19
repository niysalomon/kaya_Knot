package kaya_knot.kayaKnot.user.service;

import kaya_knot.kayaKnot.user.entity.Users;

import java.util.List;

public interface UsersService {
    Users createNewUser(final Users users);
    Users updateUser(final Users users);
    List<Users> fetchAllUsers();
    Users findUserByEmail(String email);
    Users fetchUserById(final String id);

}
