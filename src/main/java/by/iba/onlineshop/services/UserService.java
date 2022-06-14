package by.iba.onlineshop.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.iba.onlineshop.database.dao.UserDao;
import by.iba.onlineshop.entities.Cart;
import by.iba.onlineshop.entities.User;
import by.iba.onlineshop.entities.enums.Role;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.getUserByUsername(username);
	}

	@Transactional
	public User createUser(User user) {
		user.setPassword((new BCryptPasswordEncoder()).encode(user.getPassword()));
		if (Role.USER.equals(user.getRole())) {
			Cart cart = new Cart(user.getId(), 0, new ArrayList<>(), user);
			user.setCart(cart);
		}
		return userDao.createUser(user);
	}

}
