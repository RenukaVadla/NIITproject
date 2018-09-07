package ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Entity
@Component
public class SubCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long subcategory_id;
	private String subCategory_name;
	
	@ManyToOne
	private Category category;
	

	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public long getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(long subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	public String getSubCategory_name() {
		return subCategory_name;
	}
	public void setSubCategory_name(String subCategory_name) {
		this.subCategory_name = subCategory_name;
	}

}
