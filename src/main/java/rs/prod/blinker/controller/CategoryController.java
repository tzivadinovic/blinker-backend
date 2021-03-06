package rs.prod.blinker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.Category;
import rs.prod.blinker.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		return ResponseEntity.ok(categoryService.findAll());
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer categoryId) {
		return ResponseEntity.ok(categoryService.findById(categoryId));
	}

	@PostMapping
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
	}

	@PutMapping
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.update(category));
	}

	@DeleteMapping("/{categoryId}")
	public void deleteCategoryById(@PathVariable Integer categoryId) {
		categoryService.deleteById(categoryId);
	}

}

