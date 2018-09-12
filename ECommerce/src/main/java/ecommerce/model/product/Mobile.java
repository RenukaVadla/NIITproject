package ecommerce.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

import ecommerce.model.productdetails.Product;
@Entity
@Component("mobile")
public class Mobile extends Product {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long mobile_id;
	private String mobile_ram;
	private String mobile_storage;
	private String mobile_series;
	
	
	public long getMobile_id() {
		return mobile_id;
	}
	public void setMobile_id(long mobile_id) {
		this.mobile_id = mobile_id;
	}
	public String getMobile_ram() {
		return mobile_ram;
	}
	public void setMobile_ram(String mobile_ram) {
		this.mobile_ram = mobile_ram;
	}
	public String getMobile_storage() {
		return mobile_storage;
	}
	public void setMobile_storage(String mobile_storage) {
		this.mobile_storage = mobile_storage;
	}
	public String getMobile_series() {
		return mobile_series;
	}
	public void setMobile_series(String mobile_series) {
		this.mobile_series = mobile_series;
	}
	
	
	

}
