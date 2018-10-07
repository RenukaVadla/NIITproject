package ecommerce.daolayer.productdetails;

import java.util.List;

import ecommerce.model.productdetails.Product;

public interface ProductDao {
	public abstract boolean addProduct(Product product);
	public abstract boolean deleteProduct(Product product);
	public List<Product> getAllProducts(long vendor_id);
	public long getSubCategoryId(long product_id);
	public List<Product> getProductBySubCategory_id(long subcategory_id);
	public Product getProduct(long product_id); 

}
