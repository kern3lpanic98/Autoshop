package test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;
import control.manage.ProductModelCarrello;
import model.Carrello;
import model.Client;
import model.ConnectionDB;
import model.RicambiAuto;
import java.sql.Connection;

public class ProductModelCarrelloTest {
	
	private Connection connection = null;
	
//per testare un metodo di una classe devo andare a simulare il comportamento del software nel momento in cui andiamo a richiamare quel determinato metodo.
//per la doSave mi creo un Carrello e vado a settare sia l'id_Ricambio che UserClient (tabelle presenti nella tabella carrello), successivamente
//mi instanzio un oggetto di tipo ProducModelCarrello per passare il carrello alla doSave e inserire 10 e paperino. seleziono id_client da carrello dove l'id è paperino per verificare se quello che ho inserito esiste realmente
//infine con l'asserequals verifico che quello che ho inserito prima corrisponde con il risultato dell'inserimento stesso. try/catch per verificare che ci sta quello che ho inserito in precedenza
@Test
public void doSaveTest() throws SQLException {
	
	int id=0;
	Carrello c=new Carrello();
	c.setId_ricambio(10);
	c.setUserClient("paperino");
	ProductModelCarrello f=new ProductModelCarrello();
	f.doSave(c);
	String selectSQL = "SELECT id_ricambio from Carrello where userClient='paperino'";

	try {
		
		connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();

		ResultSet rs = stmt.executeQuery(selectSQL);
		if (rs.next()) {
			 id = rs.getInt("id_ricambio");
	} }catch (SQLException e) {
		System.out.println(e);
	}
	
	assertEquals(id,10);
}


@Test
public void doRetrieveByUserClientTest() throws SQLException {
	/*
    Client r=new Client();
	String userClient="paolo@hotmail.it";
	r.setUsername(userClient);
	ProductModelCarrello f=new ProductModelCarrello();
    f.doRetrieveByUserClient(userClient);
    */
	String userClient="pippo";
	ArrayList<Carrello> id_ricambi = new ArrayList<Carrello>(50);
	Carrello c=new Carrello();
	c.addRicambi(6, userClient, 1, 122.2);
	id_ricambi.add(c);
	ProductModelCarrello f=new ProductModelCarrello();
	//mi preparo quello che mi aspetto di ricevere
	ArrayList<Carrello> id_ricambi_ritorno=f.doRetrieveByUserClient(userClient);
	//prendo l'output della funzione e la metto in id_ricambi_ritorno
	for (int i=0;i<id_ricambi_ritorno.size();i++) {
		
		assertEquals(id_ricambi_ritorno.get(i).getUserClient(),id_ricambi.get(i).getUserClient());
	}
	//verifico se sono uguali tramite l'userClient perchè assertEquals vuole u n tipo di dato base(String, int, ecc...)
	
	
}


@Test
public void doRetrieveByQntTest() throws SQLException 
{


	String userClient="pippo";
	int id_ricambio=6;
	ProductModelCarrello f=new ProductModelCarrello();
	int qnt = f.doRetrieveByQnt(userClient,id_ricambio);
	assertEquals(1,qnt);
				
}

//creo una nuova query con user SARA, faccio la connessione, la eseguo, elimino tutte le righr che contengono l'user SAR tramite svuota carrello e verifico tramite assertFalse ceh è stata eliminata perchè 
//resultSet.next mi restituisce un booleano che in quseto caso, siccome il resultSet è vuoto sarà false
@Test
public void svuotaCarrelloTest() throws SQLException
{
	
	String userClient="SARA";
	ProductModelCarrello p=new ProductModelCarrello();
	
	
	String inserimento = "INSERT INTO CARRELLO VALUES('SARA',10,2,200.0)";
	String query = "SELECT * FROM CARRELLO WHERE userClient='"+userClient+"'";	
	
	try {
		connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(inserimento);
		p.svuotaCarrello(userClient);
		ResultSet rs = stmt.executeQuery(query);
	    
	    assertFalse(rs.next()); 
		
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	
	
	
}


@Test
public void removeArticleByIdTest() throws SQLException 
{
	String userClient="CAMILLA";
	int id_ricambio = 12;
	ProductModelCarrello p=new ProductModelCarrello();
	
	String inserimento = "INSERT INTO CARRELLO VALUES('CAMILLA',12,5,207.0)";
	String query = "SELECT * FROM CARRELLO WHERE id_ricambio='"+id_ricambio+"'"+" AND USERCLIENT='" + userClient + "'";	
	
	try {
		connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(inserimento);
		p.removeArticleById(id_ricambio,userClient);
		ResultSet rs = stmt.executeQuery(query);
	    
	    assertFalse(rs.next()); 
		
	} catch (SQLException e) {
		System.out.println(e);
	}

	
}
	
	

	
	

}
