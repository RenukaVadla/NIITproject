package springmvc.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.daolayer.productsDao.LaptopDao;
import ecommerce.daolayer.productsDao.MobileDao;
import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;

@Controller
public class ProductController {
	@Autowired
	MobileDao mobileDao;
	@Autowired
	LaptopDao laptopDao;
	
	@GetMapping("mobile")
	public String getMobile(Model model)
	{
		model.addAttribute("mobile",new Mobile());
		return "mobile";
	}
	@PostMapping("mobile")
	public String addMobile(@ModelAttribute("mobile") Mobile mobile)
	{
		mobileDao.addMobile(mobile);
		return "redirect:/category";
	}
	@GetMapping("laptop")
	public String getLaptop(Model model)
	{
		model.addAttribute("laptop", new Laptop());
		return "laptop";
	}
	@PostMapping("laptop")
	public String addLaptop(@ModelAttribute("laptop") Laptop laptop)
	{
		laptopDao.addLaptop(laptop);
		return "redirect:/category";
	}
	
}
