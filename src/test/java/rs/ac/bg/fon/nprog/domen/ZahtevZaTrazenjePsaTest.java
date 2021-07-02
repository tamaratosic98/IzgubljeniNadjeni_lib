package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZahtevZaTrazenjePsaTest extends IOpstiDomenskiObjekatTest{
	public ZahtevZaTrazenjePsa zahtevZaTrazenjePsa;
	@BeforeEach
	void setUp() throws Exception {
		opstiDomenskiObjekat = new ZahtevZaTrazenjePsa();
		zahtevZaTrazenjePsa= new ZahtevZaTrazenjePsa();
	}

	@AfterEach
	void tearDown() throws Exception {
		zahtevZaTrazenjePsa=null;
		opstiDomenskiObjekat=null;
	}

	@Test
	void testZahtevZaTrazenjePsa() {
		zahtevZaTrazenjePsa= new ZahtevZaTrazenjePsa();
		assertNotNull(zahtevZaTrazenjePsa);
	}

	@Test
	void testZahtevZaTrazenjePsaLongEnumPolStringDateStringImageIconIntStringRasaLokacijaDoubleDoubleStringKorisnik() {
		Rasa r = new Rasa(1,"rasa","/");
		Lokacija l = new Lokacija(1,"lokacija");
		Korisnik k = new Korisnik(123, "Tamara", "Tosic", "123456","tamara@test.com","lozinka");
		zahtevZaTrazenjePsa= new ZahtevZaTrazenjePsa(1,EnumPol.MUŠKI,"bela", new Date(), "kontakt",new ImageIcon(), 10,"ime",r,l,1.0,1.0,"opis",k);
		assertNotNull(zahtevZaTrazenjePsa);
		
	}

	@Test
	void testSetZahtevZaTrazenjePsaId() {
		zahtevZaTrazenjePsa.setZahtevZaTrazenjePsaId(1);
		assertEquals(1, zahtevZaTrazenjePsa.getZahtevZaTrazenjePsaId());
	}

	@Test
	void testSetPol() {
		zahtevZaTrazenjePsa.setPol(EnumPol.MUŠKI);
		assertEquals(EnumPol.MUŠKI, zahtevZaTrazenjePsa.getPol());
	}
	@Test
	void testSetPolNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->zahtevZaTrazenjePsa.setPol(null));
	}

	@Test
	void testSetBoja() {
		zahtevZaTrazenjePsa.setBoja("bela");
		assertEquals("bela", zahtevZaTrazenjePsa.getBoja());
	}

	@Test
	void testSetVremeNestanka() {
		Date datum=new Date();
		zahtevZaTrazenjePsa.setVremeNestanka(datum);
		assertEquals(datum, zahtevZaTrazenjePsa.getVremeNestanka());
	}
	@Test
	void testSetVremePronalaskaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->zahtevZaTrazenjePsa.setVremeNestanka(null));
	}

	@Test
	void testSetKontaktVlasnika() {
		zahtevZaTrazenjePsa.setKontaktVlasnika("kontakt");
		assertEquals("kontakt", zahtevZaTrazenjePsa.getKontaktVlasnika());
	}
	@Test
	void testSetKontaktNalazacaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->zahtevZaTrazenjePsa.setKontaktVlasnika(null));
	}
	@Test
	void testSetSlikaURL() {
		ImageIcon slika=new ImageIcon();
		zahtevZaTrazenjePsa.setSlikaURL(slika);
		assertEquals(slika, zahtevZaTrazenjePsa.getSlikaURL());
	}

	@Test
	void testSetStarost() {
		zahtevZaTrazenjePsa.setStarost(10);
		assertEquals(10, zahtevZaTrazenjePsa.getStarost());
	}

	@Test
	void testSetIme() {
		zahtevZaTrazenjePsa.setIme("ime");
		assertEquals("ime", zahtevZaTrazenjePsa.getIme());
	}

	@Test
	void testSetRasa() {
		Rasa r = new Rasa(1,"rasa","/");
		zahtevZaTrazenjePsa.setRasa(r);
		assertEquals(r, zahtevZaTrazenjePsa.getRasa());
	}
	@Test
	void testSetRasaaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->zahtevZaTrazenjePsa.setRasa(null));
	}

	@Test
	void testSetLokacija() {
		Lokacija l = new Lokacija(1,"lokacija");
		zahtevZaTrazenjePsa.setLokacija(l);
		assertEquals(l, zahtevZaTrazenjePsa.getLokacija());
	}
	@Test
	void testSetLokacijaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->zahtevZaTrazenjePsa.setLokacija(null));
	}
	@Test
	void testSetX() {
		zahtevZaTrazenjePsa.setX(1.0);
		assertEquals(1.0, zahtevZaTrazenjePsa.getX());
	}
	@Test
	void testSetY() {
		zahtevZaTrazenjePsa.setY(1.0);
		assertEquals(1.0, zahtevZaTrazenjePsa.getY());
	}

	@Test
	void testSetOpis() {
		zahtevZaTrazenjePsa.setOpis("opis");
		assertEquals("opis", zahtevZaTrazenjePsa.getOpis());
	}

	@Test
	void testSetSacuvaoZahtev() {
		Korisnik k = new Korisnik(123, "Tamara", "Tosic", "123456","tamara@test.com","lozinka");
		zahtevZaTrazenjePsa.setSacuvaoZahtev(k);
		assertEquals(k, zahtevZaTrazenjePsa.getSacuvaoZahtev());
	}

}
