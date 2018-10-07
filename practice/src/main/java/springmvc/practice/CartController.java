package springmvc.practice;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.daolayer.cart.CartDao;
import ecommerce.daolayer.cart.CartItemDao;
import ecommerce.daolayer.cart.CartItemIdDao;
import ecommerce.daolayer.customer.CustomerDao;
import ecommerce.daolayer.productdetails.ProductDao;
import ecommerce.daolayer.productsDao.NoOfProductsDao;
import ecommerce.model.cart.Cart;
import ecommerce.model.cart.CartItem;
import ecommerce.model.cart.CartItemId;
import ecommerce.model.customer.Customer;
import ecommerce.model.product.NoOfProducts;
import ecommerce.model.productdetails.Product;

@Controller
public class CartController {

	@Autowired
	ProductDao productDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	Customer customer;
	@Autowired
	Cart cart;
	@Autowired
	CartItem cartItem;
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	NoOfProductsDao noOfProductsDao;
	@Autowired
	NoOfProducts noOfProducts;
	@Autowired
	CartItemId cartItemId;
	@Autowired
	CartItemIdDao cartItemIdDao;
	@Autowired
	Product product;

	@GetMapping("customer/addtocart")
	public String addToCart(Principal principal, HttpServletRequest request) {

		
	 long product_id = Long.parseLong(request.getParameter("product_id"));
	 int quantity = Integer.parseInt(request.getParameter("noOfProducts"));
	 
	 int unitprice = productDao.getProduct(product_id).getProduct_price();
	  
	  Product product = productDao.getProduct(product_id);
	  
	  if(checkAvailabilityOfProducts(product_id, quantity) == true)
	  {
	  
	  Customer customer = customerDao.getCustomerByEmail(principal.getName());
	  System.out.println(customer.getCustomer_id()); 
	  cart =cartDao.getCartByCustomerId(customer.getCustomer_id());
	  if(cart==null)
	  {
	  cart=new Cart(); 
	  cartItem=new CartItem(); 
	  List<CartItem> cartItemsList=new ArrayList<CartItem>(); 
	  List<CartItemId> cartItemIdList=new ArrayList<CartItemId>();
	  List<NoOfProducts> noOfProductsList=new ArrayList<NoOfProducts>();
	  noOfProductsList=noOfProductsDao.getNoOfProducts(product_id);
	  for (int i = 0; i < quantity; i++)
	  { 
		cartItemId=new CartItemId();
		noOfProducts = new NoOfProducts();
		noOfProducts = noOfProductsList.get(i);
	  
	  noOfProducts.setSold(true); 
	  cartItemId.setNoOfProducts(noOfProducts);
	  cartItemId.setCartItem(cartItem); 
	  cartItemIdList.add(cartItemId); }
	  cartItem.setUnitPrice(unitprice); 
	  cartItem.setNetPrice(unitprice*quantity);
	  cartItem.setQuantity(quantity); 
	  cartItem.setCartItemId(cartItemIdList);
	  cartItem.setCart(cart); 
	  cartItemsList.add(cartItem);
	  cart.setCartItem(cartItemsList); 
	  cart.setCustomer(customer);
	  cart.setNetPrice(unitprice*quantity);
	  cart.setNoOfitems(quantity);
	  cartDao.addcart(cart); 
	  return "cart"; 
	  }else
	  { cartItem =checkIfProductAlreadyExists(product_id, cart);
	  
	  if (cartItem != null)
	  {
	  
	  List<CartItemId> cartItemIdsList = new ArrayList<CartItemId>();
	  List<CartItem> cartItemsList = new ArrayList<CartItem>();
	  cartItemsList = cart.getCartItem();
	  int position = cartItemsList.indexOf(cartItem);
	  List<NoOfProducts> noOfProductsList =
	  noOfProductsDao.getNoOfProducts(product_id);
	  
	  cartItemIdsList =
	  cartItemIdDao.getAllCartItemIdByCartItemId_id(cartItemId.getCartItemId_id());
	  
	  for (int i = 0; i < quantity; i++)
	  {
		  cartItemId = new CartItemId();
	 	noOfProducts = new NoOfProducts();
	 	noOfProducts = noOfProductsList.get(i);
	 	noOfProducts.setSold(true); 
	 	cartItemId.setNoOfProducts(noOfProducts);
	 	cartItemId.setCartItem(cartItem); 
	 	cartItemIdsList.add(cartItemId);
	 }
	  	cartItem.setCartItemId(cartItemIdsList);
	  	cartItemsList.add(position,cartItem); 
	  	cart.setCartItem(cartItemsList); 
	  	cart.setNetPrice((quantity *unitprice) + cart.getNetPrice());
	  	cart.setNoOfitems(quantity+ cart.getNoOfitems());
	  	cartDao.updatecart(cart);
	  
	  return "redirect:/customer/cart";
	  } else
	  {
	  
	  cartItem = new CartItem(); 
	  List<CartItemId> cartItemIdsList = new ArrayList<CartItemId>();
	  List<CartItem> cartItemsList = new ArrayList<CartItem>(); 
	  List<NoOfProducts> numberOfProductsList =
	  noOfProductsDao.getNoOfProducts(product_id); 
	  for (int i = 0; i < quantity;i++)
	  { 
		  cartItemId = new CartItemId(); noOfProducts = new NoOfProducts();
		  noOfProducts = numberOfProductsList.get(i); 
		  noOfProducts.setSold(true);
		  cartItemId.setNoOfProducts(noOfProducts); cartItemId.setCartItem(cartItem);
		  cartItemIdsList.add(cartItemId); } cartItem.setUnitPrice(unitprice);
		  cartItem.setNetPrice(quantity*unitprice); cartItem.setQuantity(quantity);
		  cartItem.setCartItemId(cartItemIdsList); cartItem.setCart(cart);
		  cartItemsList.add(cartItem); cart.setCartItem(cartItemsList);
		  cart.setNoOfitems(quantity + cart.getNoOfitems());
		  cart.setNetPrice(unitprice*quantity); cartDao.updatecart(cart);
	  
	  return "redirect:/customer/cart";
	  }
	  
	  }
	  
	  } else {
	  
	  return "redirect:/customer/customerindex"; }
	  
	  }
	  
	  public boolean checkAvailabilityOfProducts(long product_id, int quantity)
	  {
		  if(noOfProductsDao.getNoOfProducts(product_id).size()>=quantity) 
		  {
			  	return true; 
		  } else 
		  {
			  	return false;
		  } 
	  }
	  
	  public CartItem checkIfProductAlreadyExists(long product_id, Cart cart) {

			List<CartItem> cartItemsList = cart.getCartItem();
			for (CartItem items : cartItemsList) {
				if (items.getCartItemId().get(0).getNoOfProducts().getProduct().getProduct_id() == product_id) {
					return items;
				}
			}
			return null;
		}
	  
	  @GetMapping("customer/cart")
	  public String showCart(Model model,Principal principal)
	  {
		  System.out.println(principal.getName());
		  Customer customer=customerDao.getCustomerByEmail(principal.getName());
		  System.out.println(customer.getCustomer_id());
		  Cart cart=cartDao.getCartByCustomerId(customer.getCustomer_id());
		  model.addAttribute("cart", cart);
		  return "cart";
	  }
	  @GetMapping("customer/{cartItem_id}")
	  public String deleteFromCart(@PathVariable("cartItem_id")int cartItem_id)
	  {
		  cartItemDao.deletecartByCartItem_id(cartItemDao.getCartItemIdbycartItem_id(cartItem_id));
		  return "redirect:/customer/customerindex";
	  }
}
