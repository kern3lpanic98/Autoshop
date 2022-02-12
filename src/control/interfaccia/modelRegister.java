package control.interfaccia;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Client;

public interface modelRegister {
	
	public boolean doSave(Client client) throws SQLException;
	public boolean doRetriveByUser(String user) throws SQLException;

	public ArrayList<String> getIndirizzo(String userClient) throws SQLException;
	

}
