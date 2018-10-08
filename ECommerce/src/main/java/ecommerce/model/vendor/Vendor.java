package ecommerce.model.vendor;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import ecommerce.model.productdetails.Address;


@Entity
@Component("Vendor")
public class Vendor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long vendor_id;
	
	/*@NotNull(message="name should not be null")
	@NotBlank(message="name should not be blank")
	@Column(unique=false, nullable=false)*/
	private String vendor_name;
	
	/*@NotNull(message="mobile number should not be null")
	@NotBlank(message="mobile number should not be blank")
	@Pattern(regexp="^[6-9]\\d{9}" ,message="enter valid mobile number")
	@Column(unique=true,nullable=false)*/
	private String vendor_mobile;
	
	@Column(unique=true, nullable=false)
	private String company_name;
	
	/*@NotNull(message="Email should not be null")
	@NotBlank(message="Email should not be blank")
	@Pattern(regexp="[a-z0-9]{5,15}@[a-z]{3,6}\\.[a-z]{2,6}", message="enter valid email")
	@Column(unique=true, nullable=false)*/
	private String vendor_email;
	
	/*@NotNull(message="Password should not be null")
	@NotBlank(message="Password  should not be blank")
	@Column(unique=false, nullable=false)
*/	private String vendor_password;
	
	private boolean status=false;
	
	private String role="vendor";
	
	@Transient
	private String cofirmpassword;
	
	@OneToMany(mappedBy="vendor", fetch=FetchType.EAGER)
	private Set<Address> address;

	/*@OneToMany(mappedBy="vendor",fetch=FetchType.EAGER)
	private Set<Product> product;
	
	*/
	

	public boolean isStatus() {
		return status;
	}

	

	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public long getVendor_id() {
		return vendor_id;
	}



	public void setVendor_id(long vendor_id) {
		this.vendor_id = vendor_id;
	}



	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getVendor_mobile() {
		return vendor_mobile;
	}

	public void setVendor_mobile(String vendor_mobile) {
		this.vendor_mobile = vendor_mobile;
	}

	public String getVendor_email() {
		return vendor_email;
	}

	public void setVendor_email(String vendor_email) {
		this.vendor_email = vendor_email;
	}

	public String getVendor_password() {
		return vendor_password;
	}

	public void setVendor_password(String vendor_password) {
		this.vendor_password = vendor_password;
	}

	public String getCofirmpassword() {
		return cofirmpassword;
	}

	public void setCofirmpassword(String cofirmpassword) {
		this.cofirmpassword = cofirmpassword;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((vendor_email == null) ? 0 : vendor_email.hashCode());
		result = prime * result + (int) (vendor_id ^ (vendor_id >>> 32));
		result = prime * result + ((vendor_mobile == null) ? 0 : vendor_mobile.hashCode());
		result = prime * result + ((vendor_name == null) ? 0 : vendor_name.hashCode());
		result = prime * result + ((vendor_password == null) ? 0 : vendor_password.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (vendor_email == null) {
			if (other.vendor_email != null)
				return false;
		} else if (!vendor_email.equals(other.vendor_email))
			return false;
		if (vendor_id != other.vendor_id)
			return false;
		if (vendor_mobile == null) {
			if (other.vendor_mobile != null)
				return false;
		} else if (!vendor_mobile.equals(other.vendor_mobile))
			return false;
		if (vendor_name == null) {
			if (other.vendor_name != null)
				return false;
		} else if (!vendor_name.equals(other.vendor_name))
			return false;
		if (vendor_password == null) {
			if (other.vendor_password != null)
				return false;
		} else if (!vendor_password.equals(other.vendor_password))
			return false;
		return true;
	}



		@Override
	public String toString() {
		return "Vendor [vendor_id=" + vendor_id + ", vendor_name=" + vendor_name + ", vendor_mobile=" + vendor_mobile
				+ ", company_name=" + company_name + ", vendor_email=" + vendor_email + ", vendor_password="
				+ vendor_password + ", status=" + status + ", cofirmpassword=" + cofirmpassword + ", address=" + address
				+ "]";
	}

	
}
	