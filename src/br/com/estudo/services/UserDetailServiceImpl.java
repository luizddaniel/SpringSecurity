package br.com.estudo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.estudo.dao.UserDAO;
import br.com.estudo.model.UserDetailsImpl;
import br.com.estudo.model.UserImp;

public class UserDetailServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		UserDAO userDAO = new UserDAO();
		UserImp userImp;
		
		userImp = userDAO.findByUserName(username);
		
		if (userImp.getLogin().equalsIgnoreCase(username)) {
			UserDetailsImpl user = new UserDetailsImpl();
			user.setUserName(userImp.getLogin());
			user.setPassword(userImp.getPassword());
			user.addAuthority("ROLE_USER");
			return user;
		}
		throw new UsernameNotFoundException("Usuario não encontrado");
	}

}