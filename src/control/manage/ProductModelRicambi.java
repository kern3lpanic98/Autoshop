package control.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import control.interfaccia.modelRicambi;
import model.Carrello;
import model.ConnectionDB;
import model.RicambiAuto;

public class ProductModelRicambi implements modelRicambi {

	private static final String TABLE_NAME = "ricambi";

	public synchronized ArrayList<RicambiAuto> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<RicambiAuto> n = new ArrayList<RicambiAuto>();

		String selectSQL = "SELECT * FROM " + ProductModelRicambi.TABLE_NAME;

		try {
			connection = ConnectionDB.getIstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				RicambiAuto ricambio = new RicambiAuto();

				ricambio.setId(rs.getInt("ID"));
				ricambio.setMarca(rs.getString("MARCA"));
				ricambio.setTipo(rs.getString("TIPO"));
				ricambio.setPrezzo(rs.getDouble("PREZZO"));
				ricambio.setPath(rs.getString("PATH"));
				ricambio.setQuantità(rs.getInt("QNT"));

				n.add(ricambio);
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
	public RicambiAuto doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		RicambiAuto ricambio = new RicambiAuto();

		String selectSQL = "SELECT * FROM " + ProductModelRicambi.TABLE_NAME + " WHERE id = ?";

		try {
			// connection = DriverManagerConnection.getConnection();
			connection = ConnectionDB.getIstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ricambio.setId(rs.getInt("ID"));
				ricambio.setMarca(rs.getString("MARCA"));
				ricambio.setTipo(rs.getString("TIPO"));
				ricambio.setPrezzo(rs.getDouble("PREZZO"));
				ricambio.setPath(rs.getString("PATH"));
				ricambio.setQuantità(rs.getInt("QNT"));

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
		return ricambio;
	}

	@Override
	public ArrayList<RicambiAuto> doRetrieveAllByArray(ArrayList<Carrello> idr) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet rs = null;
		String selectSQL;
		ArrayList<RicambiAuto> ricambi = new ArrayList<RicambiAuto>(50);
		RicambiAuto ricambio = new RicambiAuto();
		try {
			connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();

			for (int i = 0; i < idr.size(); i++) {

				selectSQL = "SELECT * FROM " + ProductModelRicambi.TABLE_NAME + " WHERE id ="
						+ idr.get(i).getId_ricambio();

				rs = stmt.executeQuery(selectSQL);
				while (rs.next()) {
					int id = rs.getInt("ID");
					String marca = rs.getString("MARCA");
					String tipo = rs.getString("TIPO");
					double prezzo = rs.getDouble("PREZZO");
					String path = rs.getString("PATH");
                    int qnt = rs.getInt("QNT");
					ricambi.add(new RicambiAuto(id, marca, prezzo, path, tipo,qnt));

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ricambi;
	}

	@Override
	public boolean updateQnt(ArrayList<Integer> id, ArrayList<Integer> qnt) throws SQLException {
	ArrayList<String> query = new ArrayList<String>(50);
	ArrayList<Integer> loadQnt = new ArrayList<Integer>(50);
	Connection connection = null;
	ResultSet rs = null;
	
	 
	
				
	 connection = ConnectionDB.getIstance().getConnection();
		Statement stmt = connection.createStatement();
		
     for(int i=0;i<id.size();i++) {
    	 String selectSQL = "SELECT QNT FROM " + ProductModelRicambi.TABLE_NAME+" WHERE"+
 				" ID="+id.get(i);
    	
			rs = stmt.executeQuery(selectSQL);
			selectSQL=null;
			while(rs.next()) {
				
				loadQnt.add(rs.getInt("QNT")-qnt.get(i));
			}
    	 
     }
		
     for(int i=0;i<id.size();i++) {
    	 
    	 String selectUpdate = "UPDATE " + ProductModelRicambi.TABLE_NAME+" SET QNT="+
    			 loadQnt.get(i)+" WHERE ID="+id.get(i);
     	
			stmt.executeUpdate(selectUpdate);
			selectUpdate=null;
 	 
  }
     
		
		return true;
	}
	
	@Override
	public  boolean addQnt(int id,int qnt) throws SQLException{
		Connection connection = null;
		ResultSet rs = null;
		int conteggio_qnt=0;
		
		 connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();
		
			String selectSQL = "SELECT QNT FROM " + ProductModelRicambi.TABLE_NAME+" WHERE"+
	 				" ID="+id;
			
			rs=stmt.executeQuery(selectSQL);
			if(rs.next()) {
				conteggio_qnt+=rs.getInt("QNT")+qnt;
				
			}
		
		String selectUpdate = "UPDATE " + ProductModelRicambi.TABLE_NAME+" SET QNT="+
   			 conteggio_qnt+" WHERE ID="+id;
		
		stmt.executeUpdate(selectUpdate);
		
		return true;
	}

	public boolean removeRicambi(int id)throws SQLException{
		
		Connection connection = null;
		ResultSet rs = null;
		 connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();
		String selectDelete = "DELETE FROM " + ProductModelRicambi.TABLE_NAME+
	   			 " WHERE ID="+id;
		stmt.executeUpdate(selectDelete);
		return true;
	}

	@Override
	public boolean addRicambio(RicambiAuto r) throws SQLException {
		
		Connection connection = null;
		ResultSet rs = null;
		 connection = ConnectionDB.getIstance().getConnection();
			Statement stmt = connection.createStatement();
		String selectInsert = "INSERT INTO " + ProductModelRicambi.TABLE_NAME+
	  " (PREZZO,PATH,TIPO,MARCA,QNT) VALUES("+r.getPrezzo()+",'"+r.getPath()+"','"+
				r.getTipo()+"','"+r.getMarca()+"',"+r.getQuantità()+")";
		stmt.executeUpdate(selectInsert);
		
		return true;
	}
	
}
