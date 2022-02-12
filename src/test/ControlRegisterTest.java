package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import control.ControlRegister;
import control.manage.ProductModelRegister;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ControlRegisterTest 
{
	private ControlRegister servlet;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession sessione;
	private  RequestDispatcher dispatcher;
    private ServletContext context;
    private ControlRegister cr;
    private ProductModelRegister pr;
    
    
	@Before
    public void setUp() 
	{
		request = mock(HttpServletRequest.class);       
        response = mock(HttpServletResponse.class);
        sessione=Mockito. mock(HttpSession.class);
        dispatcher=Mockito. mock(RequestDispatcher.class);
        context=Mockito. mock(ServletContext.class);
        cr = new ControlRegister();
        pr = new ProductModelRegister();
        
        
        
    }
	
	@Test
	public void registerTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlRegister");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		boolean esito=true;
		when(request.getParameter("username")).thenReturn("pippi@hotmail.it");
		when(request.getParameter("nome")).thenReturn("pippo");
		when(request.getParameter("psw")).thenReturn("pippi");
		when(request.getParameter("rpsw")).thenReturn("pippi");
		when(request.getParameter("cognome")).thenReturn("calze");
		when(request.getParameter("via")).thenReturn("paganini");
		when(request.getParameter("civico")).thenReturn("31");
		when(request.getParameter("cap")).thenReturn("84091");
		
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        cr.doPost(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
}
