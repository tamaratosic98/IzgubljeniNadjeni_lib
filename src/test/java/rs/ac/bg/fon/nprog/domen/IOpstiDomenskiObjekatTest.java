package rs.ac.bg.fon.nprog.domen;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public abstract class IOpstiDomenskiObjekatTest {
	public IOpstiDomenskiObjekat opstiDomenskiObjekat;

	@Test
	public void testNazivTabele() {
		String naziv = opstiDomenskiObjekat.nazivTabele();
		assertNotNull(naziv);
	}

	@Test
	public void testAlijas() {
		String alijas = opstiDomenskiObjekat.alijas();
		assertNotNull(alijas);
	}

	@Test
	public void testJoin() {
		String join = opstiDomenskiObjekat.join();
		assertNotNull(join);
	}

	@Test
	public void testSelectWhere() {
		String sw = opstiDomenskiObjekat.selectWhere();
		assertNotNull(sw);
	}

	@Test
	public void testUcitajListu() throws Exception {
		ResultSet rs=mock(ResultSet.class);
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
		//proveravamo da li metoda vraca listu na osnovu tog result set-a
		List<IOpstiDomenskiObjekat> lista = opstiDomenskiObjekat.ucitajListu(rs);
		assertNotNull(lista);
	}

	@Test
	public void testKoloneInsert() {
		String insert = opstiDomenskiObjekat.koloneInsert();
		assertNotNull(insert);
	}

	@Test
	public void testVrednostPrimarniKljuc() {
		String kljuc = opstiDomenskiObjekat.vrednostPrimarniKljuc();
		assertNotNull(kljuc);
	}

	@Test
	public void testVrednostiInsert() {
		String insert = opstiDomenskiObjekat.vrednostiInsert();
		assertNotNull(insert);
	}

	@Test
	public void testVrednostiUpdate() {
		String update = opstiDomenskiObjekat.vrednostiUpdate();
		assertNotNull(update);
	}

	@Test
	public void testVratiMax() {
		String max = opstiDomenskiObjekat.vratiMax();
		assertNotNull(max);
	}

}
