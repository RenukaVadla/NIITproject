package springmvc.practice;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.daolayer.customer.CustomerDao;
import ecommerce.daolayer.productdetails.ProductDao;
import ecommerce.daolayer.productdetails.SubCategoryDao;
import ecommerce.daolayer.productsDao.LaptopDao;
import ecommerce.daolayer.productsDao.MobileDao;
import ecommerce.model.customer.Customer;
@Controller
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private SubCategoryDao subCategoryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private MobileDao mobileDao;
	@Autowired
	private LaptopDao laptopDao;
	
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
	
	@GetMapping("/customer/customerindex")
	public String customerLogin()
	{
		
			return "customerIndex";
	}
	
	@GetMapping("customer/customerprofile")
	public ModelAndView profile(Principal principal)
	{
		ModelAndView modelAndView=new ModelAndView("customerProfile");
		modelAndView.addObject("customer", customerDao.getCustomerByEmail(principal.getName()));
		return modelAndView;
	}
	
	/*@GetMapping("products/{subcategory_id}")
	public String getProducts(@PathVariable("subcategory_id")long subcategory_id,Map<String,Object> products)
	{
		
		System.out.println(productDao.getProductBySubCategory_id(subcategory_id));
		products.put("productList",productDao.getProductBySubCategory_id(subcategory_id));
		
		
		return "products";
	}
	
	@GetMapping("productdescription/{product_id}")
	public String productDescription(@PathVariable("product_id") long product_id, Model model)
	{
		String name=subCategoryDao.getSubCategory(productDao.getSubCategoryId(product_id)).getSubCategory_name();
		System.out.println(name);
		switch(name)
		{
		case "Mobile":
			model.addAttribute("mobile",mobileDao.getMobileDetails(product_id));
			return "viewmobile";
		case "Laptop":
			model.addAttribute("laptop", laptopDao.getlaptopDetails(product_id));
			return "viewlaptop";
		default:
			return "customerIndex";
		}
	}
	
*/
}
