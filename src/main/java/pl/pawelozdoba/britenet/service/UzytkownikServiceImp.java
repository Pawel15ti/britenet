package pl.pawelozdoba.britenet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawelozdoba.britenet.domain.Uzytkownik;
import pl.pawelozdoba.britenet.repository.UzytkownikRepository;

@Service
public class UzytkownikServiceImp implements UzytkownikService {
	@Autowired
	private UzytkownikRepository uzytkownikRepository;

	@Override
	@Transactional
	public Uzytkownik utworz(Uzytkownik uzytkownik) {
		
		return uzytkownikRepository.save(uzytkownik);
	}

	@Override
	@Transactional
	public Uzytkownik edytuj(Uzytkownik uzytkownik) {
		return uzytkownikRepository.save(uzytkownik);
	}

	@Override
	@Transactional(readOnly=true)
	public Uzytkownik znajdz(Integer id) {
		return uzytkownikRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Uzytkownik> znajdzWszystkie() {
		return uzytkownikRepository.findAll();
	}

}
