package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Client;
import model.RicambiAuto;

public class RicambiAutoTest {



	@Test
	public void testSetQuantità() {
	
		int quantità=0;
		RicambiAuto r = new RicambiAuto();
		r.setQuantità(quantità);
		assertEquals(r.getQuantità(),quantità);
	}


	@Test
	public void testSetMarca() {
	    String marca = "mercedes";
		RicambiAuto r = new RicambiAuto();
		r.setMarca(marca);
		assertEquals(r.getMarca(),marca);
	}


	@Test
	public void testSetTipo() {
		    String tipo = "freno_disco";
			RicambiAuto r = new RicambiAuto();
			r.setTipo(tipo);
			assertEquals(r.getTipo(),tipo);
	}



	@Test
	public void testSetPrezzo() {
		 double prezzo = 20.00;
			RicambiAuto r = new RicambiAuto();
			r.setPrezzo(prezzo);
			assertEquals(r.getPrezzo(), prezzo, 2.00);
	}

	@Test
	public void testRicambiAutoIntStringDoubleStringStringInt() {
		int id=0;
		String marca="mercedes"; 
		double prezzo=21.00;
		String path="Immagini/Ricambi";
		String tipo="filtro olio";
		int qnt = 20;
	RicambiAuto r = new RicambiAuto(id,marca,prezzo,path,tipo,qnt);
	    assertEquals(r.getId(),id);
		assertEquals(r.getMarca(),marca);
		assertEquals(r.getTipo(),tipo);
		assertEquals(r.getPath(),path);
		assertEquals(r.getQuantità(),qnt);
		
		assertEquals(r.getPrezzo(), prezzo, 2.0);
		
	}

	@Test
	public void testRicambiAutoIntStringDoubleStringString() {
		int id=0;
		String marca="mercedes"; 
		double prezzo=21.00;
		String path="Immagini/Ricambi";
		String tipo="filtro olio";
		
	RicambiAuto r = new RicambiAuto(id,marca,prezzo,path,tipo );
	    assertEquals(r.getId(),id);
		assertEquals(r.getMarca(),marca);
		assertEquals(r.getTipo(),tipo);
		assertEquals(r.getPath(),path);
		
		assertEquals(r.getPrezzo(), prezzo, 2.0);
	}

	@Test
	public void testRicambiAutoStringDoubleStringStringInt() {
		String marca="mercedes",tipo="freni a disco",path="Immagini/Ricambi";
		double prezzo=20.00;
		int qnt = 10;
		
	RicambiAuto r = new RicambiAuto(marca,prezzo,path,tipo,qnt);
		
		assertEquals(r.getMarca(),marca);
		assertEquals(r.getTipo(),tipo);
		assertEquals(r.getPath(),path);
		assertEquals(r.getQuantità(),qnt);
		assertEquals(r.getPrezzo(), prezzo, 2.0);
		
	}




	@Test
	public void testSetPath() {
		 String path = "Immagini/Ricambi";
			RicambiAuto r = new RicambiAuto();
			r.setPath(path);
			assertEquals(r.getPath(),path);
	}


	@Test
	public void testSetId() {
		 int id = 10;
			RicambiAuto r = new RicambiAuto();
			r.setId(id);
			assertEquals(r.getId(), id);
	}

}
