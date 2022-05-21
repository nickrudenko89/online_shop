package by.iba.onlineshop.database.dao;

import by.iba.onlineshop.entities.User;

public interface UserDao {

	User getUserByUsername(String username);

	User createUser(User user);

}
