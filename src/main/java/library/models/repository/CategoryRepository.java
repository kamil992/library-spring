package library.models.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.models.dao.CategoryDao;
import library.models.entity.Category;

@Repository
public class CategoryRepository implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategoryList() {
		List<Category> categoryList;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Category> categories = session.createQuery("from Category order by name", Category.class);
		categoryList = categories.getResultList();
		
		return categoryList;
	}

	@Override
	public Category findCategory(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Category> category = session.createQuery("from Category where name='" + name + "'", Category.class);
		Category choosenCategory = category.getSingleResult();
		
		return choosenCategory;
	}

}
