package control.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.interfaccia.modelRegister;
import model.Client;
import model.ConnectionDB;

public class ProductModelRegister implements modelRegister {

	private Connection connection = null;
	private ResultSet rs = null;
	private static final String TABLE_NAME = "members";
	private static final String TABLE_NAME_CARD = "card";

	@Override
	public boolean doSave(Client c) throws SQLException {

		try {

			String selectSQL = "INSERT INTO " + ProductModelRegister.TABLE_NAME
					+ " (NOME,COGNOME,UNAME,PASS,VIA,CIVICO,CAP,DATA) VALUES ('" + c.getNome() + "', '" + c.getCognome()
					+ "', '" + c.getUsername() + "' ,'" + c.getPassword() + "', '" + c.getVia() + "', '" + c.getCivico()
					+ "', '" + c.getCap() + "','"+c.getData_reg()+"')";
			connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(selectSQL);

			

		} catch (SQLException e) {
			return false;

		}
		return true;
	}

	@Override
	public boolean doRetriveByUser(String user) throws SQLException {
		String selectSQL = "SELECT uname FROM " + ProductModelRegister.TABLE_NAME + " WHERE uname='" + user + "'";
		connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(selectSQL);

		if (rs.next())
			return true;
		return false;
	}
/*
	public boolean doSaveCard(String user) throws SQLException {

		String selectSQL = "INSERT INTO " + ProductModelRegister.TABLE_NAME_CARD
				+ " (UNAME,CODICE,SICUREZZA,TIPO,MESE,ANNO,PAESE) VALUES ('" + c.getUserEmail() + "', '" + c.getCodice()
				+ "', '" + c.getCvv() + "' ,'" + c.getTipo() + "', '" + c.getMese() + "', '" + c.getAnno() + "', '"
				+ c.getPaese() + "')";
		connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(selectSQL);
		return true;

	}*/

	public ArrayList<String> getIndirizzo(String userClient) throws SQLException {
		ArrayList<String> indirizzo = new ArrayList<String>(50);

		String selectSQL = "SELECT via,civico,cap FROM " + ProductModelRegister.TABLE_NAME + " WHERE UNAME='"
				+ userClient + "'";

		connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(selectSQL);
		if (rs.next()) {
			
			indirizzo.add(rs.getString("VIA"));
			indirizzo.add(rs.getString("civico"));
			indirizzo.add(rs.getString("CAP"));
		}

		return indirizzo;

	}

}
