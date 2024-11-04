package FBS.MY_E_COMMERCE.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FBS.MY_E_COMMERCE.Model.Cart;
import FBS.MY_E_COMMERCE.Model.Product;
import FBS.MY_E_COMMERCE.Service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
   @Autowired
	CartService cartService;
  
   // Get the cart for a customer by their ID
   @GetMapping("/{customerId}")
   public ResponseEntity<Cart> getCartByCustomerId(@PathVariable int customerId) {
       Optional<Cart> cart = cartService.getCartByCustomerId(customerId);
       return cart.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
   }
   // Add product to cart
   @PostMapping("/{customerId}/add")
   public ResponseEntity<Cart> addProductToCart(@PathVariable int customerId, @RequestBody Product product) {
       return ResponseEntity.ok(cartService.addProductToCart(customerId, product));
   }
   // Remove product from cart
   @PostMapping("/{customerId}/remove")
   public ResponseEntity<Cart> removeProductFromCart(@PathVariable int customerId, 
@RequestBody Product product) {
       return ResponseEntity.ok(cartService.removeProductFromCart(customerId, product));
   }

}
