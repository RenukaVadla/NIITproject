package springmvc.practice;

import java.security.Principal;
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
import org.springframework.web.servlet.ModelAndView;

import ecommerce.daolayer.productdetails.CategoryDao;
import ecommerce.daolayer.productdetails.ProductDao;
import ecommerce.daolayer.productdetails.SubCategoryDao;
import ecommerce.daolayer.vendor.VendorDao;
import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;
import ecommerce.model.productdetails.SubCategory;
import ecommerce.model.vendor.Vendor;
@Controller

public class VendorController {
	
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SubCategoryDao subCategoryDao;
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/vendorsignup") 
 	public String getsigup(Model model)
 	{
 		model.addAttribute("vendor", new Vendor());
		return "vendorsignup";
	}
	@GetMapping("/vendorlogin")
	public String getUser(Principal principal)
	{
		return "vendorlogin";
	}
	@GetMapping("/vendor/vendor")
	public String vendor()
	{
		return "vendor";
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
 				return "redirect:/vendorlogin";
 				
 			}
 		}else
 		{
 			return "vendorsignup";
 		}
		
		
	}
	
	@GetMapping("/vendor/profile")
	public ModelAndView profile(Principal principal)
	{
		ModelAndView modelAndView=new ModelAndView("profile");
		modelAndView.addObject("vendor", vendorDao.getUserByEmail(principal.getName()));
		return modelAndView;
	}
	
	
	@GetMapping("/vendor/editprofile")
	public String editprofile(HttpSession httpSession,Model model)
	{
		model.addAttribute("vendor",httpSession.getAttribute("vendor"));
		return "/editprofile";
	}
	
	
	@PostMapping("/vendor/editprofile")
	public String editingprofile(@ModelAttribute("vendor") Vendor vendor,HttpSession httpSession,Model model)
	{
		vendorDao.update(vendor);
		httpSession.setAttribute("vendor", vendor);
		model.addAttribute("vendor", vendor);
		return "redirect:/vendor/profile";
		
	}
	@GetMapping("vendor/category")
	public String getCategories(Map<String, Object> category) {
		category.put("categoryList", categoryDao.getCategoryDetails());

		return "category";
	}
	
	@GetMapping("vendor/subcategory/{categoryId}")
	public String getSubCategory(@PathVariable("categoryId") int categoryId, Model model) {

		model.addAttribute("subCategoryList", subCategoryDao.getSubCategoryDetails(categoryId));
		model.addAttribute("categoryName", categoryDao.getCategoryId(categoryId));
		return "subcategory";

	}
	@PostMapping("vendor/getModel")
	public String addProducts(HttpServletRequest request, Model model, HttpSession session) {

		SubCategory subCategory = subCategoryDao.getSubCategory(Long.parseLong(request.getParameter("subCategory_id")));
		model.addAttribute("subCategory_id", subCategory.getSubcategory_id());

		
		switch (subCategory.getSubCategory_name())
		{
		
		case "Laptop":

			model.addAttribute("laptop", new Laptop());

			return "laptop";

		case "Mobile":
			model.addAttribute("mobile", new Mobile());
			return "mobile";
			
		default:
			return "subcategory";
			
		}
	}
	@GetMapping("/vendor/userdetails")
	public String getUserDetails(Map<String, Object> vendor)
	{
		System.out.println(vendorDao.getVendorDetails());
		vendor.put("vendorList", vendorDao.getVendorDetails());
		return "userdetails";
	}
	@GetMapping("/vendor/productdetails")
	public String getProducts(Principal principal,Map<String,Object> products) {
		
		/*Vendor vendor=(Vendor)session.getAttribute("vendor");*/
		Vendor vendor= vendorDao.getUserByEmail(principal.getName());
		System.out.println(vendor);
		System.out.println(vendor.getVendor_id());
		products.put("productList", productDao.getAllProducts(vendor.getVendor_id()));
		return "productview";	
	}
	/*
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
	
	
/*
	@GetMapping("vendor/vendorlogin")
	public String getUser(Model model)
	{
		model.addAttribute("vendor", new Vendor());
		return "vendorlogin";
	}
	
	@PostMapping("vendor/vendorlogin")
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
	*/
	
	
}
