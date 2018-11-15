package library.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "life_date")
	private String lifeDate;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "author",
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Book> booksList;
	
	@Column(name = "picture")
	private String picture;
	
	public Author(){}
	
	public Author(String fullName, String lifeDate, String description){
		this.fullName = fullName;
		this.lifeDate = lifeDate;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public String getLifeDate() {
		return lifeDate;
	}

	public void setLifeDate(String lifeDate) {
		this.lifeDate = lifeDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public List<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}
	
//	public void addBook(Book book){
//		if(booksList == null){
//			booksList = new ArrayList<>();
//		}
//		
//		booksList.add(book);
//		book.setAuthor(this);
//	}
	

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + fullName + ", lifeDate=" + lifeDate
				+ ", description=" + description + "]";
	}
	
	

}
