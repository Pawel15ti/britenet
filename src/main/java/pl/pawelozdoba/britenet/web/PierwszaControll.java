package pl.pawelozdoba.britenet.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.pawelozdoba.britenet.domain.Album;
import pl.pawelozdoba.britenet.domain.Wykonawca;
import pl.pawelozdoba.britenet.service.AlbumService;
import pl.pawelozdoba.britenet.service.WykonawcaService;


@Named // tworzy kontroler w JSF o nazwie "pierwszaControll"
@ViewScoped // zasieg kontrolera - viewScoped do momentu kiedy uzytkownik nie zmieni strony
public class PierwszaControll implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Album album;

	@Inject // 1.Zawsze szuka obiektow ManagedBean w JSF 2.Jesli nie znajdzie to szuka w konteksie Springa
	private AlbumService albumService;
	
	@Inject
	private WykonawcaService wykonawcaService;
	
	@PostConstruct //ta funckaj wykona sie po zainicjowania obiektu kontrolera
	public void init(){
		System.out.println("album = "+ albumService);
		this.album = new Album();
	}
	
	public List<Wykonawca> listaWykonawcy(String tekst){
		
		if(tekst == null || tekst.isEmpty())
			return new ArrayList<>();
		
		List<Wykonawca> wykonawcy = wykonawcaService.findByNazwaStartingWith(tekst);
		if(wykonawcy.isEmpty()){
			wykonawcy.add(new Wykonawca(tekst));
		}
		
		
		return wykonawcy;
	}
	
	public void utworz(){
		System.out.println(album.getTytul());
	}
	
	public List<Album> getAlbumService() {
		return albumService.znajdzWszystkie();
	}
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
	

	
	
	

	
	
	
}
