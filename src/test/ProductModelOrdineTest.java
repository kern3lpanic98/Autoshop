package test;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.manage.ProductModelOrdine;
import control.manage.ProductModelRegister;
import model.Carrello;
import model.ConnectionDB;
import model.Ordine;

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
import java.sql.PreparedStatement;

public class ProductModelOrdineTest {
	
	
	
	@Test
	public void doSave() throws SQLException 
	{
		
	    Carrello car=new Carrello();
		ArrayList<Carrello> c=new ArrayList<Carrello>();
		ArrayList<Integer> id_r=new ArrayList<Integer>();
		ArrayList<Integer> qnt=new ArrayList<Integer>();
		
		car.setUserClient("paolo@hotmail.it");
		car.setId_ricambio(1);
		car.setQuantità(1);
		car.setPrezzo(122.2);
		c.add(car);
		id_r.add(1);
		qnt.add(1);
		//mi preparo quello che mi aspetto di ricevere
		
		ProductModelOrdine ord=new ProductModelOrdine();
		ord.doSave(c, id_r, qnt);
		//lo ricevo
		
		for(int i=0; i<c.size();i++) 	
			
			assertEquals(car.getUserClient(),c.get(i).getUserClient());
			
		for(int j=0;j<id_r.size();j++) 
			
			assertEquals(car.getId_ricambio(),id_r.get(j).intValue());
		
		for(int k=0;k<qnt.size();k++)
			
			assertEquals(car.getQuantità(),qnt.get(k).intValue());
		
		}
		
	}



	
	
	
	
	


