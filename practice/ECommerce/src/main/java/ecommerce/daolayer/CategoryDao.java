package ecommerce.daolayer;

import ecommerce.model.Category;

public interface CategoryDao {
	public abstract Category getCategoryId(long subcategory_id);

}
