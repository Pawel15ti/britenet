package pl.pawelozdoba.britenet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pawelozdoba.britenet.domain.Wykonawca;

public interface WykonawcaRepository extends JpaRepository<Wykonawca, Integer>{

	List<Wykonawca> findByNazwaStartingWith(String tekst);
}
