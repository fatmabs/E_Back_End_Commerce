package FBS.MY_E_COMMERCE.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import FBS.MY_E_COMMERCE.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
		 // Custom query to find a category by name
	
		@Query("SELECT c FROM Category c WHERE c.name LIKE %:name%")
		Optional<Category> findByName(String name);
		
		 
		 
		 
		 
		 
		 


}
