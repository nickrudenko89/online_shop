package by.iba.onlineshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.iba.onlineshop.database.dao.CartDao;
import by.iba.onlineshop.entities.Cart;
import by.iba.onlineshop.entities.CartItem;

@Service
public class CartItemService {

	@Autowired
	private CartDao cartDao;

	@Transactional
	public Cart createCartItem(int cartId, CartItem cartItem) {
		Cart cart = cartDao.getCart(cartId);

		cartItem.setCart(cart);
		cart.addCartItem(cartItem);
		cart.setTotalProductsAmount(cart.getTotalProductsAmount() + 1);

		return cart;
	}

	@Transactional
	public Cart updateCartItem(int cartId, CartItem cartItem) {
		Cart cart = cartDao.getCart(cartId);
		CartItem existingCartItem = cart.getCartItems().stream().filter(
				item -> item.getCart().getId() == cartId && item.getProduct().getId() == cartItem.getProduct().getId())
				.findFirst().get();
		int differenceInAmount = cartItem.getProductAmount() - existingCartItem.getProductAmount();

		existingCartItem.setProductAmount(cartItem.getProductAmount());
		cart.setTotalProductsAmount(cart.getTotalProductsAmount() + differenceInAmount);

		return cart;
	}

	@Transactional
	public Cart deleteCartItem(int cartId, CartItem cartItem) {
		Cart cart = cartDao.getCart(cartId);

		cartItem.setCart(cart);
		cart.removeCartItem(cartItem);
		cart.setTotalProductsAmount(cart.getTotalProductsAmount() - cartItem.getProductAmount());

		return cart;
	}

}
