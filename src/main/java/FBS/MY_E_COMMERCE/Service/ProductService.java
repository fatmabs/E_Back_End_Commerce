package FBS.MY_E_COMMERCE.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FBS.MY_E_COMMERCE.Model.Category;
import FBS.MY_E_COMMERCE.Model.Product;
import FBS.MY_E_COMMERCE.Repository.CategoryRepository;
import FBS.MY_E_COMMERCE.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepository;

	  // Retrieve all products
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    // Retrieve a product by ID
    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }
    // Retrieve products by category
    public List<Product> getProductsByCategory(int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return productRepo.findByCategory(category);
    }
    // Create or update a product
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
    // Delete a product by ID
    public void deleteProduct(int id) {
    	productRepo.deleteById(id);
    }

}
