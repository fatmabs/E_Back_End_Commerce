package FBS.MY_E_COMMERCE.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import FBS.MY_E_COMMERCE.Model.Category;
import FBS.MY_E_COMMERCE.Model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	 // Find products by category
	@Query("SELECT p FROM Product p WHERE p.category = category")
	 List<Product> findByCategory(Category category);
	 // Find products by name containing a keyword (for search functionality)
	@Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword%")
	 List<Product> findByNameContaining(String keyword);
	 // Find products that are in stock
	@Query("SELECT p FROM Product p WHERE p.stock > stock ")
	 List<Product> findByStockGreaterThan(int stock);
	 // Custom query to find products within a price range
	 @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
	 List<Product> findByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") 
	 BigDecimal maxPrice);

}
