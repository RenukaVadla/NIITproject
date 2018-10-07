package ecommerce.daolayer;

import ecommerce.model.User;

public interface UserDao {
	public abstract boolean addUser(User user);
	public abstract boolean deleteUser(User user);
	public abstract User getUserById(long user_id);
	public abstract User getUserByEmail(String user_email);
	public abstract User login(String user_email,String user_password);
	public abstract boolean update(User user);

}
