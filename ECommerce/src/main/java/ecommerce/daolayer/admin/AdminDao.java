package ecommerce.daolayer.admin;

import ecommerce.model.vendor.AdminDetails;

public interface AdminDao {
	
	public abstract boolean addAdmin(AdminDetails admin);
	public abstract boolean deleteAdmin(AdminDetails admin);
	public abstract AdminDetails getAdminByEmail(String admin_email);
	public abstract AdminDetails login(String admin_email,String admin_password);
	

}
