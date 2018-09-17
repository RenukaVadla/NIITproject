package ecommerce.model.vendor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component("Admin")
public class AdminDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long admin_id;
	private String admin_name;
	private String admin_email;
	private String admin_password;
	private String role="admin";
	private boolean active=true;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(long admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin_email == null) ? 0 : admin_email.hashCode());
		result = prime * result + (int) (admin_id ^ (admin_id >>> 32));
		result = prime * result + ((admin_name == null) ? 0 : admin_name.hashCode());
		result = prime * result + ((admin_password == null) ? 0 : admin_password.hashCode());
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
		AdminDetails other = (AdminDetails) obj;
		if (admin_email == null) {
			if (other.admin_email != null)
				return false;
		} else if (!admin_email.equals(other.admin_email))
			return false;
		if (admin_id != other.admin_id)
			return false;
		if (admin_name == null) {
			if (other.admin_name != null)
				return false;
		} else if (!admin_name.equals(other.admin_name))
			return false;
		if (admin_password == null) {
			if (other.admin_password != null)
				return false;
		} else if (!admin_password.equals(other.admin_password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_email=" + admin_email
				+ ", admin_password=" + admin_password + "]";
	}
	
	
	
}
