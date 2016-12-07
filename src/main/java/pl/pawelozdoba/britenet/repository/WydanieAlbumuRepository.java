package pl.pawelozdoba.britenet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pawelozdoba.britenet.domain.WydanieAlbumu;

public interface WydanieAlbumuRepository extends JpaRepository<WydanieAlbumu, Integer>{

	
	List<WydanieAlbumu> findByRokLike(Integer rok);
}
