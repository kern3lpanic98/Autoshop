package control;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import control.interfaccia.modelDip;
import control.manage.ProductModelDip;
import model.Client;
import model.Dipendente;

/**
 * Servlet implementation class ControlDip
 */
@WebServlet("/ControlDip")
public class ControlDip extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	static modelDip model;
	private RequestDispatcher dispatcher;

	static {
		model = new ProductModelDip();
	}

	public ControlDip() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = null;

		action = request.getParameter("action");
		try {

			if (action.equalsIgnoreCase("get")) {

				request.setAttribute("dips", model.doRetrieveAll());
				request.getRequestDispatcher("/viewDipendenti.jsp").forward(request, response);
				//dispatcher = getServletContext().getRequestDispatcher("/viewDipendenti.jsp");
				//dispatcher.forward(request, response);

			}
			if (action.equalsIgnoreCase("delete")) {

				String user = request.getParameter("dip");
				model.remove(user);
				request.setAttribute("dips", model.doRetrieveAll());
				request.getRequestDispatcher("/viewDipendenti.jsp").forward(request, response);
				//dispatcher = getServletContext().getRequestDispatcher("/viewDipendenti.jsp");
				//dispatcher.forward(request, response);

			}
			if (action.equalsIgnoreCase("insert")) {

				boolean esito;
				String username = request.getParameter("username");
				String nome = request.getParameter("nome");
				String password = request.getParameter("psw");
				String rpassword = request.getParameter("rpsw");
				String cognome = request.getParameter("cognome");

				if (username != null) {

					esito = model.doRetriveByUser(username);
					if (esito) {
						request.setAttribute("esitouser", "Email già presente! Riprovare");
						request.getRequestDispatcher("/insertDipendente.jsp").forward(request, response);
						//dispatcher = getServletContext().getRequestDispatcher("/insertDipendente.jsp");
						//dispatcher.forward(request, response);
					} else {
						Dipendente dip = new Dipendente();
						dip.setNome(nome);
						dip.setCognome(cognome);
						dip.setUsername(username);
						dip.setPassword(password);

						request.setAttribute("esito", model.doSave(dip));
						request.setAttribute("user", username);
						request.getRequestDispatcher("/homeAmministratore.jsp").forward(request, response);
						//dispatcher = getServletContext().getRequestDispatcher("/homeAmministratore.jsp");
						//dispatcher.forward(request, response);

					}

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

}
