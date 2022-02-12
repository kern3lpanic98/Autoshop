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
import control.interfaccia.modelOrdine;
import control.interfaccia.modelRicambi;
import control.manage.ProductModelCarrello;
import control.manage.ProductModelOrdine;
import control.manage.ProductModelRicambi;
import model.Carrello;
import model.RicambiAuto;

/**
 * Servlet implementation class ControlAcquisto
 */
@WebServlet("/ControlAcquisto")
public class ControlAcquisto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatcher;
	static modelCarrello carrelli;
	static modelRicambi ricambi;
	static modelOrdine ordini;
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	static {
		carrelli = new ProductModelCarrello();
		ricambi = new ProductModelRicambi();
		ordini = new ProductModelOrdine();
	}

	public ControlAcquisto() {
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
		String userClient = (String) request.getSession().getAttribute("userid");
		ArrayList<Integer> qnt = null;
		ArrayList<Integer> id_ricambi = null;
		ArrayList<Carrello> carUtenti = null;
		try {
			if (userClient != null) {

				if (action.equalsIgnoreCase("acquisto")) {

					int numberSelect = Integer.parseInt(request.getParameter("numberSelect"));
					qnt = new ArrayList<Integer>(50);

					for (int i = 1; i <= numberSelect; i++) {

						qnt.add(Integer.parseInt(request.getParameter("" + i)));

					}
					id_ricambi = (ArrayList<Integer>) request.getSession().getAttribute("id_ricambi");

					request.getSession().removeAttribute("id_ricambi");

					ricambi.updateQnt(id_ricambi, qnt);

					carUtenti = carrelli.doRetrieveByUserClient(userClient);
		
					//ordini.doSave(carUtenti,id_ricambi,qnt);
					carrelli.svuotaCarrello(userClient);
					request.getRequestDispatcher("/regCard.jsp").forward(request, response);
					//dispatcher = getServletContext().getRequestDispatcher("/regCard.jsp");
					//dispatcher.forward(request, response);

				}

			} else {
				dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
