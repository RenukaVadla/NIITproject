package springmvc.practice;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.daolayer.admin.AdminDao;
import ecommerce.daolayer.customer.CustomerDao;
import ecommerce.daolayer.productdetails.CategoryDao;
import ecommerce.daolayer.productdetails.SubCategoryDao;
import ecommerce.daolayer.productsDao.LaptopDao;
import ecommerce.daolayer.vendor.VendorDao;
import ecommerce.model.customer.Customer;
import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;
import ecommerce.model.productdetails.SubCategory;
import ecommerce.model.vendor.AdminDetails;
import ecommerce.model.vendor.Vendor;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView indexPage()
	{
		ModelAndView view =new ModelAndView("index");
		return view;
	}
	@RequestMapping("/contact")
	public ModelAndView contact()
	{
		ModelAndView view=new ModelAndView("contact");
		view.addObject("contact", "This is contact page");
		return view;
	}
	
	//@RequestMapping("/aboutus")
	@GetMapping("/aboutus")
	public String aboutUs(Model model)
	{
		model.addAttribute("date", new Date());
		return "aboutus";
	}
	
		

	
	}
