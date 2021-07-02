package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PronalazakTest extends IOpstiDomenskiObjekatTest{
	public Pronalazak pronalazak;
	@BeforeEach
	void setUp() throws Exception {
		opstiDomenskiObjekat = new Pronalazak();
		pronalazak= new Pronalazak();
	}

	@AfterEach
	void tearDown() throws Exception {
		pronalazak= null;
		opstiDomenskiObjekat=null;
	}

	@Test
	void testPronalazak() {
		pronalazak= new Pronalazak();
		assertNotNull(pronalazak);
	}

	@Test
	void testPronalazakPrijavaPronalaskaPsaZahtevZaTrazenjePsaDateString() {
		Rasa r = new Rasa(1,"rasa","/");
		Lokacija l = new Lokacija(1,"lokacija");
		Korisnik k = new Korisnik(123, "Tamara", "Tosic", "123456","tamara@test.com","lozinka");
		PrijavaPronalaskaPsa ppp= new PrijavaPronalaskaPsa(1,EnumPol.MUŠKI,"",new Date(),"bela",new ImageIcon(),r, l, 1.0,1.0,"opis",k);
		ZahtevZaTrazenjePsa zztp= new ZahtevZaTrazenjePsa(1,EnumPol.MUŠKI,"bela", new Date(), "kontakt",new ImageIcon(), 10,"ime",r,l,1.0,1.0,"opis",k);
		pronalazak= new Pronalazak(ppp,zztp, new Date(), "napomena");
		assertNotNull(pronalazak);
	}

	@Test
	void testSetPrijavaPronalaskaPsa() {
		Rasa r = new Rasa(1,"rasa","/");
		Lokacija l = new Lokacija(1,"lokacija");
		Korisnik k = new Korisnik(123, "Tamara", "Tosic", "123456","tamara@test.com","lozinka");
		PrijavaPronalaskaPsa ppp= new PrijavaPronalaskaPsa(1,EnumPol.MUŠKI,"",new Date(),"bela",new ImageIcon(),r, l, 1.0,1.0,"opis",k);
		pronalazak.setPrijavaPronalaskaPsa(ppp);
		assertEquals(ppp, pronalazak.getPrijavaPronalaskaPsa());
	}
	@Test
	void testSetPrijavaPronalaskaPsaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->pronalazak.setPrijavaPronalaskaPsa(null));
	}
	@Test
	void testSetZahtevZaTrazenjePsa() {
		Rasa r = new Rasa(1,"rasa","/");
		Lokacija l = new Lokacija(1,"lokacija");
		Korisnik k = new Korisnik(123, "Tamara", "Tosic", "123456","tamara@test.com","lozinka");
		ZahtevZaTrazenjePsa zztp= new ZahtevZaTrazenjePsa(1,EnumPol.MUŠKI,"bela", new Date(), "kontakt",new ImageIcon(), 10,"ime",r,l,1.0,1.0,"opis",k);
		pronalazak.setZahtevZaTrazenjePsa(zztp);
		assertEquals(zztp, pronalazak.getZahtevZaTrazenjePsa());
	}
	@Test
	void testSetZahtevZaTrazenjePsaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->pronalazak.setZahtevZaTrazenjePsa(null));
	}

	@Test
	void testSetDatumResavanjaSlucaja() {
		Date datum = new Date();
		pronalazak.setDatumResavanjaSlucaja(datum);
		assertEquals(datum, pronalazak.getDatumResavanjaSlucaja());
	}

	@Test
	void testSetNapomena() {
		pronalazak.setNapomena("napomena");
		assertEquals("napomena", pronalazak.getNapomena());
	}

}
