package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;
import control.manage.ProductModelCarrello;
import control.manage.ProductModelDM;
import model.Automobile;
import model.Carrello;
import model.Client;
import model.ConnectionDB;
import model.RicambiAuto;

public class ProductModelIDMtest 
{
	@Test
	public void doRetriveByKey() throws SQLException 
	{
		int id = 1;
		Automobile a = new Automobile ();
		a.setId(id);
		a.setMarca("Audi");
		a.setModello("A1");
		a.setPath("Immagini/Auto Nuove/Audi/A1.jpg");
		a.setPrezzo(0);
		ProductModelDM pr = new ProductModelDM();
		//mi preparo quello che mi aspetto di ricevere
		
		Automobile b = pr.doRetrieveByKey(id);
		//mi richiamo la funzione passandogli l'id, lo ricevo in b
		
		//fare marca, modello, path e prezzo
		assertEquals(id, b.getId());
		
		//tramite l'equals verifivo che quello che mi aspetto di ricevere è asattamente quello passato dalla funzione
	}
	
}