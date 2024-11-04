package FBS.MY_E_COMMERCE.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FBS.MY_E_COMMERCE.Model.Customer;
import FBS.MY_E_COMMERCE.Service.CustomerService;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {
	@Autowired
	CustomerService customerService;
    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Register a new customer
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        if (customerService.existsByEmail(customer.getEmail())) {
            return ResponseEntity.badRequest().build();  // Email already exists
        }
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }
    // Update customer profile
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        if (customer.isPresent()) {
            Customer updatedCustomer = customer.get();
            updatedCustomer.setFirstName(customerDetails.getFirstName());
            updatedCustomer.setLastName(customerDetails.getLastName());
            updatedCustomer.setEmail(customerDetails.getEmail());
            // Other fields to update
            return ResponseEntity.ok(customerService.updateCustomer(updatedCustomer));
        }
        return ResponseEntity.notFound().build();
    }


}
