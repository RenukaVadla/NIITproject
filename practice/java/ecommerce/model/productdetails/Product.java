package ecommerce.model.productdetails;

import java.util.List;

import javax.persistence.CascadeType;

/*import java.util.Set;*/

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import ecommerce.model.product.NoOfProducts;
import ecommerce.model.vendor.Vendor;

@Entity
@Component("product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;
	private String product_brand;
	private boolean warrenty;
	private int product_price;
	private int numberOfProducts;
	@Transient
	private MultipartFile image;
	
	@OneToMany(mappedBy = "product", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<NoOfProducts> noOfProducts;
	
	@ManyToOne
	private Vendor vendor;
	
	@ManyToOne
	private SubCategory subCategory;


	public List<NoOfProducts> getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(List<NoOfProducts> noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	
	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public boolean isWarrenty() {
		return warrenty;
	}

	public void setWarrenty(boolean warrenty) {
		this.warrenty = warrenty;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	

}
