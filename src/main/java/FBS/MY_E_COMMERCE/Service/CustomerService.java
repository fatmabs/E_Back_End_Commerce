package FBS.MY_E_COMMERCE.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FBS.MY_E_COMMERCE.Model.Customer;
import FBS.MY_E_COMMERCE.Repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	 // Retrieve a customer by email (for login)
    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
    // Check if a customer with a given email exists (for registration)
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }
    // Register a new customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    // Retrieve a customer by ID
    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }
    // Update customer information
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
 
}
