
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="model.ConnectionDB"%>

<%
	//prelevo i dati  
	String userid = request.getParameter("uname");
	String pwd = request.getParameter("pass");
    boolean esito = false;
	//prelevo la connessione
	ConnectionDB connection = ConnectionDB.getIstance();
	Connection con = connection.getConnection();

	Statement st = con.createStatement();
	ResultSet rs;

	rs = st.executeQuery("select * from members where uname='" + userid + "' and pass='" + pwd + "'");

	if (rs.next()) {

		session.setAttribute("userid", userid);
		/*	
			SessionFactory sessFact = HibernateUtil.getSessionFactory();
			Session sessione = sessFact.getCurrentSession();
			org.hibernate.Transaction tr = sessione.beginTransaction();
		
			SessionObject sessionDb = new SessionObject();
			 sessionDb.setSession(userid);
			 sessione.save(sessionDb);
			 tr.commit();
				sessFact.close();*/
		//out.println("welcome " + userid);
		//out.println("<a href='logout.jsp'>Log out</a>");
		out.println("<script>driver.switchTo().alert().accept();</script>");
        esito=true;
		response.sendRedirect("Concessionaria.jsp");

	}
	rs = st.executeQuery("select * from dipendenti where uname='" + userid + "' and pass='" + pwd + "'");
	if (rs.next()) {

		session.setAttribute("userid", userid);
		esito=true;
		response.sendRedirect("homeMaga.jsp");
	
		}
	
	
	rs = st.executeQuery("select * from admin where uname='" + userid + "' and pass='" + pwd + "'");
	if (rs.next()) {

		session.setAttribute("userid", userid);
		esito=true;
		response.sendRedirect("homeAmministratore.jsp");
	
		}
		

	
			
		
		
		
		 
	if(esito==false){
	session.setAttribute("login", "false");
	response.sendRedirect("index.jsp");
	}
%>
