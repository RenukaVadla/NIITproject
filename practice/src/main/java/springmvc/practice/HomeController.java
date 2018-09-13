
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
import ecommerce.daolayer.productdetails.CategoryDao;
import ecommerce.daolayer.productdetails.SubCategoryDao;
import ecommerce.daolayer.productsDao.LaptopDao;
import ecommerce.daolayer.vendor.VendorDao;
import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;
import ecommerce.model.vendor.AdminDetails;
import ecommerce.model.vendor.Vendor;




@Controller
public class HomeController {
	
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SubCategoryDao subCategoryDao;
	
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
	
	@GetMapping("/vendorsignup")
	public String getsigup(Model model)
	{
		
		model.addAttribute("vendor", new Vendor());
		return "vendorsignup";
	}
	
	@PostMapping("/vendorsignup")
	public String addUser(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result)
	{
		if(!result.hasErrors())
		{
			if((vendorDao.getUserByEmail(vendor.getVendor_email()))!=null)
			{
			
				return "vendorsignup";
			}
			else
			{
				vendorDao.addUser(vendor);
				return "redirect:/login";
				
			}
		}else
		{
			return "vendorsignup";
		}
		
		
	}
	@GetMapping("/login")
	public String getUser(Model model)
	{
		model.addAttribute("vendor", new Vendor());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("vendor") Vendor vendor,HttpSession httpSession,Model model)
	{
		System.out.println(vendor.getVendor_email());
		System.out.println(vendor.getVendor_password());
		vendor= vendorDao.login(vendor.getVendor_email(), vendor.getVendor_password());
		if(vendor!= null)
		{
			System.out.println(vendor);
			httpSession.setAttribute("vendor", vendor);
		    model.addAttribute("vendor", vendor);
		    return "vendor";
		 }
			
		else
		{
			return "login";
		}
	}
	@GetMapping("/adminlogin")
	public String getAdmin(Model model)
	{
		model.addAttribute("admin", new AdminDetails());
		return "adminlogin";
	}
	@PostMapping("/adminlogin")
	public String adminLogin(@ModelAttribute("admin") AdminDetails admin,HttpSession httpSession,Model model)
	{
		if((adminDao.getAdminByEmail(admin.getAdmin_email()))!=null)
		{
			return "admin";
		}else
		{
			return "index";
		}
	}
	
	@GetMapping("/userdetails")
	public String getUserDetails(Map<String, Object> vendor)
	{
		System.out.println(vendorDao.getVendorDetails());
		vendor.put("vendorList", vendorDao.getVendorDetails());
		return "userdetails";
	}
	@GetMapping("/profile")
	public String profile() {
		
		return "profile";
	}
	
	
	@GetMapping("/editprofile")
	public String editprofile(HttpSession httpSession,Model model)
	{
		model.addAttribute("vendor",httpSession.getAttribute("vendor"));
		return "/editprofile";
	}
	
	
	@PostMapping("/editprofile")
	public String editingprofile(@ModelAttribute("vendor") Vendor vendor,HttpSession httpSession,Model model)
	{
		vendorDao.update(vendor);
		httpSession.setAttribute("vendor", vendor);
		model.addAttribute("vendor", vendor);
		return "redirect:/profile";
		
	}
	
	@GetMapping("accept/{vendor_id}")
	public String activate(@PathVariable("vendor_id") long vendor_id)
	{
		Vendor vendor=vendorDao.getUserById(vendor_id);
		vendor.setStatus(true);
		vendorDao.update(vendor);
		return "redirect:/userdetails";
	}
	
	@GetMapping("reject/{vendor_id}")
	public String deactivate(@PathVariable("vendor_id")long vendor_id)
	{
		Vendor vendor=vendorDao.getUserById(vendor_id);
		vendor.setStatus(false);
		vendorDao.update(vendor);
		return "redirect:/userdetails";
	}
	
	@GetMapping("/category")
	public String getCategory(Map<String, Object> category)
	{
		category.put("categoryList", categoryDao.getCategoryDetails());
		return "category";
	}
	
	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("category")long categoryId,Model model) {
		 
		System.out.println(subCategoryDao.getSubCategoryDetails(categoryId));
		System.out.println(categoryId);
		model.addAttribute("subCategoryList",subCategoryDao.getSubCategoryDetails(categoryId));
		model.addAttribute("categoryId",categoryDao.getCategoryId(categoryId));
		return "subcategory";
		
	}
	@PostMapping("getmodel")
	public String  addProducts(HttpServletRequest request,Model model) {
		
		switch(request.getParameter("subCategory_name")) 
		{
		  case "Laptop": model.addAttribute("laptop" ,new Laptop());
		  return "laptop";
		  
		  case "Mobile": model.addAttribute("mobile" ,new Mobile());
		   return "mobile";
		   
		default: return "subcategory";
		}
	}
}