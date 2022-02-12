package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import control.ControlRicambi;
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


public class ControlRicambiTest 
{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession sessione;
	private  RequestDispatcher dispatcher;
    private ServletContext context;
    private ControlRicambi cr;
    private ProductModelRicambi pr;
    
    
	@Before
    public void setUp() 
	{
		request = mock(HttpServletRequest.class);       
        response = mock(HttpServletResponse.class);
        sessione=Mockito. mock(HttpSession.class);
        dispatcher=Mockito. mock(RequestDispatcher.class);
        context=Mockito. mock(ServletContext.class);
        cr = new ControlRicambi();
        pr = new ProductModelRicambi();
        
        
        
    }
	
	@Test
	public void ReadTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlRicambi");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getParameter("action")).thenReturn("read");
		when(request.getParameter("id")).thenReturn("3");
		request.setAttribute("ricambio", pr.doRetrieveByKey(3));
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
        cr.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
	
	/*@Test
	public void updateRicambiTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlRicambi");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getParameter("action")).thenReturn("updateRicambi");
		when(request.getParameter("id")).thenReturn("1");
		when(request.getParameter("qntRicambi")).thenReturn("100");
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        
	}
	
	@Test
	public void deleteTest() throws ServletException, IOException, SQLException 
	{
		
		
		when(request.getSession()).thenReturn(sessione);
		when(request.getPathInfo()).thenReturn("/ControlRicambi");
		when(context.getContextPath()).thenReturn("");
		when(request.getServletContext()).thenReturn(context);
		
		when(request.getParameter("action")).thenReturn("delete");
		//when(request.getParameter("userId")).thenReturn(null);
		when(request.getParameter("userId")).thenReturn("24");
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		
		cr.doGet(request,response);
        verify(dispatcher,atLeastOnce()).forward(request,response);

        
	}
	*/


}
