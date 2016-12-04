package pl.pawelozdoba.britenet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pawelozdoba.britenet.domain.RodzajMuzyki;
import pl.pawelozdoba.britenet.domain.Wykonawca;

public interface RodzajMuzykiRepository extends JpaRepository<RodzajMuzyki, Integer>{

	List<RodzajMuzyki> findByNazwaStartingWith(String tekst);
}
