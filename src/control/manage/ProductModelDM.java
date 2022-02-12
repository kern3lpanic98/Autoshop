package control.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import control.interfaccia.modelloAutoNuove;
import model.Automobile;
import model.ConnectionDB;

public class ProductModelDM implements modelloAutoNuove {

	private static final String TABLE_NAME = "auto_nuove";



	@Override
	public synchronized Automobile doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Automobile nuove = new Automobile();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " WHERE id = ?";

		try {
			// connection = DriverManagerConnection.getConnection();
			connection = ConnectionDB.getIstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				nuove.setId(rs.getInt("ID"));
				nuove.setMarca(rs.getString("MARCA"));
				nuove.setModello(rs.getString("MODELLO"));
				nuove.setPrezzo(rs.getDouble("PREZZO"));
				nuove.setPath(rs.getString("PATH"));
				
                  
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				// DriverManagerConnection.releaseConnection(connection);
			}
		}
		return nuove;
	}

	@Override
	public synchronized boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		// String deleteSQL = "DELETE FROM " + ProductModelDM.TABLE_NAME + " WHERE ID =
		// ?";

		/*
		 * try { connection = DriverManagerConnection.getConnection(); preparedStatement
		 * = connection.prepareStatement(deleteSQL); preparedStatement.setInt(1, id);
		 * 
		 * result = preparedStatement.executeUpdate();
		 * 
		 * } finally { try { if (preparedStatement != null) preparedStatement.close(); }
		 * finally { DriverManagerConnection.releaseConnection(connection); } }
		 */
		return (result != 0);
	}

	@Override
	public synchronized ArrayList<Automobile> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Automobile> n = new ArrayList<Automobile>();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME;

		/*
		 * if (order != null && !order.equals("")) { selectSQL += " ORDER BY " + order;
		 * }
		 */
		
		try {
			connection = ConnectionDB.getIstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Automobile nuove = new Automobile();
				
				nuove.setId(rs.getInt("ID"));
				nuove.setMarca(rs.getString("MARCA"));
				nuove.setModello(rs.getString("MODELLO"));
				nuove.setPrezzo(rs.getDouble("PREZZO"));
				nuove.setPath(rs.getString("PATH"));

				n.add(nuove);
			
			}
			

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				/* DriverManagerConnection.releaseConnection(connection); */
			}
		}
		return n;
	}

	@Override
	public ArrayList<Automobile> doRetrieveByFilter(String marca, String modello) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Automobile> n = new ArrayList<Automobile>();
		
       
		String forMarca = "SELECT * FROM " + ProductModelDM.TABLE_NAME +"WHERE MARCA="+marca;

		String forModello = "SELECT * FROM " + ProductModelDM.TABLE_NAME +"WHERE MODELLO="+modello;

		String forMarcaModel = "SELECT * FROM " + ProductModelDM.TABLE_NAME +" WHERE marca = '"+marca+"' and modello= '"+modello+"'";
		
		try {
			connection = ConnectionDB.getIstance().getConnection();
			if(marca!=null && modello!=null) {
			preparedStatement = connection.prepareStatement(forMarcaModel);
			
			}
			
			else if(marca==null && modello!=null) {
				System.out.println(marca);
				preparedStatement = connection.prepareStatement(forModello);
				}
			else if(marca!=null && modello==null) {
				preparedStatement = connection.prepareStatement(forMarca);
				}
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Automobile nuove = new Automobile();

				nuove.setId(rs.getInt("ID"));
				nuove.setMarca(rs.getString("MARCA"));
				nuove.setModello(rs.getString("MODELLO"));
				nuove.setPrezzo(rs.getInt("PREZZO"));
				nuove.setPath(rs.getString("PATH"));

				n.add(nuove);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				/* DriverManagerConnection.releaseConnection(connection); */
			}
		}
		return n;
	
	}

}