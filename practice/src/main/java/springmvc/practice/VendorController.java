package springmvc.practice;

import java.util.Map;

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

import ecommerce.daolayer.vendor.VendorDao;
import ecommerce.model.vendor.Vendor;
@Controller
//@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private VendorDao vendorDao;
	
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
 				return "redirect:/vendorlogin";
 				
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
		return "vendorlogin";
	}
	
	/*@PostMapping("/login")
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
 	}*/
	
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
	
	

}
