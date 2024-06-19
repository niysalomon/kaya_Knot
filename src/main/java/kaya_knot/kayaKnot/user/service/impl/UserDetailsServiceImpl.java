package kaya_knot.kayaKnot.user.service.impl;

import kaya_knot.kayaKnot.user.entity.Users;
import kaya_knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsersService usersService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=usersService.findUserByEmail(username);
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        UserDetails userDetails = (UserDetails) new User(user.getEmail(),
                user.getPassword(),
                grantList);
        return userDetails;
    }
}
