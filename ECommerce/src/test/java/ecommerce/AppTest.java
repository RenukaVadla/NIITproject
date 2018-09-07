package ecommerce;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ecommerce.daolayer.AddressDao;
import ecommerce.model.Address;
import ecommerce.daolayer.ProductDao;
import ecommerce.daolayer.SubCategoryDao;
import ecommerce.daolayer.UserDao;
import ecommerce.daolayer.productsDao.LaptopDao;
import ecommerce.daolayer.productsDao.MobileDao;
import ecommerce.model.Product;
import ecommerce.model.SubCategory;
import ecommerce.model.User;
import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;

@SpringJUnitConfig(classes= {Configuration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest     
{
	@Autowired
    private User user;
	@Autowired
	private UserDao userDao;
	@Autowired
	private Address address;
	@Autowired
	private AddressDao addressdao;
	
	/*@Autowired
	private ProductDao productDao;
	@Autowired
	private Product product;
	*/
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
	
	
	@Before
	public void setUp()
	{
		//AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(Configuration.class);
		
		user.setUser_name("renuka");
		user.setUser_mobile("9885249966");
		user.setUser_email("renuka@gmail.com");
		user.setUser_password("vadla");
		user.setRole("vendor");

		address.setState("TS");
		address.setCity("Hyd");
		address.setStreet("StreetNo6");
		address.setPin("500013");
		
		
	
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
		
		/*Set<Product> products=new HashSet<Product>();
		products.add(mobile);
		products.add(laptop);
		user.setProduct(products);*/
		
	}
	
	@Test
	public void usertest()
	{
		assertEquals("usertest() failed", true, userDao.addUser(user));
	}
	
	@Test
	public void addAddress()
	{
		userDao.addUser(user);
		address.setUser(user);
		assertEquals("addAddress() testcase failed ", true, addressdao.addAddress(address));
		deleteAddress();
	}
	@Test
	public void updateUser()
	{
		userDao.addUser(user);
		user.setUser_email("renuka5l6@gmail.com");
		assertEquals("updateUser() testcase failed", true, userDao.update(user));
	}
	
	@Test
	public void addMobile()
	{
		userDao.addUser(user);
        mobile.setUser(user);
        subCategory=subCategoryDao.getCategory(1l);
  	  
  	  	mobile.setSubCategory(subCategory);
		assertEquals("failed addMobile()", true, mobileDao.addMobile(mobile));
		
		deleteMobile();
	}
	@Test
	public void addLaptop()
	{
		userDao.addUser(user);
		laptop.setUser(user);
		subCategory=subCategoryDao.getCategory(1l);
		
		laptop.setSubCategory(subCategory);
		assertEquals("addLaptop() testcase failed", true, laptopDao.addLaptop(laptop));
		
		deleteLaptop();
	}
	
	
	@After
	public void deleteUser()
	{
		
		assertEquals("failed deleteUser()", true, userDao.deleteUser(user));
		
		
	} 
	
	@Test
	public void getuserById()
	{
		userDao.addUser(user);
		long id=user.getUser_id();
		assertEquals("getUserId failed", user, userDao.getUserById(id));
		System.out.println(userDao.getUserById(id));
	}
	@Test
	public void getUserByEmail()
	{
		userDao.addUser(user);
		String email=user.getUser_email();
		assertEquals("getUserByEmail() testcase failed", user, userDao.getUserByEmail(email));
	}
	
	@Test
	public void loginUser()
	{
		userDao.addUser(user);
		String email=user.getUser_email();
		String password=user.getUser_password();
		System.out.println(email);
		System.out.println(password);
		assertEquals("loginUser() testcase failed", user, userDao.login(email,password));
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
