package pl.pawelozdoba.britenet.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawelozdoba.britenet.domain.Album;
import pl.pawelozdoba.britenet.domain.RodzajMuzyki;
import pl.pawelozdoba.britenet.domain.WydanieAlbumu;
import pl.pawelozdoba.britenet.domain.Wykonawca;
import pl.pawelozdoba.britenet.repository.AlbumRepository;
import pl.pawelozdoba.britenet.repository.WydanieAlbumuRepository;
import pl.pawelozdoba.britenet.repository.WykonawcaRepository;

@Service
public class AlbumServiceImp implements AlbumService {
	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private WykonawcaRepository wykonawcaRepository;

	@Autowired
	private WydanieAlbumuRepository wydanieAlbumuRepository;

	@Override
	@Transactional
	public Album utworz(Album album) {

		Wykonawca wykonawca = album.getWykonawca();

		if (wykonawca.getId() == null) {
			wykonawcaRepository.save(wykonawca);
		}

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
		Album album = albumRepository.findOne(id);
		// wymyszenie pobrania wydaniaAlbumu z bazy
		album.getWydaniaAlbumu().size();
		album.getSciezki().size();
		album.getRodzajMuzyki().size();
		return album;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Album> znajdzWszystkie() {

		List<Album> albumy = albumRepository.findAll();
		/*
		 * for(Album album: albumy){ album.getRodzajMuzyki().size(); }
		 */
		return albumy;
	}

	@Override
	public List<Album> znajdzWszystkie(RodzajMuzyki rodzajMuzyki, Short rok, String wykonawcy) {

		if (rodzajMuzyki == null && rok == null && wykonawcy != null ) {
			return albumRepository.findByWykonawcyLike("%" + wykonawcy + "%");
		} else if (rodzajMuzyki == null && rok != null && (wykonawcy == null || wykonawcy.isEmpty())) {
			return albumRepository.findByWydaniaAlbumuRok(rok);
		} else if (rodzajMuzyki != null && rok == null && (wykonawcy == null || wykonawcy.isEmpty())) {
			return albumRepository.findByRodzajMuzykiLike(rodzajMuzyki);
		
		} else if (rodzajMuzyki != null && rok == null && wykonawcy != null ) {
			return albumRepository.findByRodzajMuzykiAndWykonawcyLike(rodzajMuzyki, "%" + wykonawcy + "%");
		}

		else if (rodzajMuzyki != null && rok != null && (wykonawcy == null || wykonawcy.isEmpty())) {
			System.out.println("!!!!!!!");
			return albumRepository.findByRodzajMuzykiAndWydaniaAlbumuRokLike(rodzajMuzyki , rok);
			
		}
		else if(rodzajMuzyki ==null && rok!=null && wykonawcy!=null)
		{
			return albumRepository.findByWydaniaAlbumuRokAndWykonawcyLike(rok, "%"+wykonawcy+"%");
			
		}
		else if(rodzajMuzyki ==null  && rok==null && (wykonawcy==null|| wykonawcy.isEmpty()))
		{
			return albumRepository.findAll();
			
		}
		else if(rodzajMuzyki !=null  && rok!=null && wykonawcy!=null)
		{
			return albumRepository.findByRodzajMuzykiAndWydaniaAlbumuRokAndWykonawcyLike(rodzajMuzyki, rok, "%"+wykonawcy+"%");
			
		}
		else
			// if(rodzajMuzyki==null&&rok==null&&wykonawcy!=null)
			// return albumRepository.findBy... "%"+wykonawcy+"%" //abc ->%b%
			// TODO Auto-generated method stub
			// jezli wszytsko null to zwraca wszystko albumRepository.findAll();
			return albumRepository.findAll();

	}

	@Override
	public Album findByTytul(String tytul) {

		return albumRepository.findByTytul(tytul);
	}

	@Override
	public List<Album> znajdzWedlugWykonawcy(String wykonawcy) {

		return null;
	}

	@Override
	public List<Album> znajdzWedlugRodzajuMuzyki(RodzajMuzyki rodzajMuzyki) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Album> znajdzWedlugRoku(Integer rok) {
		// TODO Auto-generated method stub
		return null;
	}

}
