package gestores;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BBDD.MysqlConnect;

public class GestorCesta {
	
	protected MysqlConnect c = MysqlConnect.getDbCon();

	public producto_pedido addCesta(String id)
	{
		producto_pedido pp= new producto_pedido(id, "5");
		return pp;
	}
	
	public void finCesta(ArrayList<producto_pedido> p, String idUser)
	{
		ResultSet rs =null;
		String pep="Insert into pedidos values(null, current_date(),"+idUser+" )";
		String getId="select * from pedidos where cliente="+idUser+" order by ID desc limit 1;";
		String pedido="";
		try {
			c.insert(pep);
			rs=c.query(getId);
			rs.next();
			pedido= rs.getString(1);
			for (int i = 0; i < p.size(); i++) {
				String ped_prod="INSERT INTO `prodructos-pedidos`(`ID_producto`, `ID_pedido`, `cantidad`) VALUES ("+p.get(i).idProd+","+pedido+","+p.get(i).cantidad+")";
				c.insert(ped_prod);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
