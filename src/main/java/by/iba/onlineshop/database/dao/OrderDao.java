package by.iba.onlineshop.database.dao;

import java.util.List;

import by.iba.onlineshop.entities.Order;
import by.iba.onlineshop.entities.User;

public interface OrderDao {

	List<Order> getOrders(User user);

	Order createOrder(Order order);

}
