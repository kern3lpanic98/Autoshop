package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;
import control.manage.ProductModelCarrello;
import control.manage.ProductModelPreventivo;
import control.manage.ProductModelRegister;
import model.Carrello;
import model.Client;
import model.ConnectionDB;
import model.Preventivo;
import model.RicambiAuto;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

public class ProductModelPreventivoTest {
	

	@Test
        public void doSaveTest() throws SQLException 
	{
		int id=0;
		Preventivo p= new Preventivo();
		p.setId_auto(1);
		p.setUserClient("paolo@hotmail.it");
		p.setData("2021-11-15");
		ProductModelPreventivo f= new ProductModelPreventivo();
		//mi preparo ciò che mi aspetto di ricevere
		f.doSave(p);
		//lo ricevo, ovvero eseguo la doSave
		String selectSQL = "SELECT id_auto from preventivo where userClient='paolo@hotmail.it'";
		//seleziono id_auto da preventivo dove l'userClient corrisponde a paolo@hotmail.it
		try {
			Connection connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(selectSQL);
			  if (rs.next()) {
				id=rs.getInt("id_auto"); //in id metto il valore contenuto in id_auto
			}}catch(SQLException e) {
					System.out.println(e);
			}
		assertEquals(id,1); //verifico se esattamente siano uguali
	}

}
