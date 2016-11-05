package pl.pawelozdoba.britenet.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size.List({
		@Size(max = 50, message="tytuł nie może zawierać więcej niż {max} znaków"),
		@Size(min = 1, message = "tytuł musi mieć conajmniej {min} znaków ")
	})
	@NotNull(message="tytuł jest wymagany")
	private String tytul;
	@ManyToOne
	@JoinColumn(name= "wykonawca_id")
	@NotNull(message="wykonawca jest wymagany")
	private Wykonawca wykonawca;
	@ManyToOne
	@JoinColumn(name = "rodzaj_muzyki_id")
	
	@NotNull(message="rodzaj Muzyki jest wymagany")
	private RodzajMuzyki rodzajMuzyki;
	
	@Size.List({
		@Size(max = 1000, message="wykonawcy nie mogą zawierać więcej niż {max} znaków"),
		@Size(min = 5, message = "wykonawcy muszą mieć conajmniej {min} znaków ")
	})
	@NotNull(message="wykonawca jest wymagany")
	private String wykonawcy;
	@OneToMany(mappedBy="album")
	private List<WydanieAlbumu> wydaniaAlbumu;
	
	@OneToMany(mappedBy="album")
	private List<Sciezka> sciezki;
	
	
	
	public Album() {
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
		Album other = (Album) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Album [id=" + id + ", tytul=" + tytul + "]";
	}


	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public Wykonawca getWykonawca() {
		return wykonawca;
	}
	public void setWykonawca(Wykonawca wykonawca) {
		this.wykonawca = wykonawca;
	}
	public RodzajMuzyki getRodzajMuzyki() {
		return rodzajMuzyki;
	}
	public void setRodzajMuzyki(RodzajMuzyki rodzajMuzyki) {
		this.rodzajMuzyki = rodzajMuzyki;
	}
	public String getWykonawcy() {
		return wykonawcy;
	}
	public void setWykonawcy(String wykonawcy) {
		this.wykonawcy = wykonawcy;
	}
	public List<WydanieAlbumu> getWydaniaAlbumu() {
		return wydaniaAlbumu;
	}
	public void setWydaniaAlbumu(List<WydanieAlbumu> wydaniaAlbumu) {
		this.wydaniaAlbumu = wydaniaAlbumu;
	}
	public List<Sciezka> getSciezki() {
		return sciezki;
	}
	public void setSciezki(List<Sciezka> sciezki) {
		this.sciezki = sciezki;
	}
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
