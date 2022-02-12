package control.interfaccia;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Carrello;

public interface modelCarrello {

	public boolean doSave(Carrello carrello) throws SQLException;
	public ArrayList<Carrello> doRetrieveByUserClient(String userClient) throws SQLException ;
	public int doRetrieveByQnt(String userClient,int id) throws SQLException;
	public void svuotaCarrello(String userClient) throws SQLException;
	public void removeArticleById(int id, String userClient) throws SQLException;
}
