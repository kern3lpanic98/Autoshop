package control.interfaccia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.Carrello;
import model.RicambiAuto;

public interface modelOrdine {

	public boolean doSave(ArrayList<Carrello> c, ArrayList<Integer> id_r,
			ArrayList<Integer> qnt) throws SQLException;
	
	
	

}
