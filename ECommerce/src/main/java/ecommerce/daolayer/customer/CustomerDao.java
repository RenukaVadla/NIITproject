package ecommerce.daolayer.customer;

import ecommerce.model.customer.Customer;

public interface CustomerDao {
	
	public abstract boolean addCustomer(Customer customer);
	public abstract boolean deleteCustomer(Customer customer);
	public abstract Customer getCustomerByEmail(String customer_email);
	public abstract Customer login(String customer_email,String customer_password);

}
