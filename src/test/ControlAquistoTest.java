package test;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import control.ControlAcquisto;
import control.manage.ProductModelCarrello;
import control.manage.ProductModelOrdine;
import control.manage.ProductModelRicambi;
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

public class ControlAquistoTest  extends Mockito
{
	
	private ControlAcquisto servlet;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession sessione;
	private  RequestDispatcher dispatcher;
    private ServletContext context;
    private ControlAcquisto ca;
    
    
	@Before
    public void setUp() 
	{
		request = mock(HttpServletRequest.class);       
        response = mock(HttpServletResponse.class);
        sessione=Mockito. mock(HttpSession.class);
        dispatcher=Mockito. mock(RequestDispatcher.class);
        context=Mockito. mock(ServletContext.class);
        ca = new ControlAcquisto();
        
        
        
    }
	
	@Test
	public void primoTest() throws ServletException, IOException, SQLException 
	{
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlAcquisto");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
	     
		
		
		when(request.getSession().getAttribute("userid")).thenReturn("pippo");
		when(request.getParameter("action")).thenReturn("acquisto");
		int numberSelect=1;
		when(request.getParameter("numberSelect")).thenReturn(Integer.toString(numberSelect));
		
		ArrayList<Integer> id_ricambi = new ArrayList<Integer>();
		for (int i = 1; i <= numberSelect; i++) 
		{
			when(request.getParameter(""+i)).thenReturn((Integer.toString(i)));
			id_ricambi.add(i);
		}
		
		when(request.getSession().getAttribute("id_ricambi")).thenReturn(id_ricambi);
		
		
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        ca.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
   
	}
	
	
	
	
	
	
}
