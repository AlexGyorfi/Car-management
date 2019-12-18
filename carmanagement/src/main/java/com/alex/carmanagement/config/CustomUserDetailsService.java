package com.alex.carmanagement.config;

import com.alex.carmanagement.datamodel.Role;
import com.alex.carmanagement.datamodel.User;
import com.alex.carmanagement.service.RoleService;
import com.alex.carmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        String password = user.getPassword();

        List<Role> roles = roleService.findRoleByUserId(user.getUserId());
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (Role role : roles) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorityList.add(grantedAuthority);
        }

        UserDetails userDetails = new CustomUserDetails(username, password, authorityList,
                user.getUserId(), user.getFirstName(), user.getLastName());
        return userDetails;
    }
}
