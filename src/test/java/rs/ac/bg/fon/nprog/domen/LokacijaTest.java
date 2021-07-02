package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LokacijaTest extends IOpstiDomenskiObjekatTest{
	public Lokacija lokacija;
	@BeforeEach
	void setUp() throws Exception {
		opstiDomenskiObjekat=new Lokacija(1,"Beograd");
		lokacija=new Lokacija();
	}

	@AfterEach
	void tearDown() throws Exception {
		opstiDomenskiObjekat=null;
		lokacija=null;
	}

	@Test
	void testLokacija() {
		lokacija=new Lokacija();
		assertNotNull(lokacija);
	}

	@Test
	void testLokacijaLongString() {
		lokacija=new Lokacija(1,"Beograd");
		assertNotNull(lokacija);
	}

	@Test
	void testSetLokacijaId() {
		lokacija.setLokacijaId(1);
		assertEquals(1,lokacija.getLokacijaId());
	}

	@Test
	void testSetNaziv() {
		lokacija.setNaziv("Beograd");
		assertEquals("Beograd",lokacija.getNaziv());
	}
	@Test
	void testSetNazivNijeKratak() {
		assertThrows(java.lang.RuntimeException.class, ()->lokacija.setNaziv("T"));
	}

}
