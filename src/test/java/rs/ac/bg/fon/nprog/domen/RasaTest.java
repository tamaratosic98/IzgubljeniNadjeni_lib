package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RasaTest extends IOpstiDomenskiObjekatTest {
	public Rasa rasa;
	@BeforeEach
	void setUp() throws Exception {
		opstiDomenskiObjekat = new Rasa(1,"Skotski terijer","/");
		rasa= new Rasa();
	}

	@AfterEach
	void tearDown() throws Exception {
		rasa=null;
		opstiDomenskiObjekat=null;
	}

	@Test
	void testRasa() {
		rasa= new Rasa();
		assertNotNull(rasa);
	}

	@Test
	void testRasaLongStringString() {
		rasa= new Rasa(1,"Skotski terijer","/");
		assertNotNull(rasa);
	}

	@Test
	void testSetRasaId() {
		rasa.setRasaId(1);
		assertEquals(1,rasa.getRasaId());
	}

	@Test
	void testSetNaziv() {
		rasa.setNaziv("Skotski terijer");
		assertEquals("Skotski terijer",rasa.getNaziv());
	}
	@Test
	void testSetNazivNijeKratak() {
		assertThrows(java.lang.RuntimeException.class, ()->rasa.setNaziv("T"));
	}

}
