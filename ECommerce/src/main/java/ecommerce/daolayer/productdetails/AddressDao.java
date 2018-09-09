package ecommerce.daolayer.productdetails;

import ecommerce.model.productdetails.Address;

public interface AddressDao {
	public abstract boolean addAddress(Address address);
	public abstract boolean deleteAddress(Address address);
	

}
