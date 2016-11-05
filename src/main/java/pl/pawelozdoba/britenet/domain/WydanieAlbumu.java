package pl.pawelozdoba.britenet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class WydanieAlbumu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size.List({
		@Size(max = 20, message="kraj nie może zawierać więcej niż {max} znaków"),
		@Size(min = 2, message = "kraj musi mieć conajmniej {min} znaków ")
	})
	@NotNull(message="kraj jest wymagany")
	private String kraj;
	@Size.List({
		@Size(max = 20, message="wydawca nie może zawierać więcej niż {max} znaków"),
		@Size(min = 2, message = "wydawca musi mieć conajmniej {min} znaków ")
	})
	@NotNull(message="wydawca jest wymagany")
	private String wydawca;
	@NotNull(message="rok jest wymagany")
	@Min(value=1900,message="rok wydania nie może być przed {value} roku")
	@Max(value=2050,message="rok wydania nie może być po {value} roku")
	private Short rok;
	@Size(max=100,message="medium nie moze mieć wiecej niż {max} znaków")
	private String medium;
	@Size(max=1000,message="opis nie może mieć wiecej niż {max} znaków")
	private String opis;
	@ManyToOne
	@JoinColumn(name = "album_id")
	@NotNull(message="album jest wymagany")
	private Album album;
	
	
	public WydanieAlbumu() {
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
		WydanieAlbumu other = (WydanieAlbumu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WydanieAlbumu [id=" + id + ", kraj=" + kraj + "]";
	}

	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public String getWydawca() {
		return wydawca;
	}
	public void setWydawca(String wydawca) {
		this.wydawca = wydawca;
	}
	public Short getRok() {
		return rok;
	}
	public void setRok(Short rok) {
		this.rok = rok;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
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
