package ecommerce.daolayer;

import java.util.List;

import ecommerce.model.User;

public interface UserDao {
	public abstract boolean addUser(User user);
	public abstract boolean deleteUser(User user);
	public abstract User getUserById(long user_id);
	public abstract User getUserByEmail(String user_email);
	public abstract User login(String user_email,String user_password,String role);
	public abstract boolean update(User user);
	public List<User> getVendorDetails();
	//public abstract String userRole(String role,String email);

}
