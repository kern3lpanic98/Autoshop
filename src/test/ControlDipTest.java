package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import control.ControlDip;
import control.ControlRicambi;
import control.ControlRifornimento;
import control.manage.ProductModelDip;
import control.manage.ProductModelRicambi;
import control.manage.ProductModelRif;
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


public class ControlDipTest 
{
	private ControlRifornimento servlet;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession sessione;
	private  RequestDispatcher dispatcher;
    private ServletContext context;
    private ControlDip cd;
    private ProductModelDip pd;
    
    
	@Before
    public void setUp() 
	{
		request = mock(HttpServletRequest.class);       
        response = mock(HttpServletResponse.class);
        sessione=Mockito. mock(HttpSession.class);
        dispatcher=Mockito. mock(RequestDispatcher.class);
        context=Mockito. mock(ServletContext.class);
        cd = new ControlDip();
        pd = new ProductModelDip();
        
        
        
    }
	
	@Test
	public void GetTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlDip");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getParameter("action")).thenReturn("get");
		request.setAttribute(("dips"), pd.doRetrieveAll());

		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        cd.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
	
	@Test
	public void deleteTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlDip");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getParameter("action")).thenReturn("delete");
		request.setAttribute(("dip"), pd.doRetrieveAll());

		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        cd.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
	
	@Test
	public void insertTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlDip");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
	
		when(request.getParameter("action")).thenReturn("insert");
		when(request.getParameter("username")).thenReturn("dip_prova@hotmail.it");
		when(request.getParameter("nome")).thenReturn("Onelia");
		when(request.getParameter("psw")).thenReturn("passdip2");
		when(request.getParameter("rpsw")).thenReturn("passdip2");
		when(request.getParameter("cognome")).thenReturn("Cataldo");
		
		
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        cd.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
	
	
	
	


}

