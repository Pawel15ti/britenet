package pl.pawelozdoba.britenet.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Wykonawca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size.List({
		@Size(max = 60,message="nazwa nie może zawierać więcej niż {max} znaków"),
		@Size(min = 1,message="nazwa musi zawierać {min} znaków")
	})
	@NotNull(message="nazwa jest wymagana")
	@Column(unique=true)
	private String nazwa;
	@OneToMany(mappedBy="wykonawca")
	private List<Album> albumy;

	public Wykonawca() {
		super();
	}
	
	public Wykonawca(String nazwa){
		this.nazwa = nazwa;
	}

	
	public Wykonawca(Integer id, String nazwa) {
		super();
		this.id = id;
		this.nazwa = nazwa;
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
		Wykonawca other = (Wykonawca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wykonawca [nazwa=" + nazwa + "]";
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Album> getAlbumy() {
		return albumy;
	}

	public void setAlbumy(List<Album> albumy) {
		this.albumy = albumy;
	}

}
