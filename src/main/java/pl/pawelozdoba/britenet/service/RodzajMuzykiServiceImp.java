package pl.pawelozdoba.britenet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawelozdoba.britenet.domain.RodzajMuzyki;
import pl.pawelozdoba.britenet.repository.RodzajMuzykiRepository;

@Service
public class RodzajMuzykiServiceImp implements RodzajMuzykiService {
	
	@Autowired
	private RodzajMuzykiRepository rodzajMuzykiRepository;

	@Transactional(readOnly=true)
	@Override
	public List<RodzajMuzyki> znajdzWszystkie() {
		
		return rodzajMuzykiRepository.findAll();
	}

}
