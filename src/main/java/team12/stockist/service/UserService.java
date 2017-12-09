package team12.stockist.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import team12.stockist.model.User;

public interface UserService {

	ArrayList<User> findAllUsers();

	User findUserById(Integer userId);

	User createUser(User user);

	User updateUser(User user);

	void deleteUser(User user);

	User findByUsername(String username);
	
	User authenticate(String uname, String pwd);
	
}