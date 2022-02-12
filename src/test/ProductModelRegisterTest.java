package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;
import control.manage.ProductModelCarrello;
import control.manage.ProductModelRegister;
import model.Carrello;
import model.Client;
import model.ConnectionDB;
import model.RicambiAuto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

public class ProductModelRegisterTest 
{
		@Test
		public void doSave () throws SQLException 
		{
			String uname_ = "";
			Client c = new Client() ;
			c.setNome("prova");
			c.setCognome("prova");
			c.setUsername("prova@hotmail.it");
			c.setPassword("prova");
			c.setData_reg("2021-11-12");
			c.setVia("prova");
			c.setCivico("prova");
			c.setCap("84014");
			ProductModelRegister p = new ProductModelRegister();
			//mi preparo quello che mi aspetto di ricevere
			p.doSave(c);
			//lo ricevo, inserendolo
			String selectSQL = "SELECT uname from Members where uname = 'prova@hotmail.it' ";
			//seleziono l'uname in qusetione
			try {
				
				Connection connection = ConnectionDB.getIstance().getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(selectSQL);
				if (rs.next()) {
					  uname_ = rs.getString("uname");
			} }catch (SQLException e) {
				System.out.println(e);
			}
			
			assertEquals(uname_,"prova@hotmail.it");
		}
		
		@Test
		public void doRetriveByUser() throws SQLException 
		{
			String uname = "sara@hotmail.it";
			//mi preparo quello che mi aspetto di ricevere, sara@hotmail.it già esiste, poiche la retrive restituisce una riga già presente
			
			ProductModelRegister p = new ProductModelRegister();
			boolean ritorno = p.doRetriveByUser(uname);
			//lo ricevo
			
			assertTrue(ritorno);
			
			//verifico se sia vero
		} 
		
		@Test
		public void getIndirizzo () throws SQLException 
		{
			String user = "sara@hotmail.it";
			
			ArrayList<String> indirizzo = new ArrayList<String>(50);
			indirizzo.add("Via eccomi");
			indirizzo.add("2");
			indirizzo.add("84014");
			
			ProductModelRegister p = new ProductModelRegister();
			ArrayList<String> indirizzo_ritorno = p.getIndirizzo(user);
			
			for (int i=0; i<indirizzo_ritorno.size();i++) 
			{

				assertEquals(indirizzo_ritorno.get(i), indirizzo.get(i));
		
			}
}
}

