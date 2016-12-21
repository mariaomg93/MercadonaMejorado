package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestores.GestorCesta;
import gestores.producto_pedido;

/**
 * Servlet implementation class CestaController
 */
@WebServlet("/CestaController")
public class CestaController extends HttpServlet {
	ArrayList<producto_pedido> cesta= new ArrayList<>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CestaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idProd= request.getParameter("id");
		GestorCesta gc= new GestorCesta();
		if(request.getParameter("fincesta")==null)
		{
		producto_pedido p=gc.addCesta(idProd);
		cesta.add(p);
		request.getSession().setAttribute("cesta", cesta);
		request.getRequestDispatcher("ProductoController").forward(request, response);
		}
		if(request.getParameter("fincesta")!=null)
		{
			gc.finCesta(cesta, request.getSession().getAttribute("id").toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
