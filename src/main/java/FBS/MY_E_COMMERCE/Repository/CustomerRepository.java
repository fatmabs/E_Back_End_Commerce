package FBS.MY_E_COMMERCE.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import FBS.MY_E_COMMERCE.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
		// Find a customer by email (used for login)
		@Query("SELECT c FROM Customer c WHERE c.email = email")
		Optional<Customer> findByEmail(String email);
		
		// Check if a customer with a certain email already exists (for registration)
		@Query("SELECT c FROM Customer c WHERE c.email = email")
		boolean existsByEmail(String email);

}
