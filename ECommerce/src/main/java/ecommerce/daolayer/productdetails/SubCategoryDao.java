package ecommerce.daolayer.productdetails;

import java.util.List;

import ecommerce.model.productdetails.SubCategory;

public interface SubCategoryDao {
	public abstract SubCategory getCategory(long subcategory_id);
	public abstract List<SubCategory> getSubCategoryDetails(long category_id);

}
