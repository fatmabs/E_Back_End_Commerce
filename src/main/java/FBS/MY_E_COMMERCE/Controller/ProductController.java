package FBS.MY_E_COMMERCE.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FBS.MY_E_COMMERCE.Model.Product;
import FBS.MY_E_COMMERCE.Service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;
   // Get all products
   @GetMapping
   public List<Product> getAllProducts() {
       return productService.getAllProducts();
   }
   // Get product by ID
   @GetMapping("/{id}")
   public ResponseEntity<Product> getProductById(@PathVariable int id) {
       Optional<Product> product = productService.getProductById(id);
       return product.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
   }
   // Get products by category ID
   @GetMapping("/category/{categoryId}")
   public List<Product> getProductsByCategory(@PathVariable int categoryId) {
       return productService.getProductsByCategory(categoryId);
   }
   // Create or update product
   @PostMapping
   public Product saveProduct(@RequestBody Product product) {
       return productService.saveProduct(product);
   }
   // Delete product by ID
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
       productService.deleteProduct(id);
       return ResponseEntity.ok().build();
   }


}
