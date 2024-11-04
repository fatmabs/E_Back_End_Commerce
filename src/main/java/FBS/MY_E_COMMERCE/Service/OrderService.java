package FBS.MY_E_COMMERCE.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FBS.MY_E_COMMERCE.Model.Address;
import FBS.MY_E_COMMERCE.Model.Cart;
import FBS.MY_E_COMMERCE.Model.Customer;
import FBS.MY_E_COMMERCE.Model.Order;
import FBS.MY_E_COMMERCE.Repository.CartRepository;
import FBS.MY_E_COMMERCE.Repository.CustomerRepository;
import FBS.MY_E_COMMERCE.Repository.OrderRepository;
@Service
public class OrderService {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CartRepository cartRepository;
	

	   // Retrieve all orders for a customer
    public List	<Order> getOrdersByCustomerId(int customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return orderRepository.findByCustomer(customer);
    }
    // Place an order from the cart
    public Order placeOrder(int customerId, Address shippingAddress) {
        Cart cart = cartRepository.findByCustomer(customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found")))
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        Order order = new Order();
        order.setCustomer(cart.getCustomer());
        order.setProducts(cart.getProducts());
        order.setTotalAmount(cart.getTotalPrice());
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus("PENDING");
        order.setShippingAddress(shippingAddress);
        return orderRepository.save(order);
    }
    // Update order status
    public Order updateOrderStatus(int orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setOrderStatus(status);
        return orderRepository.save(order);
    }
}
