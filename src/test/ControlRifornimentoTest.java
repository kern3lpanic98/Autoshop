package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import control.ControlRegister;
import control.ControlRifornimento;
import control.manage.ProductModelRegister;
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
import java.util.HashMap;
import java.util.Map;

public class ControlRifornimentoTest 
{
	private ControlRegister servlet;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession sessione;
	private  RequestDispatcher dispatcher;
    private ServletContext context;
    private ControlRifornimento cr;
    private ProductModelRif pr;
    
    
	@Before
    public void setUp() 
	{
		request = mock(HttpServletRequest.class);       
        response = mock(HttpServletResponse.class);
        sessione=Mockito. mock(HttpSession.class);
        dispatcher=Mockito. mock(RequestDispatcher.class);
        context=Mockito. mock(ServletContext.class);
        cr = new ControlRifornimento();
        pr = new ProductModelRif();
       
    }
	
	@Test
	public void userDiprTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlRifornimento");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getAttribute("userid")).thenReturn("dip_prova@hotmail.it");
		//when(request.getParameter("userId")).thenReturn(null);
		
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        cr.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
	
	@Test
	public void insertTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlRifornimento");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getAttribute("userid")).thenReturn("dip_prova@hotmail.it");
		when(request.getParameter("action")).thenReturn("insert");
		
		when(request.getParameter("id")).thenReturn("2");
		when(request.getParameter("n_pezzi")).thenReturn("9");
		
		when(request.getParameter("gg")).thenReturn("10");
		when(request.getParameter("mm")).thenReturn("02");
		when(request.getParameter("aa")).thenReturn("2022");
		
		
		
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        cr.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
}

