package pl.pawelozdoba.britenet.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;

import pl.pawelozdoba.britenet.domain.Album;
import pl.pawelozdoba.britenet.domain.RodzajMuzyki;
import pl.pawelozdoba.britenet.domain.Sciezka;
import pl.pawelozdoba.britenet.domain.Uzytkownik;
import pl.pawelozdoba.britenet.domain.WydanieAlbumu;
import pl.pawelozdoba.britenet.domain.Wykonawca;
import pl.pawelozdoba.britenet.service.AlbumService;
import pl.pawelozdoba.britenet.service.RodzajMuzykiService;
import pl.pawelozdoba.britenet.service.WykonawcaService;

@Named
@ViewScoped
public class PierwszaControll implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Album album;
	private Sciezka sciezka;
	//
	private RodzajMuzyki rodzajMuzyki;

	private WydanieAlbumu wydanieAlbumu;
	private Uzytkownik uzytkownik;
	// dodaj Wydanie albumu sukces i ukrycie głównego formularza po utworzeniu
	private boolean dodajSciezkaSukces;
	private boolean dodajAlbumSukces;
	private boolean dodajWydanieAlbumuSukces;
	private boolean edytujAlbumSukces;
	private List<Album> albumy;

	private List<RodzajMuzyki> rodzajeMuzyki;
	private RodzajMuzyki filtrRodzajMuzyki;
	private String filtrWykonawcy;
	private Short filtrRok;
	private Short filtrRok1;

	private Album zaznaczonyAlbum;
	private Album albumEdycja;

	@Inject
	private AlbumService albumService;

	@Inject
	private WykonawcaService wykonawcaService;

	@Inject
	private RodzajMuzykiService rodzajMuzykiService;

	public Uzytkownik getUzytkownik() {
		return uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	///////////////////////////////////////////////////////////////////////////

	@PostConstruct // ta funckaj wykona sie po zainicjowania obiektu kontrolera
	public void init() {

		this.albumy = albumService.znajdzWszystkie();
		rodzajeMuzyki = rodzajMuzykiService.znajdzWszystkie();

	}

	public boolean isEdytujButtonDisabled() {
		if (zaznaczonyAlbum == null)
			return true;
		else
			return false;
	}
	///////////////////////////////////////////////////////////////////////////

	public List<Album> znajdzAlbumy() {

		return albumService.znajdzWszystkie();
	}

	public List<Wykonawca> listaWykonawcy(String tekst) {

		if (tekst == null || tekst.isEmpty())
			return new ArrayList<>();

		List<Wykonawca> wykonawcy = wykonawcaService.findByNazwaStartingWith(tekst);
		if (wykonawcy.isEmpty()) {
			wykonawcy.add(new Wykonawca(tekst));
		}

		return wykonawcy;

	}

	public List<RodzajMuzyki> listaRodzajMuzyki(String tekst) {

		if (tekst == null || tekst.isEmpty())
			return new ArrayList<>();

		List<RodzajMuzyki> lista = rodzajMuzykiService.findByNazwaStartingWith(tekst);

		return lista;

	}

	///////////////////////////////////////////////////////////////////////////

	public void utworz() {

		albumService.utworz(album);
		this.dodajAlbumSukces = true;

	}

	public void edytuj() {
		albumService.edytuj(albumEdycja);
		this.edytujAlbumSukces = true;
		this.albumy = albumService.znajdzWszystkie(filtrRodzajMuzyki, filtrRok, filtrWykonawcy);
	}

	///////////////////////////////////////////////////////////////////////////
	public void inicjujAlbum() {
		this.album = new Album();
		this.album.setSciezki(new ArrayList<>());
		this.album.setWydaniaAlbumu(new ArrayList<>());
		this.dodajAlbumSukces = false;
	}

	public void inicjujSciezke() {
		System.out.println("inicjuje sciezka");
		sciezka = new Sciezka();
		dodajSciezkaSukces = false;
	}

	public void inicjujAlbumWydanie() {
		System.out.println("inicjuje wydanie");
		wydanieAlbumu = new WydanieAlbumu();
		dodajWydanieAlbumuSukces = false;
	}

	public void inicjujAlbumEdycja() {
		Integer id = zaznaczonyAlbum.getId();
		albumEdycja = albumService.znajdz(id);
		this.edytujAlbumSukces = false;
	}

	public void dodajSciezke() {
		// Dodaje do albumu sciezke
		album.dodajSciezka(sciezka);
		;
		// czyszcze pole sciezka w kontrolrze
		sciezka = null;
		dodajSciezkaSukces = true;
		System.out.println("Dodano sciezke");
	}

	public void dodajSciezkeEdycja() {
		// Dodaje do albumu sciezke
		this.albumEdycja.dodajSciezka(sciezka);
		// czyszcze pole sciezka w kontrolrze
		sciezka = null;
		dodajSciezkaSukces = true;
		System.out.println("Dodano sciezke");
	}

	public void dodajWydanieEdycja() {
		// Dodaje do albumu wydanie
		// album.getWydaniaAlbumu().add(wydanieAlbumu);
		this.albumEdycja.dodajWydanie(wydanieAlbumu);
		// czyszcze pole sciezka w kontrolrze
		wydanieAlbumu = null;
		// System.out.println("Dodano wydanie albumu");
		dodajWydanieAlbumuSukces = true;
		System.out.println("Dodano wydanie");
	}

	public void dodajWydanie() {
		// Dodaje do albumu wydanie
		// album.getWydaniaAlbumu().add(wydanieAlbumu);
		album.dodajWydanie(wydanieAlbumu);
		// czyszcze pole sciezka w kontrolrze
		wydanieAlbumu = null;
		// System.out.println("Dodano wydanie albumu");
		dodajWydanieAlbumuSukces = true;
		System.out.println("Dodano wydanie");
	}

	public void resetFiltrow() {
		System.out.println("wykonawcy=" + filtrWykonawcy + " rok=" + filtrRok + " rok1=" + filtrRok1 + " rodzaj="
				+ filtrRodzajMuzyki);
		filtrRodzajMuzyki = null;
		filtrRok = null;
		filtrWykonawcy = null;

		this.albumy = albumService.znajdzWszystkie(filtrRodzajMuzyki, filtrRok, filtrWykonawcy);
	}

	public void filtruj() {
		System.out.println("wykonawcy=" + filtrWykonawcy + " rok=" + filtrRok + " rok1=" + filtrRok1 + " rodzaj="
				+ filtrRodzajMuzyki);
		this.albumy = albumService.znajdzWszystkie(filtrRodzajMuzyki, filtrRok, filtrWykonawcy);
	}

	public List<Short> getRokZasieg2() {
		short start = 1901;
		short end = 2016;

		List<Short> lata = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			lata.add((short) i);
		}

		return lata;
	}

	//// getters and setters

	public List<Album> getAlbumService() {
		return albumService.znajdzWszystkie();
	}

	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Sciezka getSciezka() {
		return sciezka;
	}

	public WydanieAlbumu getWydanieAlbumu() {
		return wydanieAlbumu;
	}

	public void setWydanieAlbumu(WydanieAlbumu wydanieAlbumu) {
		this.wydanieAlbumu = wydanieAlbumu;
	}

	public void setSciezka(Sciezka sciezka) {
		this.sciezka = sciezka;
	}

	public boolean isDodajSciezkaSukces() {
		return dodajSciezkaSukces;
	}

	public void setDodajSciezkaSukces(boolean dodajSciezkaSukces) {
		this.dodajSciezkaSukces = dodajSciezkaSukces;
	}

	public List<Album> getAlbumy() {
		return albumy;
	}

	public void setAlbumy(List<Album> albumy) {
		this.albumy = albumy;
	}

	public RodzajMuzyki getRodzajMuzyki() {
		return rodzajMuzyki;
	}

	public void setRodzajMuzyki(RodzajMuzyki rodzajMuzyki) {
		this.rodzajMuzyki = rodzajMuzyki;
	}

	public List<RodzajMuzyki> getRodzajeMuzyki() {
		return rodzajeMuzyki;
	}

	public void setRodzajeMuzyki(List<RodzajMuzyki> rodzajeMuzyki) {
		this.rodzajeMuzyki = rodzajeMuzyki;
	}

	public RodzajMuzyki getFiltrRodzajMuzyki() {
		return filtrRodzajMuzyki;
	}

	public void setFiltrRodzajMuzyki(RodzajMuzyki filtrRodzajMuzyki) {
		this.filtrRodzajMuzyki = filtrRodzajMuzyki;
	}

	public Short getFiltrRok() {
		return filtrRok;
	}

	public void setFiltrRok(Short filtrRok) {
		this.filtrRok = filtrRok;
	}

	public String getFiltrWykonawcy() {
		return filtrWykonawcy;
	}

	public void setFiltrWykonawcy(String filtrWykonawcy) {
		this.filtrWykonawcy = filtrWykonawcy;
	}

	public boolean isDodajAlbumSukces() {
		return dodajAlbumSukces;
	}

	public void setDodajAlbumSukces(boolean dodajAlbumSukces) {
		this.dodajAlbumSukces = dodajAlbumSukces;
	}

	public boolean isDodajWydanieAlbumuSukces() {
		return dodajWydanieAlbumuSukces;
	}

	public void setDodajWydanieAlbumuSukces(boolean dodajWydanieAlbumuSukces) {
		this.dodajWydanieAlbumuSukces = dodajWydanieAlbumuSukces;
	}

	public Album getZaznaczonyAlbum() {
		return zaznaczonyAlbum;
	}

	public void setZaznaczonyAlbum(Album zaznaczonyAlbum) {
		this.zaznaczonyAlbum = zaznaczonyAlbum;
	}

	public Album getAlbumEdycja() {
		return albumEdycja;
	}

	public void setAlbumEdycja(Album albumEdycja) {
		this.albumEdycja = albumEdycja;
	}

	public boolean isEdytujAlbumSukces() {
		return edytujAlbumSukces;
	}

	public void setEdytujAlbumSukces(boolean edytujAlbumSukces) {
		this.edytujAlbumSukces = edytujAlbumSukces;
	}

}
