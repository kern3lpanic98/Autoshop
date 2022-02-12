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

import control.interfaccia.modelloPreventivo;
import control.manage.ProductModelPreventivo;
import model.Preventivo;

/**
 * Servlet implementation class ControlPreventivo
 */
@WebServlet("/ControlPreventivo")
public class ControlPreventivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
	static modelloPreventivo model;
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	static {
		model = new ProductModelPreventivo();
	}

	public ControlPreventivo() {
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
		int id;
		String userClient;
		Preventivo p;
		String data_richiesta= null;
		if (action.equalsIgnoreCase("carica")) {
			if (request.getSession().getAttribute("userid") == null) {
				// request.setAttribute("url", "Preventivo.jsp");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				//dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				//dispatcher.forward(request, response);
			} else {
				id = Integer.parseInt(request.getParameter("id"));
				userClient = (String) request.getSession().getAttribute("userid");
				GregorianCalendar g = new GregorianCalendar();
				int anno = g.get(Calendar.YEAR);
				int mese = g.get(Calendar.MONTH) + 1;
				int giorno = g.get(Calendar.DATE);

				data_richiesta = "" + anno + "-" + mese + "-" + giorno;
				p = new Preventivo();
				p.setId_auto(id);
				p.setUserClient(userClient);
				p.setData(data_richiesta);

				try {

					request.setAttribute("esito", model.doSave(p));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				dispatcher = getServletContext().getRequestDispatcher("/Preventivo.jsp");
				dispatcher.forward(request, response);
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
		doGet(request, response);
	}

}
