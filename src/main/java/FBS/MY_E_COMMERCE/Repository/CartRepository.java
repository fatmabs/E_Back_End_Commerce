package FBS.MY_E_COMMERCE.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import FBS.MY_E_COMMERCE.Model.Cart;
import FBS.MY_E_COMMERCE.Model.Customer;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	 // Find the cart for a specific customer
	@Query("select c FROM Cart c WHERE c.customer = customer")
	 Optional<Cart> findByCustomer(Customer customer);
}
