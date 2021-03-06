package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface CategoryService {

	List<Category> findAll();

	Category save(Category category);

	Category update(Category category);

	Category findById(Integer categoryId);

	void deleteById(Integer categoryId);

}