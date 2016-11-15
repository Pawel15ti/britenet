package pl.pawelozdoba.britenet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pawelozdoba.britenet.domain.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

	// ALbum findByNazwa(String nazwa); ==> find -> Select a FROM Album a  ; by==> Where (byNazwa => WHERE  a.nazwa=:nazwa)
	// ALbum findByNazwaAndWykonawcy(String nazwa,String wykonawcy); ==> Select a from Album a WHERE a.nazwa=:nazwa and a.wykonawcy = :wykonawcy
}
