package FBS.MY_E_COMMERCE.Model;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Cart {
   public Cart(Customer customer) {
		super();
		this.customer = customer;
	}
@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @ManyToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;
   @ManyToMany
   @JoinTable(
       name = "cart_products",
       joinColumns = @JoinColumn(name = "cart_id"),
       inverseJoinColumns = @JoinColumn(name = "product_id")
   )
   private List<Product> products = new ArrayList<>();
   private BigDecimal totalPrice;
}
