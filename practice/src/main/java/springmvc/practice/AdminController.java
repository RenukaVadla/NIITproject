package springmvc.practice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.daolayer.admin.AdminDao;
import ecommerce.model.vendor.AdminDetails;
@Controller
public class AdminController {
	@Autowired
	private AdminDao adminDao;
	
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
	

}