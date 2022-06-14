package by.iba.onlineshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.onlineshop.entities.Cart;
import by.iba.onlineshop.entities.CartItem;
import by.iba.onlineshop.entities.User;
import by.iba.onlineshop.services.CartItemService;

@RestController
@RequestMapping("/cart/item")
@PreAuthorize("hasAuthority('ORDER')")
public class CartItemController {

	@Autowired
	private CartItemService cartItemService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cart post(@AuthenticationPrincipal User user, @RequestBody CartItem cartItem) {
		return cartItemService.createCartItem(user.getId(), cartItem);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Cart put(@AuthenticationPrincipal User user, @RequestBody CartItem cartItem) {
		return cartItemService.updateCartItem(user.getId(), cartItem);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Cart delete(@AuthenticationPrincipal User user, @RequestBody CartItem cartItem) {
		return cartItemService.deleteCartItem(user.getId(), cartItem);
	}

}
