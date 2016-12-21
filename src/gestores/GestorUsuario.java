package gestores;

import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.MysqlConnect;

public class GestorUsuario {
	
	protected MysqlConnect c=MysqlConnect.getDbCon();
	
	public ResultSet TestUser(String user, String pass)
	{
		String query="Select * from clientes where user='"+user+"' and password='"+pass+"'";
		ResultSet rs=null;
		try {
			rs= c.query(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insertUser(String nombre,String edad, String usuarioReg, String passReg)
	{
		String insertQuery="insert into clientes values(null,'"+nombre+"','"+edad+"','"+usuarioReg+"','"+passReg+"')";
		int res=0;
		try {
			res=c.insert(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
