package ecommerce.daolayer.productdetails;

import ecommerce.model.productdetails.Category;

public interface CategoryDao {
	public abstract Category getCategoryId(long subcategory_id);

}
