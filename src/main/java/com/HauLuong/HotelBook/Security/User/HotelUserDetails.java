package com.HauLuong.HotelBook.Security.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.HauLuong.HotelBook.Model.User;

public class HotelUserDetails  implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private  String email;
    private String password;
    private Collection<GrantedAuthority> authorities;

    public HotelUserDetails(Long id, String email, String password, Collection<GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	public static HotelUserDetails buildUserDetails(User user){
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new HotelUserDetails(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                authorities);

    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		   return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		 return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
        return true;

	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}