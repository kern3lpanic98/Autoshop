package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Dipendente;
import model.Preventivo;

public class PreventivoTest {

	@Test
	public void testSetId_auto() {
		int id=0;
		Preventivo p = new Preventivo();
		p.setId_auto(id);
		assertEquals(p.getId_auto(),id);
	}

	@Test
	public void testSetUserClient() {
		String userClient = "paolo@hotmail.it";
		Preventivo p = new Preventivo();
		p.setUserClient(userClient);
		assertEquals(p.getUserClient(),userClient);
	}

	@Test
	public void testSetData() {
		String data = "2022-01-01";
		Preventivo p = new Preventivo();
		p.setData(data);
		assertEquals(p.getData(),data);
	}

	@Test
	public void testPreventivoIntStringString() {
		String data = "2022-01-01";
		int id_auto=0;
		String userClient="alfredo@hotmail.it";
		Preventivo p = new Preventivo(id_auto,userClient,data);
		
		assertEquals(p.getData(),data);
		assertEquals(p.getUserClient(),userClient);
		assertEquals(p.getId_auto(),id_auto);
	}

}
