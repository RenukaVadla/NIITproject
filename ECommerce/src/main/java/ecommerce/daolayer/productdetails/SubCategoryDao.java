package ecommerce.daolayer.productdetails;

import java.util.List;

import ecommerce.model.productdetails.SubCategory;

public interface SubCategoryDao {
	public abstract SubCategory getSubCategory(long subcategory_id);
	public abstract List<SubCategory> getSubCategoryDetails(long category_id);
	//public abstract long getIdOfSubcategory(long subcategory_id)
}
