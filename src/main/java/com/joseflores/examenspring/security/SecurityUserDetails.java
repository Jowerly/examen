package com.joseflores.examenspring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.joseflores.examenspring.models.Role;
import com.joseflores.examenspring.models.User;
import com.joseflores.examenspring.services.UserServices;

@Configuration
@Service
public class SecurityUserDetails implements UserDetailsService{
    private final UserServices userService;

    public SecurityUserDetails(UserServices userService) {
      this.userService = userService;
    }
    @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.findByEmail(username);

    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
        user.getEmail(),
        user.getPassword(),
        getAuthorities(user));

    return userDetails;
  }
  private List<GrantedAuthority> getAuthorities(User user) {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (Role role : user.getRoles()) {
      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
      authorities.add(grantedAuthority);
    }

    return authorities;
  }
}