package control.manage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.interfaccia.modelRegister;
import control.interfaccia.modelRifornimento;
import model.ConnectionDB;
import model.Rifornimento;

public class ProductModelRif implements modelRifornimento{
	
	
	private Connection connection=null;
	private modelRegister modelClient = null;
	private static final String TABLE_NAME = "rifornimento";
	
	@Override
	public boolean doSave(Rifornimento r) throws SQLException {
	
		String selectSQL="INSERT INTO " +ProductModelRif.TABLE_NAME+ " (ID_RICAMBIO,D_CONSEGNA,D_RICHIESTA,N_PEZZI,USERDIP) VALUES ("+r.getId_ricambio()+", '"+r.getDataConsegna()+"', '"+r.getDataRichiesta()+"',"+r.getNumeroPezzi()+",'"+r.getUserDip()+"')";
       
     connection = ConnectionDB.getIstance().getConnection();
     Statement stmt = connection.createStatement();
     stmt.executeUpdate(selectSQL);
      
	 
	
    return true;
	  
	
	}


}
