package springmvc.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.daolayer.productdetails.ProductDao;
import ecommerce.daolayer.productdetails.SubCategoryDao;
import ecommerce.daolayer.productsDao.LaptopDao;
import ecommerce.daolayer.productsDao.MobileDao;
import ecommerce.daolayer.vendor.VendorDao;
import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;
import ecommerce.model.product.NoOfProducts;
import ecommerce.model.productdetails.Product;
import ecommerce.model.productdetails.SubCategory;
import ecommerce.model.vendor.Vendor;

@Controller
public class ProductController {
	@Autowired
	MobileDao mobileDao;
	@Autowired
	LaptopDao laptopDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	SubCategoryDao subcategoryDao;
	@Autowired
	VendorDao vendorDao;
	@Autowired
	private ImageUpload imageUpload;
	
	
	private List<NoOfProducts> listOfProducts(Product product)
	{
		List<NoOfProducts> ListOfProducts=new ArrayList<NoOfProducts>();
		for(int i=1;i<=product.getNumberOfProducts();i++)
		{
			NoOfProducts noOfProducts = new NoOfProducts();
			noOfProducts.setProduct(product);
			ListOfProducts.add(noOfProducts);
		}
		return ListOfProducts;
	}

	@GetMapping("mobile")
	public String getMobile(Model model)
	{
		model.addAttribute("mobile",new Mobile());
		return "mobile";
	}
	
	@PostMapping("/vendor/addmobile")
	public String addMobile(@ModelAttribute("mobile") Mobile mobile,HttpServletRequest request,HttpSession session,Principal principal)
	{
		
		System.out.println(mobile);
		List<NoOfProducts> noOfProducts=listOfProducts(mobile);
		mobile.setNoOfProducts(noOfProducts);
		
		/*Vendor vendor=(Vendor)session.getAttribute("vendor");*/
		Vendor vendor=vendorDao.getUserByEmail(principal.getName());
		System.out.println(vendor);
		mobile.setVendor(vendor);
		
		mobile.setNoOfProducts(noOfProducts);
		if(mobileDao.addMobile(mobile))
		{
            imageUpload.saveImage(mobile, request);
            return "redirect:/vendor/category";
		}
        else{
        	 return "redirect:/subcategory";
            }
     }
	@GetMapping("/vendor/editmobile")
	public String editprofile(HttpSession httpSession,Model model)
	{
		model.addAttribute("mobile",httpSession.getAttribute("mobile"));
		return "/editprofile";
	}
	
	
	@PostMapping("/vendor/editmobile")
	public String editingprofile(@ModelAttribute("mobile") Mobile mobile,HttpSession httpSession,Model model)
	{
		mobileDao.editMobile(mobile);
		httpSession.setAttribute("mobile",mobile);
		model.addAttribute("mobile",mobile);
		return "redirect:/mobilespecifications";
	}
  
	
	@GetMapping("/vendor/laptop")
	public String getLaptop(Model model)
	{
		model.addAttribute("laptop", new Laptop());
		return "laptop";
	}
	@PostMapping("/vendor/addlaptop")
	public String addLaptop(@ModelAttribute("laptop") Laptop laptop,HttpServletRequest request,Principal principal)
	{
		
		System.out.println(laptop);
		List<NoOfProducts> noOfProducts=listOfProducts(laptop);
		laptop.setNoOfProducts(noOfProducts);
		
		Vendor vendor=vendorDao.getUserByEmail(principal.getName());
		System.out.println(vendor);
		laptop.setVendor(vendor);
		
		laptop.setNoOfProducts(noOfProducts);
		
		if(laptopDao.addLaptop(laptop))
		{
            imageUpload.saveImage(laptop, request);
            return "redirect:/vendor/category";
		}
        else{
        	 return "redirect:/vendor/subcategory";
            }
     }
	/*@GetMapping("/vendor/productdetails")
	public String getProducts(HttpSession session,Model model,Map<String,Object> products,Principal principal) {
		
		Vendor vendor=vendorDao.getUserByEmail(principal.getName());
		System.out.println(vendor);
		System.out.println(vendor.getVendor_id());
		products.put("productList", productDao.getAllProducts(vendor.getVendor_id()));
		return "productview";	
	}*/
	@GetMapping("vendor/viewproduct/{product_id}")
	public String viewProducts(@PathVariable("product_id") long product_id, Model model) {
		System.out.println(productDao.getSubCategoryId(product_id));

		String name = subcategoryDao.getSubCategory(productDao.getSubCategoryId(product_id)).getSubCategory_name();
				
		System.out.println(name);
		switch (name) {
		case "Mobile":
			model.addAttribute("mobile", mobileDao.getMobileDetails(product_id));
			return "mobilespecifications";

		case "Laptop":
			model.addAttribute("laptop", laptopDao.getlaptopDetails(product_id));
			return "laptopdetails";

		default:
			return "productdetails";
		}
	}

	@GetMapping("editproduct/{product_id}")
	public String editProducts(@PathVariable("product_id") long product_id, Model model,HttpServletRequest request) {

		String name = subcategoryDao.getSubCategory(productDao.getSubCategoryId(product_id))
				.getSubCategory_name();
		
		switch (name) {

		case "Mobile":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("mobile", mobileDao.getMobileDetails(product_id));
			return "editmobile";

		case "Laptop":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("laptop", laptopDao.getlaptopDetails(product_id));
			return "editlaptop";

		default:
			return "productdetails";
		}
	}
	
	
	@GetMapping("products/{subcategory_id}")
	public String getProducts(@PathVariable("subcategory_id")long subcategory_id,Map<String,Object> products)
	{
		
		System.out.println(productDao.getProductBySubCategory_id(subcategory_id));
		products.put("productList",productDao.getProductBySubCategory_id(subcategory_id));
		
		
		return "products";
	}
	
	@GetMapping("productdescription/{product_id}")
	public String productDescription(@PathVariable("product_id") long product_id, Model model)
	{
		System.out.println(productDao.getSubCategoryId(product_id));

		String name=subcategoryDao.getSubCategory(productDao.getSubCategoryId(product_id)).getSubCategory_name();
		System.out.println(name);
		switch(name)
		{
		case "Mobile":
			model.addAttribute("mobile",mobileDao.getMobileDetails(product_id));
			System.out.println(mobileDao.getMobileDetails(product_id));
			return "viewmobile";
		case "Laptop":
			model.addAttribute("laptop", laptopDao.getlaptopDetails(product_id));
			return "viewlaptop";
		default:
			return "index";
		}
	}
	
	@GetMapping("customer/buy/{product_id}")
	public String buy(@PathVariable("product_id") long product_id, Model model)
	{
		System.out.println(productDao.getSubCategoryId(product_id));
		System.out.println(product_id);
		String name=subcategoryDao.getSubCategory(productDao.getSubCategoryId(product_id)).getSubCategory_name();
		System.out.println(name);
		switch(name)
		{
		case "Mobile":
			System.out.println(mobileDao.getMobileDetails(product_id));
			model.addAttribute("mobile",mobileDao.getMobileDetails(product_id));
			return "buymobile";
		case "Laptop":
			model.addAttribute("laptop", laptopDao.getlaptopDetails(product_id));
			return "buylaptop";
		default:
			return "index";
		}
	}
	
}



	


