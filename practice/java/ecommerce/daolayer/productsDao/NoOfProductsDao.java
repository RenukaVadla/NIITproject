package ecommerce.daolayer.productsDao;



import java.util.List;

import ecommerce.model.product.NoOfProducts;

public interface NoOfProductsDao {
	public abstract boolean NoOfProductsAdded(NoOfProducts product);
	//public abstract int getNoOfProducts(long product_id);
	public List<NoOfProducts> getNoOfProducts(long product_id);

}
