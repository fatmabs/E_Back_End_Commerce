package FBS.MY_E_COMMERCE.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FBS.MY_E_COMMERCE.Model.Category;
import FBS.MY_E_COMMERCE.Repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepo;
	
	   // Retrieve all categories
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
    // Retrieve a category by ID
    public Optional<Category> getCategoryById(int id) {
        return categoryRepo.findById(id);
    }
    // Create or update a category

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }
    // Delete a category by ID
    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }
 

}
