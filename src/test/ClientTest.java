package test;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Client;

public class ClientTest {

	
	

	@Test
	public void testSetVia() {
		String via="alveopasso";
		Client c=new Client();
		c.setVia(via);
		assertEquals(c.getVia(),via);
	}



	@Test
	public void testSetCivico() {
		String civico="1";
		Client c=new Client();
		c.setCivico(civico);
		assertEquals(c.getCivico(),civico);
	}


	@Test
	public void testSetCap() {
		String cap="84014";
		Client c=new Client();
		c.setCap(cap);
		assertEquals(c.getCap(),cap);
	}

	@Test
	public void testClientStringStringStringStringStringStringString() {
		String nome="paolo",cognome="guidotti",username="wrath",password="paolo1998",cap="84014",civico="1";
		String via = "viaeccomi";
		
		Client c=new Client( nome, cognome, username, password,via,civico,cap);
		
		assertEquals(c.getNome(),nome);
		assertEquals(c.getCognome(),cognome);
		assertEquals(c.getUsername(),username);
		assertEquals(c.getVia(),via);
		assertEquals(c.getCivico(),civico);
		assertEquals(c.getCap(),cap);
		
	}


	@Test
	public void testSetNome() {
		String nome="paolo";
		Client c=new Client();
		c.setNome(nome);
		assertEquals(c.getNome(),nome);
	}


	@Test
	public void testSetCognome() {
		String cognome="guidotti";
		Client c=new Client();
		c.setCognome(cognome);
		assertEquals(c.getCognome(),cognome);	
	}

	

	@Test
	public void testSetUsername() {
		String username="prova";
		Client c=new Client();
		c.setUsername(username);
		assertEquals(c.getUsername(),username);
	}



	@Test
	public void testSetPassword() {
		String password="pass";
		Client c=new Client();
		c.setPassword(password);
		assertEquals(c.getPassword(),password);
	}

}
