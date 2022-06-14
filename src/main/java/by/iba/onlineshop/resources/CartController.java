package by.iba.onlineshop.resources;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.onlineshop.entities.Cart;
import by.iba.onlineshop.entities.User;
import by.iba.onlineshop.services.CartService;

@RestController
@RequestMapping("/cart")
@PreAuthorize("hasAuthority('ORDER')")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Cart get(@AuthenticationPrincipal User user,
			@RequestParam(name = "load_cart_items", required = false, defaultValue = "false") boolean loadCartItems) {
		Cart cart = cartService.getCart(user.getId(), loadCartItems);
		if (!Hibernate.isInitialized(cart.getCartItems())) {
			cart.setCartItems(null);
		}
		return cart;
	}

}
