package pl.pawelozdoba.britenet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Sciezka {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size.List({
		@Size(max = 50, message="tytuł nie może zawierać więcej niż {max} znaków"),
		@Size(min = 1, message = "tytuł musi mieć conajmniej {min} znaków ")
	})
	@NotNull(message="tytul jest wymagany")
	private String tytul;
	@NotNull(message="czas jest wymagany")
	private Integer czas;
	@NotNull(message="pozycja jest wymagana")
	private Short pozycja;
	@Size(max = 1000, message="informacje nie mogą zawierać więcej niż {max} znaków")
	private String informacje;
	
	@ManyToOne
	@JoinColumn(name = "album_id")
	@NotNull(message="album jest wymagany")
	private Album album;
	
	
	public Sciezka() {
		super();
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
		Sciezka other = (Sciezka) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Sciezka [id=" + id + ", tytul=" + tytul + "]";
	}



	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public Integer getCzas() {
		return czas;
	}
	public void setCzas(Integer czas) {
		this.czas = czas;
	}
	public Short getPozycja() {
		return pozycja;
	}
	public void setPozycja(Short pozycja) {
		this.pozycja = pozycja;
	}
	public String getInformacje() {
		return informacje;
	}
	public void setInformacje(String informacje) {
		this.informacje = informacje;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
