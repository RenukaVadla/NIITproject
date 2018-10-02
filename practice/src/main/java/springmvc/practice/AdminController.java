package springmvc.practice;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.daolayer.admin.AdminDao;
import ecommerce.daolayer.vendor.VendorDao;
import ecommerce.model.vendor.AdminDetails;
import ecommerce.model.vendor.Vendor;

@Controller
public class AdminController {
	@Autowired
	AdminDao adminDao;
	@Autowired
	VendorDao vendorDao;
	
	@GetMapping("/adminlogin")
	public String adminLogin(Principal principal,Map<String, Object> vendor)
	{
	  		return "adminlogin";
	  	 
	}
	
	@GetMapping("/admin/adminprofile")
	public ModelAndView displayAdminProfile(Principal principal)
	{
		
		ModelAndView modelAndView=new ModelAndView("adminprofile");
		modelAndView.addObject("admin",adminDao.getAdminByEmail(principal.getName()));
		
		return modelAndView;
	}
	
	
	@GetMapping("/admin/admin")
	public String admin(Model model)
	{
		model.addAttribute("vendorList", adminDao.getVendor());
		return "admin";
	}
	
	@GetMapping("/admin/userdetails")
	public String getUserDetails(Map<String, Object> vendor)
	{
		System.out.println(adminDao.getVendor());
		vendor.put("vendorList",adminDao.getVendor());
		return "userdetails";
	}
	
	@GetMapping("/admin/accept/{vendor_id}")
	public String activate(@PathVariable("vendor_id") long vendor_id)
	{
		Vendor vendor=vendorDao.getUserById(vendor_id);
		vendor.setStatus(true);
		vendorDao.update(vendor);
		return "redirect:/admin/userdetails";
	}
	
	@GetMapping("/admin/reject/{vendor_id}")
	public String deactivate(@PathVariable("vendor_id")long vendor_id)
	{
		Vendor vendor=vendorDao.getUserById(vendor_id);
		vendor.setStatus(false);
		vendorDao.update(vendor);
		return "redirect:/admin/userdetails";
	}
	
}
