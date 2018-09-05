package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.dao.AuthorRepository;
import library.models.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Transactional
	public Author getAuthor(int id){
		
		return authorRepository.getAuthor(id);
	}

}
