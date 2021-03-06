package pl.pawelozdoba.britenet.service;

import java.util.List;

import pl.pawelozdoba.britenet.domain.Album;
import pl.pawelozdoba.britenet.domain.RodzajMuzyki;

public interface AlbumService {

	Album utworz(Album album);
	Album edytuj(Album album);
	Album znajdz(Integer id);
	List<Album> znajdzWszystkie();
	List<Album> znajdzWszystkie(RodzajMuzyki rodzajMuzyki,Short rok, String wykonawcy);
	
	//
	Album findByTytul(String tytul);
	List<Album> znajdzWedlugWykonawcy(String wykonawcy);
	List<Album> znajdzWedlugRoku(Integer rok);
	List<Album> znajdzWedlugRodzajuMuzyki(RodzajMuzyki rodzajMuzyki);
	
}
