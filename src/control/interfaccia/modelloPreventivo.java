package control.interfaccia;

import java.sql.SQLException;

import model.Preventivo;

public interface modelloPreventivo {
	
	public boolean doSave(Preventivo p) throws SQLException;

}
