package by.iba.onlineshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.onlineshop.entities.Order;
import by.iba.onlineshop.entities.User;
import by.iba.onlineshop.services.OrderService;

@RestController
@PreAuthorize("hasAuthority('ORDER')")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	@ResponseStatus(HttpStatus.OK)
	public List<Order> getAll(@AuthenticationPrincipal User user) {
		return orderService.getOrders(user);
	}

	@PostMapping("/order")
	@ResponseStatus(HttpStatus.OK)
	public Order post(@AuthenticationPrincipal User user, @RequestBody Order order) {
		return orderService.checkout(user, order);
	}

}
