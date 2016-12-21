package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestores.GestorUsuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre= request.getParameter("nombre");
		String edad= request.getParameter ("edad");
		String usuario= request.getParameter("usuario");
		String contraseña= request.getParameter("contrasenha");
		String usuarioReg= request.getParameter("user");
		String passReg= request.getParameter("password");
		
		if(request.getParameter("aceptar1") != null)
		{
			ResultSet cliente=null;
			GestorUsuario us= new GestorUsuario();
			cliente=us.TestUser(usuario, contraseña);
			try {
				if (cliente.next())
				{
				request.getSession().setAttribute("nombre", cliente.getString("nombre"));
				request.getSession().setAttribute("id", cliente.getString("ID"));
				request.getRequestDispatcher("jsp/perfil.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (request.getParameter("aceptar2") != null)
		{
			GestorUsuario us= new GestorUsuario();
			us.insertUser(nombre, edad, usuarioReg, passReg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
