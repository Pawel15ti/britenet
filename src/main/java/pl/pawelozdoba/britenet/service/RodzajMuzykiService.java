package pl.pawelozdoba.britenet.service;

import java.util.List;

import pl.pawelozdoba.britenet.domain.RodzajMuzyki;
import pl.pawelozdoba.britenet.domain.Wykonawca;

public interface RodzajMuzykiService {

	List<RodzajMuzyki> znajdzWszystkie();
	List<RodzajMuzyki> findByNazwaStartingWith(String tekst);
	
}
