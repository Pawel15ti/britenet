package pl.pawelozdoba.britenet.it;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import pl.pawelozdoba.britenet.domain.RodzajMuzyki;
import pl.pawelozdoba.britenet.service.AlbumService;
import pl.pawelozdoba.britenet.service.RodzajMuzykiService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TestyIntegracyjne {

	@Autowired
	private RodzajMuzykiService rodzajMuzykiService;
	
	@Autowired
	private AlbumService albumService;
	
	@Test
	public void znajdzRodzajMuzyki(){
		
		List<RodzajMuzyki> list = rodzajMuzykiService.znajdzWszystkie();
		for(RodzajMuzyki rodzajMuzyki:list){
			System.out.println(rodzajMuzyki);
		}
			
	}
	
	@Test
	public void utworzAlbum(){
		
		
		
	}
	
}
