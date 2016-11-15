package pl.pawelozdoba.britenet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawelozdoba.britenet.domain.Wykonawca;
import pl.pawelozdoba.britenet.repository.WykonawcaRepository;

@Service
public class WykonawcaServiceImpl implements WykonawcaService{

	@Autowired
	private WykonawcaRepository wykonawcaRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Wykonawca> findByNazwaStartingWith(String tekst) {
		// TODO Auto-generated method stub
		return wykonawcaRepository.findByNazwaStartingWith(tekst);
	}

}
