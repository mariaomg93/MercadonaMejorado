package gestores;

import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.MysqlConnect;

public class GestorProd {
	protected MysqlConnect c=MysqlConnect.getDbCon();
	
	public ResultSet listProd()
	{
		ResultSet rs=null;
		String query="Select * from productos";
		try {
			rs=c.query(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet detalle(String id)
	{
		ResultSet rs=null;
		String query="Select * from productos where ID="+id+";";
		try {
			rs=c.query(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
