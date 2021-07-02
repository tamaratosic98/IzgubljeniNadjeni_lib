package rs.ac.bg.fon.nprog.domen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KorisnikTest extends IOpstiDomenskiObjekatTest {
	public Korisnik k;

	@Before
	public void setUp() throws Exception {
		opstiDomenskiObjekat = new Korisnik(123, "Tamara", "Tosic", "123456","tamara@test.com","lozinka");
		k=new Korisnik();
	}

	@After
	public void tearDown() throws Exception {
		opstiDomenskiObjekat=null;
		k=null;
	}

	@Test
	public void testKorisnik() {
		k = new Korisnik();
		assertNotNull(k);
	}

	@Test
	public void testKorisnikLongStringStringStringStringString() {
		k = new Korisnik(123, "Tamara", "Tosic", "123456","tamara@test.com","lozinka");

		assertNotNull(k);
		assertEquals(123, k.getKorisnikId());
		assertEquals("Tamara", k.getIme());
		assertEquals("Tosic", k.getPrezime());
		assertEquals("tamara@test.com", k.getEmail());
		assertEquals("123456", k.getTelefon());
		assertEquals("lozinka", k.getLozinka());

	}

	@Test
	public void testSetKorisnikId() {
		k.setKorisnikId(123);
		assertEquals(123, k.getKorisnikId());
	}

	@Test
	public void testSetIme() {
		k.setIme("Tamara");
		assertEquals("Tamara", k.getIme());
	}

	@Test
	public void testSetPrezime() {
		k.setPrezime("Tosic");
		assertEquals("Tosic", k.getPrezime());
	}

	@Test
	public void testSetTelefon() {
		k.setTelefon("123456");
		assertEquals("123456", k.getTelefon());
	}

	@Test
	public void testSetEmail() {
		k.setEmail("tamara@test.com");
		assertEquals("tamara@test.com", k.getEmail());
	}

	@Test
	public void testSetLozinka() {
		k.setLozinka("lozinka");
		assertEquals("lozinka", k.getLozinka());

	}
	

}
