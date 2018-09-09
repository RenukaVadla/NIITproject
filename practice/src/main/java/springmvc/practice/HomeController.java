
package springmvc.practice;

import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import ecommerce.daolayer.vendor.VendorDao;
import ecommerce.model.vendor.Vendor;




@Controller
public class HomeController {
	
	@Autowired
	private VendorDao vendorDao;
	

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
	
	@GetMapping("/signup")
	public String getsigup(Model model)
	{
		
		model.addAttribute("vendor", new Vendor());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String addUser(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result)
	{
		if(!result.hasErrors())
		{
			if((vendorDao.getUserByEmail(vendor.getVendor_email()))!=null)
			{
			
				return "signup";
			}
			else
			{
				vendorDao.addUser(vendor);
				return "redirect:/login";
				
			}
		}else
		{
			return "signup";
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
		   /* if((user.getRole()).equalsIgnoreCase("admin"))
		    {
		    	return "admin";
		    }else if((user.getRole()).equalsIgnoreCase("vendor"))
		    {
		    	return "vendor";
		    }else
		    {
		    	return "customer";
		    }
		    return "profile";*/
		   
		 }
			
		else
		{
			return "login";
		}
	}
	
	@GetMapping("/userdetails")
	public String getUserDetails(Map<String, Object> user)
	{
		user.put("userList", vendorDao.getVendorDetails());
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
	
	@GetMapping("accept/{user_id }")
	public String activate(@PathVariable("vendor_id") long vendor_id)
	{
		Vendor vendor=vendorDao.getUserById(vendor_id);
		vendor.setStatus(true);
		vendorDao.update(vendor);
		return "redirect:/userdetails";
	}
	
	@GetMapping("reject/{user_id}")
	public String deactivate(@PathVariable("vendor_id")long vendor_id)
	{
		Vendor vendor=vendorDao.getUserById(vendor_id);
		vendor.setStatus(false);
		vendorDao.update(vendor);
		return "redirect:/userdetails";
	}
	
}