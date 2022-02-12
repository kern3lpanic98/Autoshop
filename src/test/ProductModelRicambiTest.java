package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;
import control.manage.ProductModelCarrello;
import control.manage.ProductModelRicambi;
import model.Carrello;
import model.Client;
import model.ConnectionDB;
import model.RicambiAuto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

public class ProductModelRicambiTest 
{
	@Test
	public void doRetriveAll() throws SQLException 
	{
		ArrayList<RicambiAuto> n = new ArrayList<RicambiAuto>();
		RicambiAuto r = new RicambiAuto();
		r.setId(1);
		r.setPrezzo(39.99);
		r.setPath("Immagini/Ricambi/Bosh-Filtro olio.jpg");
		r.setTipo("Filtro olio");
		r.setMarca("Bosh");
		r.setQuantità(448);
		n.add(r);
		ProductModelRicambi p = new ProductModelRicambi();
		//mi preparo quello che mi aspettodi ricevere(gia presente nella tabella, perche appunto deve verificare la restituzione)
		
		ArrayList<RicambiAuto> n_ritorno = p.doRetrieveAll();
		//prendo l'output della funzione e lo metto in n_ritorno
		
		for (int i=0;i<n_ritorno.size();i++) {
			
			assertEquals(n_ritorno.get(i).getId(),n.get(i).getId());
		}	
		 //verifico tramite l'id  se sono uguali
	}
	
	@Test
	public void removeRicambio() throws SQLException 
	{
		int id_ricambio = 2;
		ProductModelRicambi p=new ProductModelRicambi();
		
		String inserimento = "INSERT INTO ricambi VALUES(2,40.00,'Immagini/Ricambi/Bosh-Filtro olio.jpg','manubrio','bosh',500)";
		String query = "SELECT * FROM ricambi WHERE id="+id_ricambio;
		//creo una nuove riga nella tabella Dipendenti e seleziono ogni riga che abbia come id_ricambio = 2
		try {
			Connection connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(inserimento);
			p.removeRicambi(id_ricambio);
			ResultSet rs = stmt.executeQuery(query);
			//creo la connessione al db ed eseguo l'inserimento, rimuovo la corrispondente riga (id_ricambio), quindi eseguo il metodo remove
		    assertFalse(rs.next()); 
		    //verifico che la riga non esista mediante l'assertFalse e che di conseguenza la remove sia stata eseguita correttamente
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	@Test
	public void addRicambio() throws SQLException 
	{
		int id_ricambio = 3;
		RicambiAuto r = new RicambiAuto();
		r.setId(id_ricambio);
		r.setPrezzo(50.00);
		r.setPath("Immagini/Ricambi/Bosh-Filtro olio.jpg");
		r.setTipo("ruota");
		r.setMarca("bosh");
		r.setPrezzo(580);
		
		ProductModelRicambi p=new ProductModelRicambi();
		
		boolean ritorno = p.addRicambio(r);
			
			
		assertTrue(ritorno);
		
	}
}
