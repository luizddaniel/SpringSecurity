package br.com.estudo.services;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.estudo.model.UserDAO;
import br.com.estudo.model.UserDetailsImpl;
import br.com.estudo.model.UserImp;


public class UserDetailServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

				
		if (username.equalsIgnoreCase(username)) {
			UserDetailsImpl user = new UserDetailsImpl();
			user.setUserName(username);
			user.setPassword("1234");
			user.addAuthority("ROLE_USER");
			return user;
		}
		throw new UsernameNotFoundException("Usuario não encontrado");
	}

}