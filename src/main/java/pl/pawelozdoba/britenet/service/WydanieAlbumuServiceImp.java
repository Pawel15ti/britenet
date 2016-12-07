package pl.pawelozdoba.britenet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.pawelozdoba.britenet.domain.WydanieAlbumu;
import pl.pawelozdoba.britenet.repository.WydanieAlbumuRepository;

public class WydanieAlbumuServiceImp implements WydanieAlbumuService{

	@Autowired
	WydanieAlbumuRepository wydanieAlbumuRepository;
	@Transactional
	@Override
	public List<WydanieAlbumu> edytuj(WydanieAlbumu wydanie) {
		wydanieAlbumuRepository.save(wydanie);
		return null;
	}
	@Override
	public WydanieAlbumu znajdz(Integer id) {
		WydanieAlbumu wydanie = wydanieAlbumuRepository.findOne(id);
		
		
		return wydanie;
	}
	

}
