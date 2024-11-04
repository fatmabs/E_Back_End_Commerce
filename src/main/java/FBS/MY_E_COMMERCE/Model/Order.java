package FBS.MY_E_COMMERCE.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "customer_order")

public class Order {
	   	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	   	
	    @ManyToOne
	    @JoinColumn(name = "customer_id" )
	    private Customer customer;
	    @ManyToMany
	    @JoinTable(
	        name = "order_products",
	        joinColumns = @JoinColumn(name = "order_id"),
	        inverseJoinColumns = @JoinColumn(name = "product_id")
	    )
	    private List<Product> products;
	    private BigDecimal totalAmount;
	    private LocalDateTime orderDate;
	    private String orderStatus; 
	    
	    // e.g., PENDING, SHIPPED, DELIVERED
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id")
	    private Address shippingAddress;
	 

}
