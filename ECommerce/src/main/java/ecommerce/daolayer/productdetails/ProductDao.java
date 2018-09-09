package ecommerce.daolayer.productdetails;

import ecommerce.model.productdetails.Product;

public interface ProductDao {
	public abstract boolean addProduct(Product product);
	public abstract boolean deleteProduct(Product product);
	

}
