package ecommerce.daolayer;

import ecommerce.model.Address;

public interface AddressDao {
	public abstract boolean addAddress(Address address);
	public abstract boolean deleteAddress(Address address);
	

}
