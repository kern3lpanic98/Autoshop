package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import control.ControlPreventivo;
import control.manage.ProductModelPreventivo;
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


public class ControlPreventivoTest 
{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession sessione;
	private  RequestDispatcher dispatcher;
    private ServletContext context;
    private ControlPreventivo cp;
    private ProductModelPreventivo pp;
    
    
	@Before
    public void setUp() 
	{
		request = mock(HttpServletRequest.class);       
        response = mock(HttpServletResponse.class);
        sessione=Mockito. mock(HttpSession.class);
        dispatcher=Mockito. mock(RequestDispatcher.class);
        context=Mockito. mock(ServletContext.class);
        cp = new ControlPreventivo();
        pp = new ProductModelPreventivo();
       
    }
	
	@Test
	public void caricaTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlPreventivo");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getParameter("action")).thenReturn("carica");

		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        cp.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
	
	
        
	
}

