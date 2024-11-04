package FBS.MY_E_COMMERCE.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import FBS.MY_E_COMMERCE.Model.Customer;
import FBS.MY_E_COMMERCE.Model.Order;

@Repository
public interface OrderRepository extends JpaRepository< Order, Integer>{
	 // Find orders by customer
	
	@Query("select o from Order o where o.customer = customer")
	 List<Order> findByCustomer(Customer customer);
	
	 // Find orders by status (e.g., PENDING, SHIPPED, DELIVERED)
	
	@Query("select o from Order o where o.orderStatus Like :status")
	 List<Order> findByOrderStatus(String status);
	
	 // Find orders within a date range
	
	@Query("select o FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate")
	 List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
