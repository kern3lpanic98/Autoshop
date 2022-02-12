package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Client;
import model.Dipendente;

public class DipendenteTest {

	@Test
	public void testDipendenteStringStringStringString() {
		String nome="Mario",cognome="Rossi",username="mariorossi@hotmail.it",password="passdip1";
	
		
		Dipendente d=new Dipendente( nome, cognome, username, password);
		
		assertEquals(d.getNome(),nome);
		assertEquals(d.getCognome(),cognome);
		assertEquals(d.getUsername(),username);
		assertEquals(d.getPassword(),password);
		
	
	}

	

	@Test
	public void testSetNome() {
		
		String nome="Mario";
		Dipendente d=new Dipendente();
		d.setNome(nome);
		assertEquals(d.getNome(),nome);
	}

	@Test
	public void testSetCognome() {
		String cognome="Rossi";
		Dipendente d = new Dipendente();
		d.setCognome(cognome);
		assertEquals(d.getCognome(),cognome);
	}

	@Test
	public void testSetUsername() {
		String username="mariorossi@hotmail.it";
		Dipendente d = new Dipendente();
		d.setUsername(username);
		assertEquals(d.getUsername(),username);
	}

	@Test
	public void testSetPassword() {
		String password="bho";
		Dipendente d = new Dipendente();
		d.setPassword(password);
		assertEquals(d.getPassword(),password);
	}

}
