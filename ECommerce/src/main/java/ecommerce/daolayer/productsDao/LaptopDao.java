package ecommerce.daolayer.productsDao;


import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;

public interface LaptopDao {
	public abstract boolean addLaptop(Laptop laptop);
	public abstract boolean deleteLaptop(Laptop laptop);
	public Laptop getlaptopDetails(long product_id); 

}
