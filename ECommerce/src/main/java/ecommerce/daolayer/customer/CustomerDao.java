package ecommerce.daolayer.customer;

import ecommerce.model.customer.Customer;

public interface CustomerDao {
	
	public abstract boolean addCustomer(Customer customer);
	public abstract boolean deleteCustomer(Customer customer);

}
