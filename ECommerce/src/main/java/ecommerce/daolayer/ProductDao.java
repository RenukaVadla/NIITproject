package ecommerce.daolayer;

import ecommerce.model.Product;

public interface ProductDao {
	public abstract boolean addProduct(Product product);
	public abstract boolean deleteProduct(Product product);
	

}
