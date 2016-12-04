package pl.pawelozdoba.britenet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Uzytkownik {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	@NotNull
	private String login;
	@Size.List({ 
		@Size(min=8, message="Haslo musi zawierać przynajmniej {min} znaków"),
		//@Size (min=8, message="Haslo musi zawierać przynajmniej {min} znaków"),
	})
	@NotNull
	private String haslo;
	private String message;
	

	public String logowanie()
	{
		if(login.equals("login")&& haslo.equals("haslo"))
		{
			message="Prawidłowe dane logowania";
		}
		else if(login.equals("")&& haslo.equals(""))
		{
			message="Błędne dane logowania";
		}
		return message;
	}
	
	
	
	
	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	
	public Uzytkownik() {
		super();
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uzytkownik other = (Uzytkownik) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Uzytkownik [id=" + id +  "]";
	}
	
	
}
