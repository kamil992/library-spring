package library.models;

import java.util.List;

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
	
	@OneToMany(mappedBy = "author")
	private List<Book> booksList;
	
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

	public void setFirstName(String fullName) {
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

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + fullName + ", lifeDate=" + lifeDate
				+ ", description=" + description + "]";
	}
	
	

}
