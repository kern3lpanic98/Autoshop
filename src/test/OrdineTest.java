package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Ordine;
import model.Preventivo;

public class OrdineTest {

	@Test
	public void testSetUserClient() {
		String userClient = "paolo@hotmail.it";
		Ordine o = new Ordine();
		o.setUserClient(userClient);
		assertEquals(o.getUserClient(), userClient);
	}

	@Test
	public void testSetId_ricambio() {

		int id = 12;
		Ordine o = new Ordine();
		o.setId_ricambio(id);
		assertEquals(o.getId_ricambio(), id);
	}

	@Test
	public void testSetTotale() {
		double totale = 12.12;
		Ordine o = new Ordine();
		o.setTotale(totale);
		assertEquals(o.getTotale(), totale, 2.0);
	}

	@Test
	public void testSetVia() {
		String via = "viaeccomi";
		Ordine o = new Ordine();
		o.setVia(via);
		assertEquals(o.getVia(), via);
	}

	@Test
	public void testSetCivico() {

		String civico = "1";
		Ordine o = new Ordine();
		o.setCivico(civico);
		assertEquals(o.getCivico(), civico);
	}

	@Test
	public void testSetCap() {

		String cap = "84014";
		Ordine o = new Ordine();
		o.setCap(cap);
		assertEquals(o.getCap(), cap);
	}

	@Test
	public void testOrdineStringIntDoubleStringStringString() {
		String userClient="paolo@hotmail.it";
		int id_ricambio=11;
		double totale=123.53; 
		String via="alveolol";
		String civico="1";
		String cap="84014";
	
		
		Ordine o = new Ordine(userClient,id_ricambio,totale,via,civico,cap);
		
		assertEquals(o.getUserClient(),userClient);
		assertEquals(o.getId_ricambio(),id_ricambio);
		assertEquals(o.getVia(),via);
		assertEquals(o.getCap(),cap);
		assertEquals(o.getCivico(),civico);
		assertEquals(o.getTotale(), totale, 2.0);
	}

}
