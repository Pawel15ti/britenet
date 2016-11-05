package pl.pawelozdoba.britenet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pawelozdoba.britenet.domain.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

}
