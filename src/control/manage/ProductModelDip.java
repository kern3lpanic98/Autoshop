package control.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import control.interfaccia.modelDip;
import model.ConnectionDB;
import model.Dipendente;

public class ProductModelDip implements modelDip {

	private static final String TABLE_NAME = "dipendenti";
	private Connection connection = null;
	private ResultSet rs = null;
	@Override
	public boolean doSave(Dipendente d) throws SQLException {

		try {

			String selectSQL = "INSERT INTO " + ProductModelDip.TABLE_NAME
					+ " (NOME,COGNOME,UNAME,PASS) VALUES ('" + d.getNome() + "', '" + d.getCognome()
					+ "', '" + d.getUsername() + "' ,'" + d.getPassword() + "')";
			connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(selectSQL);

			

		} catch (SQLException e) {
			return false;

		}
		return true;
	}

	@Override
	public ArrayList<Dipendente> doRetrieveAll() throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Dipendente> n = new ArrayList<Dipendente>();

		String selectSQL = "SELECT * FROM " + ProductModelDip.TABLE_NAME;

		try {
			connection = ConnectionDB.getIstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Dipendente dip = new Dipendente();

				dip.setNome(rs.getString("nome"));
				dip.setCognome(rs.getString("cognome"));
				dip.setUsername(rs.getString("uname"));
				dip.setPassword(rs.getString("pass"));

				n.add(dip);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;

	}
	
	

	@Override
	public boolean doRetriveByUser(String user) throws SQLException {
		String selectSQL = "SELECT uname FROM " + ProductModelDip.TABLE_NAME + " WHERE uname='" + user + "'";
		connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(selectSQL);

		if (rs.next())
			return true;
		return false;
	}

	@Override
	public void remove(String user) throws SQLException {
		
		String selectSQL = "DELETE FROM " + ProductModelDip.TABLE_NAME + " WHERE uname='" + user + "'";
		connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();
	stmt.executeUpdate(selectSQL);
		
	}
}
