package control.interfaccia;

import java.sql.SQLException;

import model.Rifornimento;

public interface modelRifornimento {
	
	public boolean doSave(Rifornimento r) throws SQLException;

}
