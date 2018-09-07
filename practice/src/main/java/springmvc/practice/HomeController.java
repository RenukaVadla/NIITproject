package springmvc.practice;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.daolayer.UserDao;
import ecommerce.model.Login;
import ecommerce.model.User;

@Controller
public class HomeController {
	
	@Autowired
	private UserDao userDao;
	

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
		
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String addUser(@ModelAttribute("user") User user)
	{
		if((userDao.getUserByEmail(user.getUser_email()))!=null)
		{
		
			return "signup";
		}
		else
		{
			userDao.addUser(user);
			return "redirect:/login";
			
		}
		
	}
	@GetMapping("/login")
	public String getUser(Model model)
	{
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user,HttpSession httpSession,Model model)
	{
		System.out.println(user.getUser_email());
		System.out.println(user.getUser_password());
		 user= userDao.login(user.getUser_email(), user.getUser_password(),user.getRole());
		if(user!= null)
		{
			System.out.println(user);
			httpSession.setAttribute("user", user);
		    model.addAttribute("user", user);
		    if((user.getRole()).equalsIgnoreCase("admin"))
		    {
		    	return "admin";
		    }else if((user.getRole()).equalsIgnoreCase("vendor"))
		    {
		    	return "vendor";
		    }else
		    {
		    	return "customer";
		    }
		    /*return "profile";*/
		   
		 }
			
		else
		{
			return "login";
		}
	}
	@GetMapping("/userdetails")
	public String getUserDetails(Map<String, Object> user)
	{
		user.put("userList", userDao.getVendorDetails());
		return "userdetails";
	}
	@GetMapping("/profile")
	public String profile() {
		
		return "profile";
	}
	
	
	@GetMapping("/editprofile")
	public String editprofile(HttpSession httpSession,Model model)
	{
		model.addAttribute("user",httpSession.getAttribute("user"));
		return "/editprofile";
	}
	
	
	@PostMapping("/editprofile")
	public String editingprofile(@ModelAttribute("user") User user,HttpSession httpSession,Model model)
	{
		userDao.update(user);
		httpSession.setAttribute("user", user);
		model.addAttribute("user", user);
		return "redirect:/profile";
		
	}
	
}