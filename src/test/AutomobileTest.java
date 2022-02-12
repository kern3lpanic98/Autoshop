package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Automobile;
import model.Client;

public class AutomobileTest {

	@Test
	public void testSetId() {
		int id=1;
		Automobile a=new Automobile();
		a.setId(id);
		assertEquals(a.getId(),id);
	}



	@Test
	public void testSetMarca() {
		String marca="mercedes";
		Automobile a=new Automobile();
		a.setMarca(marca);
		assertEquals(a.getMarca(),marca);
	}
	
	@Test
	public void testAuto() {
		String marca="mercedes",modello="benz",path="Immagini/Mercedes";
		int posti=5;
		int prezzo=222;
		int anno = 2018;
		int id=1;
		
		Automobile a=new Automobile(id, marca, modello, prezzo,path);
		
		assertEquals(a.getMarca(),marca);
		assertEquals(a.getModello(),modello);
		assertEquals(a.getId(),id);
		assertEquals(a.getPrezzo(), prezzo, 2);
		assertEquals(a.getPath(),path);
		
	}

	



	@Test
	public void testSetModello() {
		String modello="prova";
		Automobile a=new Automobile();
		a.setModello(modello);
		assertEquals(a.getModello(),modello);
	}




	@Test
	public void testSetPrezzo() {
		double prezzo= 222;
		Automobile a=new Automobile();
		a.setPrezzo(prezzo);
		assertEquals(a.getPrezzo(), prezzo, 2);
	}



	@Test
	public void testSetPath() {
		String path="immagini/mercedes";
		Automobile a = new Automobile();
		a.setPath(path);
		assertEquals(a.getPath(),path);
	}

}
