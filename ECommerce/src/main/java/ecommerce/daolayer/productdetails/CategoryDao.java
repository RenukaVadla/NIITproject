package ecommerce.daolayer.productdetails;

import java.util.List;

import ecommerce.model.productdetails.Category;

public interface CategoryDao {
	public abstract Category getCategoryId(long subcategory_id);
	public abstract List<Category> getCategoryDetails();
	public abstract Category getCategoryId(int categoryId);
}
