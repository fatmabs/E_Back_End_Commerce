package FBS.MY_E_COMMERCE.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Customer {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
	    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	    private List<Order> orders;
	    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	    private List<Address> addresses;

}
