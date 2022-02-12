package control.interfaccia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.Dipendente;

public interface modelDip {

	
	public boolean doSave(Dipendente d) throws SQLException;
	public Collection<Dipendente> doRetrieveAll() throws SQLException;
	public boolean doRetriveByUser(String user) throws SQLException;
	public void remove(String user) throws SQLException;
	
}
