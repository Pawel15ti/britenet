package pl.pawelozdoba.britenet.service;

import java.util.List;

import pl.pawelozdoba.britenet.domain.Uzytkownik;

public interface UzytkownikService {

	Uzytkownik utworz(Uzytkownik uzytkownik);
	Uzytkownik edytuj(Uzytkownik uzytkownik);
	Uzytkownik znajdz(Integer id);
	List<Uzytkownik> znajdzWszystkie();
	
}
