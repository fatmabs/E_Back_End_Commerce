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

import FBS.MY_E_COMMERCE.Model.Category;
import FBS.MY_E_COMMERCE.Service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
   @Autowired
   CategoryService categoryService;
   

   // Get all categories
   @GetMapping
   public List<Category> getAllCategories() {
       return categoryService.getAllCategories();
   }
   
   // Get category by ID
   @GetMapping("/{id}")
   public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
       Optional<Category> category = categoryService.getCategoryById(id);
       return category.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
   }
   // Create or update category
   @PostMapping
   public Category saveCategory(@RequestBody Category category) {
       return categoryService.saveCategory(category);
   }
   
   // Delete category by ID
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
       categoryService.deleteCategory(id);
       return ResponseEntity.ok().build();
   }

}
