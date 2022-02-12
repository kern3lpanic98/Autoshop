package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;
import control.manage.ProductModelCarrello;
import control.manage.ProductModelDip;
import model.Carrello;
import model.Client;
import model.ConnectionDB;
import model.Dipendente;
import model.RicambiAuto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductModelDipTest 
{
	@Test
	public void doSaveTest() throws SQLException 
	{
		String uname = "";
		Dipendente d = new Dipendente ();
		d.setNome("Onelia");
		d.setUsername("dip_prova@hotmail.it");
		d.setCognome("Cataldo");
		d.setPassword("passdip2");
		ProductModelDip p = new ProductModelDip();
		p.doSave(d);
		
		//String selectSQL = "SELECT * from Dipendenti";
		String selectSQL = "SELECT uname from Dipendenti where uname='dip_prova@hotmail.it'";
		
		try {
			
			Connection connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(selectSQL);
			if (rs.next()) {
				  uname = rs.getString("uname");
		} }catch (SQLException e) {
			System.out.println(e);
		}
		
		assertEquals(uname,"dip_prova@hotmail.it");
		
		
	}
		
	

     @Test
     public void doRetrieveAllTest() throws SQLException 
     {
    	 ArrayList<Dipendente> n = new ArrayList<Dipendente>();
    	 Dipendente d = new Dipendente();
    	 d.setNome("Mario");
    	 d.setCognome("Rossi");
    	 d.setUsername("dip@hotmail.it");
    	 d.setPassword("passdip1");
    	 n.add(d);
    	 ProductModelDip p = new ProductModelDip();
    	 //mi preparo quello che mi aspettodi ricevere, che ho nella tabella dip(gia presente)
    	 
    	 ArrayList<Dipendente> n_ritorno = p.doRetrieveAll();
 		 //prendo l'output della funzione e lo metto in n_ritorno
 		 
 		 for (int i=0;i<n_ritorno.size();i++) 
 		 {
 			assertEquals(n_ritorno.get(i).getUsername(),n.get(i).getUsername());
 		 }
 		 //verifico tramite l'userName se sono uguali

     }
  

    @Test
    public void doRetriveByUser() throws SQLException 
    {
 
    	Connection connection;
    	String uname = "dip_prova1@hotmail.it";
    	String inserimento = "INSERT INTO DIPENDENTI VALUES('dip_prova1@hotmail.it','passdip3','Sara','Cataldo')";
    	ProductModelDip p = new ProductModelDip();
    	// mi preparo quello che mi aspetto di ricevere, andando ad inserire un new dipendente
    	try {
    		connection = ConnectionDB.getIstance().getConnection();
    		Statement stmt = connection.createStatement();
    		stmt.executeUpdate(inserimento);
    		boolean ritorno = p.doRetriveByUser(uname);
    		//poiche doRetriveByUser restituisce un booleano, mi richiamo la funzione e la metto in una variabile di tipo bool
    		assertTrue(ritorno);
    		//verifico che sia vero, ovvero se l'inserimento è andato a buon fine (che mi ha restituito quel user)
    	} catch (SQLException e) {
    		System.out.println(e);
    	}
    	
    }
    

    @Test
    public void remove () 
    {
    	
    	String uname = "ciao@hotmail.it";
    	ProductModelDip p = new ProductModelDip();
    	
    	String inserimento = "INSERT INTO Dipendenti VALUES('ciao@hotmail.it','passdip2','Sara','Cataldo')";
    	String query = "SELECT * FROM Dipendenti WHERE uname='"+uname+"'";
    	//creo una nuove riga nella tabella Dipendenti e seleziono ogni riga che abbia come uname = ciao@hotmail.it
    	try {
    		Connection connection = ConnectionDB.getIstance().getConnection();
    		Statement stmt = connection.createStatement();
    		stmt.executeUpdate(inserimento);
			p.remove(uname);
    		ResultSet rs = stmt.executeQuery(query);
    	    //creo la connessione al db ed eseguo l'inserimento, rimuovo la corrispondente riga (uname), quindi eseguo il metodo remove
    	    assertFalse(rs.next()); 
    		//verifico che la riga non esista mediante l'assertFalse e che di conseguenza la remove sia stata eseguita correttamente
    	} catch (SQLException e) {
    		System.out.println(e);
    	}
    		
    }
    
}