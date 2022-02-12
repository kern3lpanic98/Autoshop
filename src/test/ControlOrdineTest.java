package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import control.ControlOrdine;
import control.manage.ProductModelOrdine;
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
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.SQLException;


public class ControlOrdineTest 
{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession sessione;
	private  RequestDispatcher dispatcher;
    private ServletContext context;
    private ControlOrdine co;
    private ProductModelOrdine po;
    
    
	@Before
    public void setUp() 
	{
		request = mock(HttpServletRequest.class);       
        response = mock(HttpServletResponse.class);
        sessione=Mockito. mock(HttpSession.class);
        dispatcher=Mockito. mock(RequestDispatcher.class);
        context=Mockito. mock(ServletContext.class);
        co = new ControlOrdine();
        po = new ProductModelOrdine();
       
    }
	
	@Test
	public void caricaTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlloOrdine");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getAttribute("userid")).thenReturn("paolo@hotmail.it");

		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        co.doGet(request,response);
        
        
        
	}
	
}
