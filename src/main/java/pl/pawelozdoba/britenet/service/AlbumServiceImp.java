package pl.pawelozdoba.britenet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawelozdoba.britenet.domain.Album;
import pl.pawelozdoba.britenet.domain.RodzajMuzyki;
import pl.pawelozdoba.britenet.repository.AlbumRepository;

@Service
public class AlbumServiceImp implements AlbumService {
	@Autowired
	private AlbumRepository albumRepository;

	@Override
	@Transactional
	public Album utworz(Album album) {

		return albumRepository.save(album);
	}

	@Override
	@Transactional
	public Album edytuj(Album album) {

		return albumRepository.save(album);
	}

	@Override
	@Transactional(readOnly = true)
	public Album znajdz(Integer id) {

		return albumRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Album> znajdzWszystkie() {

		return albumRepository.findAll();
	}

	@Override
	public List<Album> znajdzWszystkie(RodzajMuzyki rodzajMuzyki, Short rok, String wykonawcy) {
		// TODO Auto-generated method stub
		return null;
	}

}
