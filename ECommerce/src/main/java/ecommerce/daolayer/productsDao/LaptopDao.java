package ecommerce.daolayer.productsDao;


import ecommerce.model.product.Laptop;

public interface LaptopDao {
	public abstract boolean addLaptop(Laptop laptop);
	public abstract boolean deleteLaptop(Laptop laptop);

}
