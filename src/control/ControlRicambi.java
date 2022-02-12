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

import control.interfaccia.modelRicambi;
import control.manage.ProductModelRicambi;
import model.RicambiAuto;

/**
 * Servlet implementation class ControlRicambi
 */
@WebServlet("/ControlRicambi")
public class ControlRicambi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static modelRicambi model;
	private RequestDispatcher dispatcher;

	static {
		model = new ProductModelRicambi();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlRicambi() {
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
		String action = request.getParameter("action");
		String dip = null;

		String marca = null;
		String tipo = null;
		String path = null;

		try {
			if (action != null) {

				carica(action, dip, request, response);
				if (action.equalsIgnoreCase("read")) {
					int id = Integer.parseInt(request.getParameter("id"));

					request.setAttribute("ricambio", model.doRetrieveByKey(id));
					request.getRequestDispatcher("/DettagliRicambi.jsp").forward(request, response);
					//dispatcher = getServletContext().getRequestDispatcher("/DettagliRicambi.jsp");
					//dispatcher.forward(request, response);

				} else if (action.equalsIgnoreCase("updateRicambi")) {
					action = "carica";
					dip = "m";
					int id = Integer.parseInt(request.getParameter("id"));
					int qnt = Integer.parseInt(request.getParameter("qntRicambi"));
					model.addQnt(id, qnt);

					carica(action, dip, request, response);
				} else if (action.equalsIgnoreCase("delete")) {
					if (request.getSession().getAttribute("userid") == null) {
						request.getRequestDispatcher("/index.jsp").forward(request, response);
						//dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
						//dispatcher.forward(request, response);
						return;
					}
					action = "carica";
					dip = "m";
					int id = Integer.parseInt(request.getParameter("id"));
					model.removeRicambi(id);

					carica(action, dip, request, response);
				} else if (action.equalsIgnoreCase("insert")) {
					action = "carica";
					dip = "m";
					int qnt = Integer.parseInt(request.getParameter("qnt"));
					marca = request.getParameter("marca");
					tipo = request.getParameter("tipo");
					path = request.getParameter("path");
					double prezzo = Double.parseDouble(request.getParameter("prezzo"));
					RicambiAuto ricambio = new RicambiAuto(marca, prezzo, path, tipo, qnt);
					model.addRicambio(ricambio);
					carica(action, dip, request, response);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	// funzione carica
	private void carica(String action, String dip, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		if (action.equalsIgnoreCase("carica")) {
			request.setAttribute("ricambi", model.doRetrieveAll());

			if (request.getParameter("dip") != null || dip != null) {

				if (dip == null) {
					dip = request.getParameter("dip");
				}

				if (dip.equalsIgnoreCase("m")) {

					dispatcher = getServletContext().getRequestDispatcher("/viewRicambi.jsp");

					if (request.getParameter("page") != null) {
						String page = request.getParameter("page");
						if (page.equalsIgnoreCase("rifornimento")) {
							dispatcher = getServletContext().getRequestDispatcher("/requestRifornimento.jsp");
						}
						if (page.equalsIgnoreCase("ricambi")) {
							dispatcher = getServletContext().getRequestDispatcher("/viewRicambi.jsp");
						}
					}
				}
			} else {
				dispatcher = getServletContext().getRequestDispatcher("/Ricambi.jsp");
			}

			dispatcher.forward(request, response);
		} else
			return;
	}

}
