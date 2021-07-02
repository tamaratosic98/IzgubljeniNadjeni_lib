package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KorisnikTest extends IOpstiDomenskiObjekatTest {
	public Korisnik k;

	@BeforeEach
	public void setUp() throws Exception {
		opstiDomenskiObjekat = new Korisnik(123, "Tamara", "Tosic", "123456","tamara@test.com","lozinka");
		k=new Korisnik();
	}

	@AfterEach
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
	@Test
	public void testSetEmailNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->k.setEmail(null));
	}
	@Test
	public void testSetEmailNotEmpty() {
		assertThrows(java.lang.RuntimeException.class, ()->k.setEmail(""));
	}
	
	@Test
	public void testSetLozinkaNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->k.setLozinka(null));
	}
	@Test
	public void testSetLozinkaNotEmpty() {
		assertThrows(java.lang.RuntimeException.class, ()->k.setLozinka(""));
	}
	
	@Test
	public void testSetImeNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->k.setIme(null));
	}
	@Test
	public void testSetImeNotEmpty() {
		assertThrows(java.lang.RuntimeException.class, ()->k.setIme(""));
	}
	
	@Test
	public void testSetPrezimeNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->k.setPrezime(null));
	}
	@Test
	public void testSetPrezimeNotEmpty() {
		assertThrows(java.lang.RuntimeException.class, ()->k.setPrezime(""));
	}
	
	@Test
	public void testSetTelefonNotNull() {
		assertThrows(java.lang.NullPointerException.class, ()->k.setTelefon(null));
	}
	@Test
	public void testSetTelefonNotEmpty() {
		assertThrows(java.lang.RuntimeException.class, ()->k.setTelefon(""));
	}

}
