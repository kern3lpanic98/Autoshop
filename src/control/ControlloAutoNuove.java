package control;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import control.interfaccia.modelloAutoNuove;
import control.manage.ProductModelDM;


/**
 * Servlet implementation class ControlloAutoNuove
 */
@WebServlet("/ControlloAutoNuove")
public class ControlloAutoNuove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductModelDM usa il DriverManager

	static modelloAutoNuove model;
	private RequestDispatcher dispatcher;

	@SuppressWarnings("unused")
	private int id;

	static {
		model = new ProductModelDM();
	}

	public ControlloAutoNuove() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String fmarca = request.getParameter("marca");
		String fmodello = request.getParameter("modello");

		try {

			if (fmarca != null || fmodello != null) {
				request.setAttribute("filtri", model.doRetrieveByFilter(fmarca, fmodello));
				request.setAttribute("list", model.doRetrieveAll());
				request.setAttribute("token", "true");
				request.getRequestDispatcher("/auto_nuove.jsp").forward(request, response);
				//dispatcher = getServletContext().getRequestDispatcher("/auto_nuove.jsp");
				//dispatcher.forward(request, response);
			}
			if (action != null) {
				if (action.equalsIgnoreCase("read")) {
					int id = Integer.parseInt(request.getParameter("id"));

					request.removeAttribute("auto_nuove");
					request.setAttribute("auto_nuove", model.doRetrieveByKey(id));
					request.getRequestDispatcher("/VistaProdotti.jsp").forward(request, response);
					//dispatcher = getServletContext().getRequestDispatcher("/VistaProdotti.jsp");
					//dispatcher.forward(request, response);
				} else if (action.equalsIgnoreCase("delete")) {
					int id = Integer.parseInt(request.getParameter("id"));
					model.doDelete(id);
				} else if (action.equalsIgnoreCase("carica")) {
					
					request.setAttribute("token", "false");
					
					request.setAttribute("list", model.doRetrieveAll());
					request.getRequestDispatcher("/auto_nuove.jsp").forward(request, response);
					//dispatcher = getServletContext().getRequestDispatcher("/auto_nuove.jsp");
					//dispatcher.forward(request, response);
				} 

			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
