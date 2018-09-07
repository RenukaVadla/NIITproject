package ecommerce.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;


@Entity
@Component("User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long user_id;
	@Column(unique=false, nullable=false)
	private String user_name;
	@Column(unique=true,nullable=false)
	private String user_mobile;
	@Column(unique=true, nullable=false)
	private String user_email;
	@Column(unique=false, nullable=false)
	private String user_password;
	@Column(nullable=false)
	private String role;
	
	private boolean status=false;
	
	@Transient
	private String cofirmpassword;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<Address> address;
	
	/*@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private Set<Product> product;
	
	*/

	
	public String getUser_mobile() {
		return user_mobile;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	/*public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}*/

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		result = prime * result + ((user_mobile == null) ? 0 : user_mobile.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
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
		User other = (User) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_mobile == null) {
			if (other.user_mobile != null)
				return false;
		} else if (!user_mobile.equals(other.user_mobile))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_mobile=" + user_mobile
				+ ", user_email=" + user_email + ", user_password=" + user_password + ", role=" + role
				+ ", cofirmpassword=" + cofirmpassword + ", address=" + address/* + ", product=" + product + "]"*/;
	}


}