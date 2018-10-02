package springmvc.practice;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.daolayer.customer.CustomerDao;
import ecommerce.model.customer.Customer;
@Controller
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;
	
	@GetMapping("/customersignup")
	public String getCustomerSignup(Model model)
	{
		model.addAttribute("customer", new Customer());
		return "customer";
	}
	@PostMapping("/customersignup")
	public String customerSignUp(@ModelAttribute("customer")Customer customer,HttpSession httpSession,Model model)
	{
		if(customerDao.getCustomerByEmail(customer.getCustomer_email())!=null)
		{
			return "customerlogin";
		}else
		{
			customerDao.addCustomer(customer);
			return "redirect:/customerlogin";
		}
	}
	
	@GetMapping("/customerlogin")
	public String getcustomerLogin(Principal principal)
	{
		return "customerlogin";
	}
	
	@GetMapping("customer/customerindex")
	public String customerLogin()
	{
		
			return "customerIndex";
	}

}
