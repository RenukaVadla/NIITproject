package ecommerce.daolayer.vendor;

import java.util.List;

import ecommerce.model.vendor.Vendor;



public interface VendorDao {
	public abstract boolean addUser(Vendor vendor);
	public abstract boolean deleteUser(Vendor vendor);
	public abstract Vendor getUserById(long vendor_id);
	public abstract Vendor getUserByEmail(String vendor_email);
	public abstract Vendor login(String vendor_email,String vendor_password);
	public abstract boolean update(Vendor vendor);
	public List<Vendor> getVendorDetails();
	
	//public abstract String userRole(String role,String email);

}
