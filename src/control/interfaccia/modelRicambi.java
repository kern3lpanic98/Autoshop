package control.interfaccia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import model.Carrello;
import model.RicambiAuto;

public interface modelRicambi {
	
	public Collection<RicambiAuto> doRetrieveAll() throws SQLException;
	public RicambiAuto doRetrieveByKey(int id) throws SQLException ;
	public ArrayList<RicambiAuto> doRetrieveAllByArray(ArrayList<Carrello> idr) throws SQLException;
    public boolean updateQnt(ArrayList<Integer> id,ArrayList<Integer> qnt) throws SQLException;
    public  boolean addQnt(int id,int qnt) throws SQLException;
    public boolean removeRicambi(int id)throws SQLException;
    public boolean addRicambio(RicambiAuto r) throws SQLException;
}
