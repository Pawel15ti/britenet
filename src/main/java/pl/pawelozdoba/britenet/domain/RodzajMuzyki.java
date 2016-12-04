package pl.pawelozdoba.britenet.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rodzaj_muzyki")
public class RodzajMuzyki {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true)
	@Size(max = 20)
	private String nazwa;
	@ManyToMany(mappedBy = "rodzajMuzyki")
	private List<Album> albumy;

	public RodzajMuzyki() {
		super();
	}
	
	

	public RodzajMuzyki(String nazwa) {
		super();
		this.nazwa = nazwa;
	}



	public RodzajMuzyki(Integer id, String nazwa) {
		super();
		this.id = id;
		this.nazwa = nazwa;
	}



	@Override
	public String toString() {
		return "RodzajMuzyki [id =" + id + ", nazwa=" + nazwa + "]";
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
		RodzajMuzyki other = (RodzajMuzyki) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Album> getAlbumy() {
		return albumy;
	}

	public void setAlbumy(List<Album> albumy) {
		this.albumy = albumy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
