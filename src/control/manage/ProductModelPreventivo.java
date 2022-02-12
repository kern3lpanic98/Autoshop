package control.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import control.interfaccia.modelloPreventivo;
import model.ConnectionDB;
import model.Preventivo;

public class ProductModelPreventivo implements modelloPreventivo{

	private Connection connection=null;
	PreparedStatement preparedStatement = null;
	private static final String TABLE_NAME = "preventivo";
	@Override
	public boolean doSave(Preventivo p) throws SQLException {
		
	
		try {
			
String selectSQL="INSERT INTO " +ProductModelPreventivo.TABLE_NAME+ " (ID_AUTO, USERCLIENT,DATA) VALUES (" +p.getId_auto()+", '" +p.getUserClient()+ "','"+p.getData()+"')";                  
		connection = ConnectionDB.getIstance().getConnection();
	  Statement stmt = connection.createStatement();
	  stmt.executeUpdate(selectSQL);
	  
	  
		
		
		
		}catch(SQLException e) {
		return false;
		
		
		
			
		}	
		return true;
	}

}
