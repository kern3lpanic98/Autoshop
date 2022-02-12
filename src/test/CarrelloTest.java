package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Carrello;
import model.Client;

public class CarrelloTest {


	@Test
	public void testSetUserClient() {
	String userClient = "paolo@hotmail.it";

		Carrello c=new Carrello();
		c.setUserClient(userClient);
		assertEquals(c.getUserClient(),userClient);
	}

	@Test
	public void testSetPrezzo() {
		double prezzo = 24.00;
		Carrello c=new Carrello();
		c.setPrezzo(prezzo);
		assertEquals(c.getPrezzo(), prezzo, 2.0);
	}

	@Test
	public void testCarrello() {
		ArrayList<Integer>id_ricambi = new ArrayList<Integer>(50);
		
		
		
		Carrello c=new Carrello();
		
		assertEquals(c.getRicambi(),id_ricambi);
		assertEquals(c.getPrezzo(), 0, 2.0);
		assertEquals(c.getQuantità(),0);
		assertEquals(c.getId_ricambio(),0);
		
	}



	@Test
	public void testAddRicambi() {
		ArrayList<Integer>id_ricambi = new ArrayList<Integer>(50);
		double prezzo = 100.00;
		int quantità= 0;
		int id_ricambio = 0;
		String userClient="paolo@hotmail.it";
		Carrello c = new Carrello();
		c.addRicambi(id_ricambio, userClient,quantità, prezzo);
		
	
		assertEquals(c.getPrezzo(), prezzo, 2.0);
		assertEquals(c.getQuantità(),quantità);
		assertEquals(c.getId_ricambio(),id_ricambio);
		assertEquals(c.getUserClient(),userClient);
		
	}

	@Test
	public void testSetId_ricambio() {
		int id =4;
		Carrello c=new Carrello();
		c.setId_ricambio(id);
		assertEquals(c.getId_ricambio(),id);
	}


	@Test
	public void testSetQuantità() {
		int quantità= 6;
		Carrello c=new Carrello();
		c.setQuantità(quantità);
		assertEquals(c.getQuantità(),quantità);
	}




}
