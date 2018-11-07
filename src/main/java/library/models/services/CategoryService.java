package library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.models.entity.Category;
import library.models.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Transactional
	public List<Category> getCategoryList(){
		return categoryRepository.getCategoryList();
	}

}
