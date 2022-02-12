package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import control.ControlPreventivo;
import control.ControlloAutoNuove;
import control.manage.ProductModelDM;
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
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControlAutoNuoveTest 
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession sessione;
	private  RequestDispatcher dispatcher;
    private ServletContext context;
    private ControlloAutoNuove ca;
    private ProductModelDM pa;
    
    
	@Before
    public void setUp() 
	{
		request = mock(HttpServletRequest.class);       
        response = mock(HttpServletResponse.class);
        sessione=Mockito. mock(HttpSession.class);
        dispatcher=Mockito. mock(RequestDispatcher.class);
        context=Mockito. mock(ServletContext.class);
        ca = new ControlloAutoNuove();
        pa = new ProductModelDM();
       
    }
	
	@Test
	public void marcamodelloTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlPreventivo");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getParameter("marca")).thenReturn("audi");
		when(request.getParameter("modello")).thenReturn("A1");
		
		request.setAttribute("filtri", pa.doRetrieveByFilter("audi", "A1"));
		request.setAttribute("list", pa.doRetrieveAll());
		request.setAttribute("token", true);

		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        ca.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
	@Test
	public void readTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlPreventivo");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getParameter("action")).thenReturn("read");
		
		when(request.getParameter("id")).thenReturn("1");
		request.setAttribute("auto_nuove", pa.doRetrieveByKey(1));
		

		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        ca.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
	
	@Test
	public void deleteTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlPreventivo");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getParameter("action")).thenReturn("delete");
		
		when(request.getParameter("id")).thenReturn("1");
		
	
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        ca.doGet(request,response);

        
	}
	
	@Test
	public void caricaTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlPreventivo");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getParameter("action")).thenReturn("carica");
		
		request.setAttribute("token", false);
		request.setAttribute("list", pa.doRetrieveAll());
		

		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        ca.doGet(request,response);

        
	}
	

}
