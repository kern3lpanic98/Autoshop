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

import control.interfaccia.modelCarrello;
import control.interfaccia.modelRicambi;
import control.manage.ProductModelCarrello;
import control.manage.ProductModelRicambi;
import model.Carrello;
import model.RicambiAuto;

/**
 * Servlet implementation class ControlCarrello
 */
@WebServlet("/ControlCarrello")
public class ControlCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatcher;
	static modelCarrello model;
	static modelRicambi ricambi;
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	static {
		model = new ProductModelCarrello();
		ricambi = new ProductModelRicambi();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlCarrello() {
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
		ArrayList<Carrello> carUtente = null;
		ArrayList<RicambiAuto> ricambi_auto = null;

		String userClient = (String) request.getSession().getAttribute("userid");

		try {
			if (request.getSession().getAttribute("userid") == null) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				//dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				//dispatcher.forward(request, response);
			} else if (action != null) {

				if (action.equalsIgnoreCase("read")) {

					readCarrello(carUtente, ricambi_auto, userClient, request, response);
				}

				if (action.equalsIgnoreCase("svuota")) {

					model.svuotaCarrello(userClient);
					readCarrello(carUtente, ricambi_auto, userClient, request, response);
				}
				if (action.equalsIgnoreCase("remove")) {
					int id = Integer.parseInt(request.getParameter("id"));
					model.removeArticleById(id,userClient);
					readCarrello(carUtente, ricambi_auto, userClient, request, response);
				}

			}

			else {

				int quantità= Integer.parseInt(request.getParameter("quantità"));
				int id = Integer.parseInt(request.getParameter("id"));
				double prezzo = Double.parseDouble(request.getParameter("prezzo"));

				Carrello car = new Carrello();
				car.addRicambi(id, userClient, quantità, prezzo);

				model.doSave(car);

				request.setAttribute("qnt", model.doRetrieveByQnt(userClient, id));
				request.setAttribute("ricambio", ricambi.doRetrieveByKey(id));

				dispatcher = getServletContext().getRequestDispatcher("/feedbackAggiunta.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void readCarrello(ArrayList<Carrello> carUtente, ArrayList<RicambiAuto> ricambi_auto, String userClient,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		carUtente = model.doRetrieveByUserClient(userClient);
		ricambi_auto = ricambi.doRetrieveAllByArray(carUtente);
		request.setAttribute("tutti_ricambi", ricambi_auto);
		request.setAttribute("contenuto_carrello", carUtente);
		dispatcher = getServletContext().getRequestDispatcher("/carrello.jsp");
		dispatcher.forward(request, response);
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
