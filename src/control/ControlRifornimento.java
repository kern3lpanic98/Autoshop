package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import control.interfaccia.modelRifornimento;
import control.manage.ProductModelRif;
import model.Rifornimento;

/**
 * Servlet implementation class ControlRifornimento
 */
@WebServlet("/ControlRifornimento")
public class ControlRifornimento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	static modelRifornimento model;

	static {
		model = new ProductModelRif();
	}

	private RequestDispatcher dispatcher;

	public ControlRifornimento() {
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
		int id_ricambio;
		String userDip = null;
		int n_pezzi;
		String data_richiesta;
		String data_consegna;
		String aa, mm, gg;

		action = request.getParameter("action");
		userDip = (String) request.getSession().getAttribute("userid");
		if (userDip == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			//dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			//dispatcher.forward(request, response);
			return;
		}

		if (action.equalsIgnoreCase("insert")) {

			id_ricambio= Integer.parseInt(request.getParameter("id"));
			n_pezzi = Integer.parseInt(request.getParameter("n_pezzi"));

			gg = request.getParameter("gg");
			mm = request.getParameter("mm");
			aa = request.getParameter("aa");
			data_consegna = "" + aa + "-" + mm + "-" + gg;
			GregorianCalendar g = new GregorianCalendar();

			int anno = g.get(Calendar.YEAR);
			int mese = g.get(Calendar.MONTH) + 1;
			int giorno = g.get(Calendar.DATE);

			data_richiesta = "" + anno + "-" + mese + "-" + giorno;
			Rifornimento rif = new Rifornimento(id_ricambio, data_richiesta, data_consegna, n_pezzi, userDip);
			try {
				model.doSave(rif);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
