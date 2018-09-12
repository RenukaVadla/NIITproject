package ecommerce.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import ecommerce.model.productdetails.Product;
@Entity
@Component("laptop")
public class Laptop extends Product {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String laptop_id;
	private String laptop_process;
	private String laptop_series;
	private String laptop_storage;
	
	
	public String getLaptop_process() {
		return laptop_process;
	}
	public void setLaptop_process(String laptop_process) {
		this.laptop_process = laptop_process;
	}
	public String getLaptop_series() {
		return laptop_series;
	}
	public void setLaptop_series(String laptop_series) {
		this.laptop_series = laptop_series;
	}
	public String getLaptop_storage() {
		return laptop_storage;
	}
	public void setLaptop_storage(String laptop_storage) {
		this.laptop_storage = laptop_storage;
	}
	

}
