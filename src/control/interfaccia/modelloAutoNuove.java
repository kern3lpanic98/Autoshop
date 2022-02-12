package control.interfaccia;

import java.sql.SQLException;
import java.util.Collection;

import model.Automobile;






public interface modelloAutoNuove
{

	
	public boolean doDelete(int id) throws SQLException;

	public Automobile doRetrieveByKey(int id) throws SQLException ;
	


	public Collection<Automobile> doRetrieveAll() throws SQLException;
	
	public Collection<Automobile> doRetrieveByFilter(String marca, String modello) throws SQLException;


}
