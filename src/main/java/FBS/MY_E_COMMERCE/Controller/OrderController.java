package FBS.MY_E_COMMERCE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FBS.MY_E_COMMERCE.Model.Address;
import FBS.MY_E_COMMERCE.Model.Order;
import FBS.MY_E_COMMERCE.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	OrderService orderService;
 
   // Get all orders for a customer
   @GetMapping("/customer/{customerId}")
   public List<Order> getOrdersByCustomerId(@PathVariable int customerId) {
       return orderService.getOrdersByCustomerId(customerId);
   }
   
   // Place an order
   @PostMapping("/{customerId}/place")
   public ResponseEntity<Order> placeOrder(@PathVariable int customerId, @RequestBody Address shippingAddress) {
       return ResponseEntity.ok(orderService.placeOrder(customerId, shippingAddress));
   }
   
   // Update order status
   @PutMapping("/{orderId}/status")
   public ResponseEntity<Order> updateOrderStatus(@PathVariable int orderId, @RequestParam String status) {
       return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status));
   }


}
