package ecommerce.daolayer.productsDao;

import java.util.List;

import ecommerce.model.product.NoOfProducts;

public interface NoOfProductsDao {
	public abstract boolean NoOfProductsAdded(NoOfProducts product);
	public List<NoOfProducts> getNoOfProducts(long product_id);
	public NoOfProducts getNoOfProductsByNoOfproductsId(int  itemNo);
	public abstract boolean getStatusOfproduct(long product_id);
}
