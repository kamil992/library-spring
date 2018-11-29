package library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.models.repository.AuthorRepository;
import library.models.entity.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Transactional
	public Author getAuthor(int id){	
		return authorRepository.getAuthor(id);
	}
	
	@Transactional
	public Author getAuthor(String fullName){
		return authorRepository.getAuthor(fullName);
	}
	
	@Transactional
	public List<Author> getAuthorsList(){
		return authorRepository.getAuthorList();
	}
}
