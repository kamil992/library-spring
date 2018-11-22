package library.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import library.models.form.RegisterForm;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Size(min=4, message="min 4 signs")
	@Column(name="login")
	private String login;
	
	@Size(min=6, message="min 6 signs")
	@Column(name="password")
	private String password;
	
	@NotNull(message="is required")
	@Email(message="abc@abc.com etc.")
	@Column(name="email")
	private String email;
	
	public User(){}
	
	public User(RegisterForm registerForm){
		this.login = registerForm.getLogin();
		this.password = registerForm.getPassword();
		this.email = registerForm.getEmail();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
