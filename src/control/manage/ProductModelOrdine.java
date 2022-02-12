package control.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.interfaccia.modelOrdine;
import control.interfaccia.modelRegister;
import model.Carrello;
import model.ConnectionDB;
import model.RicambiAuto;

public class ProductModelOrdine implements modelOrdine {
	
	private Connection connection=null;
	private modelRegister modelClient = null;
	private static final String TABLE_NAME = "ordine";
	
	@Override
	public boolean doSave(ArrayList<Carrello> c ,ArrayList<Integer> id_r,
			ArrayList<Integer> qnt ) throws SQLException {
		
		ArrayList<String> indirizzi=null;
		double totale;
		int num_pezzi;
		String selectSQL=null;
	    String user = null;
	    int id_ricambio;
	    String via= null;
	    String cap=null;
	    String civico = null;

	   modelClient = new ProductModelRegister();
       indirizzi = modelClient.getIndirizzo(c.get(0).getUserClient());
      
       
     connection = ConnectionDB.getIstance().getConnection();
     Statement stmt = connection.createStatement();
       
       user = c.get(0).getUserClient();
       via= indirizzi.get(0);
       civico = indirizzi.get(1);
       cap = indirizzi.get(2);
       
       
    	   
       
		for(int i=0; i<c.size();i++) {	
		
			id_ricambio= c.get(i).getId_ricambio();
			
		for(int j=0;j<id_r.size();j++) {
			
			if(id_r.get(j)== id_ricambio) {
				
				num_pezzi=qnt.get(j);
				totale=num_pezzi*c.get(i).getPrezzo();
				
			    selectSQL="INSERT INTO " +ProductModelOrdine.TABLE_NAME+
			 " (USER,ID_RICAMBIO,VIA,CAP,CIVICO,QNT,TOTALE) VALUES('"+user+"',"+id_ricambio+", '"+
			    		via+"','"+cap+"','"+civico+"',"+num_pezzi+","+totale+")";
			    		
			            stmt.executeUpdate(selectSQL); 
			}
		}

		}
    
	 
	
	  return true;
	  
	
	}

}
