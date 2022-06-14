package by.iba.onlineshop.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.iba.onlineshop.database.dao.CartDao;
import by.iba.onlineshop.entities.Cart;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;

	@Transactional
	public Cart getCart(int id, boolean loadCartItems) {
		Cart cart = cartDao.getCart(id);
		if (loadCartItems) {
			Hibernate.initialize(cart.getCartItems());
		}
		return cart;
	}

}
