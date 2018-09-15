package springmvc.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

import ecommerce.daolayer.productdetails.ProductDao;
import ecommerce.daolayer.productdetails.SubCategoryDao;
import ecommerce.daolayer.productsDao.LaptopDao;
import ecommerce.daolayer.productsDao.MobileDao;
import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;
import ecommerce.model.product.NoOfProducts;
import ecommerce.model.productdetails.Product;
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

	@GetMapping("mobile")
	public String getMobile(Model model)
	{
		model.addAttribute("mobile",new Mobile());
		return "mobile";
	}
	
	@PostMapping("addmobile")
	public String addMobile(@ModelAttribute("mobile") Mobile mobile,HttpServletRequest request,HttpSession session)
	{
		
		System.out.println(mobile);
		List<NoOfProducts> noOfProducts=listOfProducts(mobile);
		mobile.setNoOfProducts(noOfProducts);
		
		Vendor vendor=(Vendor)session.getAttribute("vendor");
		mobile.setVendor(vendor);
		
		mobile.setNoOfProducts(noOfProducts);
		if(mobileDao.addMobile(mobile)) {
            
            String contextPath=request.getRealPath("/");
            File file=new File(contextPath+"/resources/resource/products/");
            
            if(!file.exists())
            {
                file.mkdir();
            }
            
            System.out.println(file.getPath());
            FileOutputStream fileOutputStream=null;
            InputStream inputStream=null;
            try {
                 fileOutputStream=new FileOutputStream(file.getPath()+"/"+mobile.getProduct_id()+".jpg");
                 inputStream =mobile.getImage().getInputStream();
                byte[] imageBytes=new byte[inputStream.available()];
                inputStream.read(imageBytes);
                
                fileOutputStream.write(imageBytes);
                fileOutputStream.flush();        
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                 try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return "redirect:/category";
		}
        else{
        	 return "redirect:/subcategory";
            }
            }
            
            
	
	
            
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

		String name = subcategoryDao.getSubCategory(productDao.getSubCategoryId(product_id))
				.getSubCategory_name();
		System.out.println(name);
		switch (name) {
		case "Mobile":
			model.addAttribute("mobile", mobileDao.getMobileDetails(product_id));
			return "mobilespecifications";

		case "Laptop":
			model.addAttribute("laptop", laptopDao.getlaptopDetails(product_id));
			return "laptopspecifications";

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
