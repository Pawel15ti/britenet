package pl.pawelozdoba.britenet.service;


import java.util.List;

import pl.pawelozdoba.britenet.domain.WydanieAlbumu;

public interface WydanieAlbumuService {

	WydanieAlbumu znajdz(Integer id);
	List<WydanieAlbumu> edytuj(WydanieAlbumu wydanie);
}
