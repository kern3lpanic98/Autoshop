package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import control.interfaccia.modelOrdine;
import control.manage.ProductModelOrdine;
import model.Carrello;
import model.Client;

/**
 * Servlet implementation class ControlOrdine
 */
@WebServlet(name = "ControlloOrdine", urlPatterns = { "/ControlloOrdine" })
public class ControlOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductModelDM usa il DriverManager

	static modelOrdine model;
	private RequestDispatcher dispatcher;

	@SuppressWarnings("unused")
	private int id;

	static {
		model = new ProductModelOrdine();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlOrdine() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userClient = (String) request.getSession().getAttribute("userid");
		String action = request.getParameter("action");
		ArrayList<Carrello> carrelli = null;
		Client cliente = null;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
