package by.iba.onlineshop.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.iba.onlineshop.database.dao.CartDao;
import by.iba.onlineshop.database.dao.OrderDao;
import by.iba.onlineshop.entities.Cart;
import by.iba.onlineshop.entities.CartItem;
import by.iba.onlineshop.entities.Order;
import by.iba.onlineshop.entities.OrderedProduct;
import by.iba.onlineshop.entities.User;

@Service
public class OrderService {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public List<Order> getOrders(User user) {
		return orderDao.getOrders(user);
	}
	
	@Transactional
	public Order checkout(User user, Order order) {
		Cart cart = cartDao.getCart(user.getId());
		List<CartItem> cartItems = cart.getCartItems();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		
		order.setUser(user);
		order.setDate(new Date());
		order.setOrderNumber(String.valueOf(user.getId() + "." + simpleDateFormat.format(order.getDate())));
		order.setTotalCost(cartItems.stream().mapToInt(cartItem -> cartItem.getProduct().getPrice()).sum());
		order.setOrderedProducts(new ArrayList<>());
		
		cartItems.forEach(cartItem -> {
			OrderedProduct orderedProduct = new OrderedProduct(order, cartItem.getProduct().getBrand(), cartItem.getProduct().getModel(), cartItem.getProductAmount(), cartItem.getProduct().getPrice());
			order.addOrderedProduct(orderedProduct);
		});

		return orderDao.createOrder(order);
	}

}
