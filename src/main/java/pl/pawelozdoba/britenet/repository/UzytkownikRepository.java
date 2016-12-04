package pl.pawelozdoba.britenet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pawelozdoba.britenet.domain.Uzytkownik;

public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Integer>{

}
