package FBS.MY_E_COMMERCE.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import FBS.MY_E_COMMERCE.Model.Address;
import FBS.MY_E_COMMERCE.Model.Customer;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
// Find addresses by customer
		@Query("select a from Address a where a.customer= customer")
		List<Address> findByCustomer(Customer customer);
}
