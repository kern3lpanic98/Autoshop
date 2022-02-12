package control.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.interfaccia.modelCarrello;
import model.Carrello;
import model.ConnectionDB;

public class ProductModelCarrello implements modelCarrello {

	private static final String TABLE_NAME = "carrello";
	private ArrayList<Carrello> id_ricambi;

	private Connection connection = null;

	@Override
	public boolean doSave(Carrello c) throws SQLException {

		String selectSQL = "INSERT INTO " + ProductModelCarrello.TABLE_NAME
				+ " (id_ricambio,userClient,qnt,prezzo) VALUES(" + c.getId_ricambio() + ",'" + c.getUserClient() + "',"
				+ c.getQuantità() + "," + c.getPrezzo() + ")";

		String sql = "SELECT id_ricambio, userClient, qnt FROM " + ProductModelCarrello.TABLE_NAME
				+ " WHERE userClient='" + c.getUserClient() + "' AND id_ricambio=" + c.getId_ricambio();

		try {
			connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int qnt = rs.getInt("qnt") + c.getQuantità();
				String sql_add = "UPDATE " + ProductModelCarrello.TABLE_NAME + " SET qnt=" + qnt + " WHERE userClient='"
						+ c.getUserClient() + "' AND " + "id_ricambio=" + c.getId_ricambio();
				stmt.executeUpdate(sql_add);
			} else
				stmt.executeUpdate(selectSQL);

		} catch (SQLException e) {
			return false;

		}
		return true;
	}

	@Override
	public ArrayList<Carrello> doRetrieveByUserClient(String userClient) throws SQLException {
		id_ricambi = new ArrayList<Carrello>(50);
		int j = 0;
		try {

			String selectSQL = "SELECT *  FROM " + ProductModelCarrello.TABLE_NAME + " WHERE userClient= '" + userClient
					+ "'";

			connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(selectSQL);

			while (rs.next()) {
				int id = rs.getInt("Id_RICAMBIO");
				String user = rs.getString("userClient");
				int qnt = rs.getInt("qnt");
				double prezzo = rs.getDouble("prezzo");

				id_ricambi.add(new Carrello());
				id_ricambi.get(j).addRicambi(id, user, qnt, prezzo);
				j++;

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return id_ricambi;

	}

	public int doRetrieveByQnt(String userClient, int id) throws SQLException {

		int qnt = 0;
		try {

			String selectSQL = "SELECT qnt  FROM " + ProductModelCarrello.TABLE_NAME + " WHERE userClient= '"
					+ userClient + "'" + " AND id_ricambio=" + id;

			connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(selectSQL);
			if (rs.next()) {
				qnt = rs.getInt("qnt");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return qnt;
	}

	public void svuotaCarrello(String userClient) throws SQLException {
		connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();

		String sql_delete = "DELETE FROM " + ProductModelCarrello.TABLE_NAME + " WHERE USERCLIENT='" + userClient + "'";

		stmt.executeUpdate(sql_delete);
	}

	public void removeArticleById(int id, String userClient) throws SQLException {
		connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();

		String sql_delete = "DELETE FROM " + ProductModelCarrello.TABLE_NAME + " WHERE ID_RICAMBIO=" + id
				+ " AND USERCLIENT='" + userClient + "'";

		stmt.executeUpdate(sql_delete);
	}

}
