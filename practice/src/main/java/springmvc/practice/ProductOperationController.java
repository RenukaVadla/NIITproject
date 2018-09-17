import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;
import ecommerce.model.productdetails.SubCategory;
import ecommerce.model.vendor.Vendor;

package springmvc.practice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.daolayer.productdetails.CategoryDao;
import ecommerce.daolayer.productdetails.ProductDao;
import ecommerce.daolayer.productdetails.SubCategoryDao;
import ecommerce.daolayer.productsDao.LaptopDao;
import ecommerce.daolayer.productsDao.MobileDao;
import ecommerce.model.vendor.Vendor;

@Controller
public class ProductOperationController {
	@Autowired
	MobileDao mobileDao;
	@Autowired
	LaptopDao laptopDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	SubCategoryDao subcategoryDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	@GetMapping("category")
	public String getCategory(Map<String, Object> category)
	{
		category.put("categoryList", categoryDao.getCategoryDetails());
		return "category";
	}
	
	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("category")long categoryId,Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryDao.getSubCategoryDetails(categoryId));
		model.addAttribute("categoryId",categoryDao.getCategoryId(categoryId));
		return "subcategory";
		
	}
	@PostMapping("getmodel")
	public String  addProducts(HttpServletRequest request,Model model,HttpSession httpSession) {
		
		System.out.println(request.getParameter("subCategory_id"));
		SubCategory subCategory=subCategoryDao.getSubCategory(Long.parseLong(request.getParameter("subCategory_id")));
		
		model.addAttribute("subCategory_id",subCategory.getSubcategory_id());
		System.out.println(subCategory.getSubcategory_id());
		
		Vendor vendor=(Vendor)httpSession.getAttribute("vendor");
		model.addAttribute("vendor_id",vendor.getVendor_id());
		
		switch(subCategory.getSubCategory_name()) 
		{
		  case "Laptop": model.addAttribute("laptop" ,new Laptop());
		  return "laptop";
		  
		  case "Mobile": model.addAttribute("mobile" ,new Mobile());
		   return "mobile";
		   
		default: return "subcategory";
		}
	}
	
	

	
	@GetMapping("productdetails")
	public String getProducts(HttpSession session,Model model,Map<String,Object> products) {
		
		Vendor vendor=(Vendor)session.getAttribute("vendor");
		System.out.println(vendor);
		System.out.println(vendor.getVendor_id());
		products.put("productList", productDao.getAllProducts(vendor.getVendor_id()));
		return "productview";	
	}
	@GetMapping("viewproduct/{product_id}")
	public String viewProducts(@PathVariable("product_id") long product_id, Model model) {
		System.out.println(productDao.getSubCategoryId(product_id));

		String name = subcategoryDao.getSubCategory(productDao.getSubCategoryId(product_id)).getSubCategory_name();
				getSubCategoryId(product_id)).getSubCategory_name();
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



}
