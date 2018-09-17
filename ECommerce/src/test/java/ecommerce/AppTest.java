package ecommerce;

import static org.junit.Assert.assertEquals;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ecommerce.daolayer.admin.AdminDao;
import ecommerce.daolayer.customer.CustomerDao;
import ecommerce.daolayer.productdetails.AddressDao;
import ecommerce.daolayer.productdetails.SubCategoryDao;
import ecommerce.daolayer.productsDao.LaptopDao;
import ecommerce.daolayer.productsDao.MobileDao;
import ecommerce.daolayer.vendor.VendorDao;
import ecommerce.model.customer.Customer;
import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;
import ecommerce.model.productdetails.Address;
import ecommerce.model.productdetails.SubCategory;
import ecommerce.model.vendor.AdminDetails;
import ecommerce.model.vendor.Vendor;

@SpringJUnitConfig(classes= {Configuration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest     
{
	@Autowired
    private Vendor vendor;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private Address address;
	@Autowired
	private AddressDao addressdao;
	@Autowired
	private AdminDetails admin;
	@Autowired
	private AdminDao adminDao;
	/*@Autowired
	private ProductDao productDao;
	@Autowired
	private Product product;*/
	
	@Autowired
	private Mobile mobile;
	@Autowired
	private MobileDao mobileDao;
	@Autowired
	private LaptopDao laptopDao;
	@Autowired
	private Laptop laptop;
	
	@Autowired
	private SubCategoryDao subCategoryDao;
	@Autowired
	private SubCategory subCategory;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private Customer customer;
	
	
	@Before
	public void setUp()
	{
		//AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(Configuration.class);
		vendor.setVendor_name("renuka");
		vendor.setVendor_mobile("9885249966");
		vendor.setCompany_name("Code");
		vendor.setVendor_email("renuka@gmail.com");
		vendor.setVendor_password("vadla");
		vendor.setCofirmpassword("vadla");
		

		address.setState("TS");
		address.setCity("Hyd");
		address.setStreet("StreetNo6");
		address.setPin("500013");
		
		admin.setAdmin_name("renuka");
		admin.setAdmin_email("vadlarenuka@gmail.com");
		admin.setAdmin_password("renuka");
		
	
		mobile.setProduct_brand("samsung");
		mobile.setWarrenty(true);
		mobile.setMobile_ram("3gb");
		mobile.setMobile_storage("32gb");
		mobile.setMobile_series("Jseries");
		
		laptop.setLaptop_process("i3");
		laptop.setLaptop_series("3000");
		laptop.setLaptop_storage("32");
		laptop.setProduct_brand("Dell");
		laptop.setWarrenty(true);
	
		customer.setCustomer_name("renuka");
		customer.setCustomer_mobile("897654481");
		customer.setCustomer_email("renuka5l@gmail.com");
		customer.setCustomer_password("renuka");
		/*Set<Product> products=new HashSet<Product>();
		products.add(mobile);
		products.add(laptop);
		user.setProduct(products);*/
		
	}
	@Test
	public void addCustomer()
	{
		assertEquals("failed", true, customerDao.addCustomer(customer));
		deleteCustomer();
	}
	public void deleteCustomer()
	{
		customerDao.deleteCustomer(customer);
	}
	@Test
	public void getCustomerByEmail()
	{
		customerDao.addCustomer(customer);
		String email=customer.getCustomer_email();
		assertEquals("getCustomerByEmail() failed", customer, customerDao.getCustomerByEmail(email));
		System.out.println(customer);
		deleteCustomer();
	}
	@Test
	public void customerLogin()
	{
		customerDao.addCustomer(customer);
		String email=customer.getCustomer_email();
		String password=customer.getCustomer_password();
		assertEquals("customerLogin() failed", customer, customerDao.login(email, password));
		System.out.println(customer);
		deleteCustomer();
	}
	@Test
	public void usertest()
	{
		assertEquals("usertest() failed", true, vendorDao.addUser(vendor));
	}
	
	@Test
	public void addAddress()
	{
		vendorDao.addUser(vendor);
		address.setVendor(vendor);;
		assertEquals("addAddress() testcase failed ", true, addressdao.addAddress(address));
		deleteAddress();
	}
	
	@Test
	public void updateUser()
	{
		vendorDao.addUser(vendor);
		vendor.setVendor_email("renuka5l6@gmail.com");
		
		assertEquals("updateUser() testcase failed", true, vendorDao.update(vendor));
	}
 @Test
	public void addAdmin()
	{
	
		assertEquals("addAdmin() failed", true, adminDao.addAdmin(admin));
		deleteAdmin();
	}
	public void deleteAdmin()
	{
		adminDao.deleteAdmin(admin);
	}

	@Test
	public void addMobile()
	{
		vendorDao.addUser(vendor);
        mobile.setVendor(vendor);
        subCategory=subCategoryDao.getSubCategory(1L);
  	  
  	  	mobile.setSubCategory(subCategory);
		assertEquals("failed addMobile()", true, mobileDao.addMobile(mobile));
		
		deleteMobile();
	}
	
	@Test
	public void addLaptop()
	{ 
		vendorDao.addUser(vendor);
		laptop.setVendor(vendor);
		subCategory=subCategoryDao.getSubCategory(1L);
		
		laptop.setSubCategory(subCategory);
		assertEquals("addLaptop() testcase failed", true, laptopDao.addLaptop(laptop));
		
		deleteLaptop();
	}
	
	
	@After
	public void deleteUser()
	{
		if(vendorDao.getUserById(vendor.getVendor_id())!=null)
		{
			assertEquals("failed deleteUser()", true, vendorDao.deleteUser(vendor));

		}
		
		
		
	} 
	
	@Test
	public void getuserById()
	{
		vendorDao.addUser(vendor);
		long id=vendor.getVendor_id();
		assertEquals("getUserId failed",vendor, vendorDao.getUserById(id));
		System.out.println(vendorDao.getUserById(id));
	}
	
	@Test
	public void getUserByEmail()
	{
		vendorDao.addUser(vendor);
		String email=vendor.getVendor_email();
		assertEquals("getUserByEmail() testcase failed", vendor,vendorDao.getUserByEmail(email));
		System.out.println(vendor.getVendor_email());
	}
	
	
	@Test
	public void loginUser()
	{
		vendorDao.addUser(vendor);
		String email=vendor.getVendor_email();
		String password=vendor.getVendor_password();
		System.out.println(email);
		System.out.println(password);
		assertEquals("loginUser() testcase failed", vendor, vendorDao.login(email,password));
	}
	
	public void deleteAddress()
	{
		 addressdao.deleteAddress(address);
	}
	
	public void deleteMobile()
	{
		 mobileDao.deleteMobile(mobile);
	}
	
	
	public void deleteLaptop()
	{
		assertEquals("deleteLaptop() failed", true, laptopDao.deleteLaptop(laptop));
	}


	}
