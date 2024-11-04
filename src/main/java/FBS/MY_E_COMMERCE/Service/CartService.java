package FBS.MY_E_COMMERCE.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FBS.MY_E_COMMERCE.Model.Cart;
import FBS.MY_E_COMMERCE.Model.Customer;
import FBS.MY_E_COMMERCE.Model.Product;
import FBS.MY_E_COMMERCE.Repository.CartRepository;
import FBS.MY_E_COMMERCE.Repository.CustomerRepository;

@Service
public class CartService {
	@Autowired
   CartRepository cartRepository;
	@Autowired
   CustomerRepository customerRepository;
   
   // Retrieve the cart for a customer
   public Optional<Cart> getCartByCustomerId(int customerId) {
       Customer customer = customerRepository.findById(customerId)
               .orElseThrow(() -> new RuntimeException("Customer not found"));
       return cartRepository.findByCustomer(customer);
   }
   // Add a product to the cart
   public Cart addProductToCart(int customerId, Product product) {
       Cart cart = getCartByCustomerId(customerId)
               .orElse(new Cart(customerRepository.findById(customerId).get()));
       cart.getProducts().add(product);
       cart.setTotalPrice(cart.getTotalPrice().add(product.getPrice()));
       return cartRepository.save(cart);
   }
   // Remove a product from the cart
   public Cart removeProductFromCart(int customerId, Product product) {
       Cart cart = getCartByCustomerId(customerId)
               .orElseThrow(() -> new RuntimeException("Cart not found"));
       cart.getProducts().remove(product);
       cart.setTotalPrice(cart.getTotalPrice().subtract(product.getPrice()));
       return cartRepository.save(cart);
   }
}
