package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.lucene.codecs.lucene50.Lucene50StoredFieldsFormat.Mode;

import control.interfaccia.modelRegister;
import control.manage.ProductModelRegister;
import model.Client;

/**
 * Servlet implementation class ControlRegister
 */
@WebServlet("/ControlRegister")
public class ControlRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatcher;
	static modelRegister model;
	private Connection connection = null;
	private Client client;
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	static {
		model = new ProductModelRegister();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean esito;
		String username = request.getParameter("username");
		String nome = request.getParameter("nome");
		String password = request.getParameter("psw");
		String rpassword = request.getParameter("rpsw");
		String cognome = request.getParameter("cognome");
		String via  = request.getParameter("via");
		String civico  = request.getParameter("civico");
		String cap  = request.getParameter("cap");
	
	    
	    GregorianCalendar g = new GregorianCalendar();
		int anno = g.get(Calendar.YEAR);
		int mese = g.get(Calendar.MONTH) + 1;
		int giorno = g.get(Calendar.DATE);

		String data_reg = "" + anno + "-" + mese + "-" + giorno;
		try {
		if (username != null) {
			
			
		
				esito = model.doRetriveByUser(username);
				if (esito) {
					request.setAttribute("esitouser", "Email già presente! Riprovare");
					request.getRequestDispatcher("/registrazione.jsp").forward(request, response);
					//dispatcher = getServletContext().getRequestDispatcher("/registrazione.jsp");
					//dispatcher.forward(request, response);
				}  else {
						client = new Client();
						client.setNome(nome);
						client.setCognome(cognome);
						client.setUsername(username);
						client.setPassword(password);
						client.setCap(cap);
						client.setCivico(civico);
						client.setVia(via);
						client.setData_reg(data_reg);
						request.setAttribute("esito", model.doSave(client));
					 
						request.getRequestDispatcher("/Concessionaria.jsp").forward(request, response);
					    //dispatcher = getServletContext().getRequestDispatcher("/Concessionaria.jsp");
						//dispatcher.forward(request, response);

					}

				}

	

		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			
			
		}
}


	


