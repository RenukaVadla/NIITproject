package ecommerce.daolayer.productsDao;

import java.util.List;

import ecommerce.model.product.Mobile;


public interface MobileDao {
	
	public abstract boolean addMobile(Mobile mobile);
	public abstract boolean deleteMobile(Mobile mobile);
	public abstract Mobile getMobileBySeries(String mobile_series);
	public Mobile getMobileDetails(long product_id);
	public abstract boolean editMobile(Mobile mobile);
	
	
}
