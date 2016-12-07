package pl.pawelozdoba.britenet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pawelozdoba.britenet.domain.Album;
import pl.pawelozdoba.britenet.domain.RodzajMuzyki;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

	Album findByTytul(String tytul);

	// wykonawcy - Like
	List<Album> findByWykonawcyLike(String wykonawcy);

	// rok
	List<Album> findByWydaniaAlbumuRok(Short rok);

	// rodzaj muzyki
	List<Album> findByRodzajMuzykiLike(RodzajMuzyki rodzajMuzyki);

	// rodzaj muzyki, wykonawcy
	List<Album> findByRodzajMuzykiAndWykonawcyLike(RodzajMuzyki rodzajMuzyki, String wykonawcy);

	// rodzaj muzki , rok
	List<Album> findByRodzajMuzykiAndWydaniaAlbumuRokLike(RodzajMuzyki rodzajMuzyki, Short rok);

	// rok, wykonawcy
	List<Album> findByWydaniaAlbumuRokAndWykonawcyLike(Short rok, String wykonawcy);

	// rodzaj muzyki, rok ,wykonawcy
	List<Album> findByRodzajMuzykiAndWydaniaAlbumuRokAndWykonawcyLike(RodzajMuzyki rodzajMuzyki, Short rok,
			String wykonawcy);
}
