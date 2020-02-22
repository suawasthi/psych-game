package com.psych.game.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.psych.game.models.Role;
import com.psych.game.models.User;

public class CustomUserDetail extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomUserDetail(User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = super.getRoles();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role rol : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		BCryptPasswordEncoder encodeer = new BCryptPasswordEncoder();
		return encodeer.encode(super.getSaltedPassword());

	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
