package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrijavaPronalaskaPsaTest extends IOpstiDomenskiObjekatTest {
	public PrijavaPronalaskaPsa prijavaPronalaskaPsa;
	@BeforeEach
	void setUp() throws Exception {
		opstiDomenskiObjekat = new PrijavaPronalaskaPsa();
		prijavaPronalaskaPsa= new PrijavaPronalaskaPsa();
	}

	@AfterEach
	void tearDown() throws Exception {
		prijavaPronalaskaPsa=null;
		opstiDomenskiObjekat=null;
	}

	@Test
	void testPrijavaPronalaskaPsa() {
		prijavaPronalaskaPsa= new PrijavaPronalaskaPsa();
		assertNotNull(prijavaPronalaskaPsa);
	}

	@Test
	void testPrijavaPronalaskaPsaLongEnumPolStringDateStringImageIconRasaLokacijaDoubleDoubleStringKorisnik() {
		Rasa r = new Rasa(1,"rasa","/");
		Lokacija l = new Lokacija(1,"lokacija");
		Korisnik k = new Korisnik(123, "Tamara", "Tosic", "123456","tamara@test.com","lozinka");
		prijavaPronalaskaPsa= new PrijavaPronalaskaPsa(1,EnumPol.MUŠKI,"",new Date(),"bela",new ImageIcon(),r, l, 1.0,1.0,"opis",k);
		assertNotNull(prijavaPronalaskaPsa);
	}

	@Test
	void testSetPrijavaPronalaskaPsaId() {
		prijavaPronalaskaPsa.setPrijavaPronalaskaPsaId(1);
		assertEquals(1, prijavaPronalaskaPsa.getPrijavaPronalaskaPsaId());
	}

	@Test
	void testSetPol() {
		prijavaPronalaskaPsa.setPol(EnumPol.MUŠKI);
		assertEquals(EnumPol.MUŠKI, prijavaPronalaskaPsa.getPol());
	}
	@Test
	void testSetPolNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->prijavaPronalaskaPsa.setPol(null));
	}

	@Test
	void testSetBoja() {
		prijavaPronalaskaPsa.setBoja("bela");
		assertEquals("bela", prijavaPronalaskaPsa.getBoja());
	}

	@Test
	void testSetVremePronalaska() {
		Date datum=new Date();
		prijavaPronalaskaPsa.setVremePronalaska(datum);
		assertEquals(datum, prijavaPronalaskaPsa.getVremePronalaska());
	}
	@Test
	void testSetVremePronalaskaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->prijavaPronalaskaPsa.setVremePronalaska(null));
	}
	@Test
	void testSetKontaktNalazaca() {
		prijavaPronalaskaPsa.setKontaktNalazaca("kontakt");
		assertEquals("kontakt", prijavaPronalaskaPsa.getKontaktNalazaca());
	}
	@Test
	void testSetKontaktNalazacaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->prijavaPronalaskaPsa.setKontaktNalazaca(null));
	}

	@Test
	void testSetSlikaURL() {
		ImageIcon slika=new ImageIcon();
		prijavaPronalaskaPsa.setSlikaURL(slika);
		assertEquals(slika, prijavaPronalaskaPsa.getSlikaURL());
	}

	@Test
	void testSetRasa() {
		Rasa r = new Rasa(1,"rasa","/");
		prijavaPronalaskaPsa.setRasa(r);
		assertEquals(r, prijavaPronalaskaPsa.getRasa());
	}
	@Test
	void testSetRasaaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->prijavaPronalaskaPsa.setRasa(null));
	}
	@Test
	void testSetLokacija() {
		Lokacija l = new Lokacija(1,"lokacija");
		prijavaPronalaskaPsa.setLokacija(l);
		assertEquals(l, prijavaPronalaskaPsa.getLokacija());
	}
	@Test
	void testSetLokacijaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->prijavaPronalaskaPsa.setLokacija(null));
	}

	@Test
	void testSetX() {
		prijavaPronalaskaPsa.setX(1.0);
		assertEquals(1.0, prijavaPronalaskaPsa.getX());
	}

	@Test
	void testSetY() {
		prijavaPronalaskaPsa.setY(1.0);
		assertEquals(1.0, prijavaPronalaskaPsa.getY());
	}

	@Test
	void testSetOpis() {
		prijavaPronalaskaPsa.setOpis("opis");
		assertEquals("opis", prijavaPronalaskaPsa.getOpis());
	}

	@Test
	void testSetSacuvaoPronalazak() {
		Korisnik k = new Korisnik(123, "Tamara", "Tosic", "123456","tamara@test.com","lozinka");
		prijavaPronalaskaPsa.setSacuvaoPronalazak(k);
		assertEquals(k, prijavaPronalaskaPsa.getSacuvaoPronalazak());
	}

}
