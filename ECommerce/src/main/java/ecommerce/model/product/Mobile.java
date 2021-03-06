package ecommerce.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import ecommerce.model.productdetails.Product;
@Entity
@Component("mobile")
public class Mobile extends Product {
	
	@NotNull(message="mobile ram should not be null")
	private String mobile_ram;
	@NotNull(message="mobile storage should not be null")
	private String mobile_storage;
	@NotNull(message="mobile series should not be null")
	private String mobile_series;
	
	
	
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
