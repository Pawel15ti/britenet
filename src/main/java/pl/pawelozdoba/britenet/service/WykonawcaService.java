package pl.pawelozdoba.britenet.service;

import java.util.List;

import pl.pawelozdoba.britenet.domain.Wykonawca;

public interface WykonawcaService {

	List<Wykonawca> findByNazwaStartingWith(String tekst);
}
