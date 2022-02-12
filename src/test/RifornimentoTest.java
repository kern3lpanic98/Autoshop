package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Client;
import model.Dipendente;
import model.Rifornimento;

public class RifornimentoTest {

	@Test
	public void testRifornimento() {
		String marca="Mercedes";
		String tipo = "filtro olio";
		String data_richiesta = "2022-01-010";
		String data_consegna = "2022-02-01";
		int numPezzi =10;
		String userDip = "Francesco";
	Rifornimento r = new Rifornimento(marca,tipo,data_richiesta, data_consegna,numPezzi,userDip);
	
		assertEquals(r.getMarca(),marca);
		assertEquals(r.getTipo(),tipo);
		assertEquals(r.getDataRichiesta(),data_richiesta);
		assertEquals(r.getDataConsegna(),data_consegna);
		assertEquals(r.getNumeroPezzi(),numPezzi);
		assertEquals(r.getUserDip(),userDip);
	
	}

	@Test
	public void testSetMarca() {
		String marca="Mercedes";
		Rifornimento r = new Rifornimento();
		r.setMarca(marca);
		assertEquals(r.getMarca(),marca);
	}

	@Test
	public void testSetTipo() {
		String tipo="Filtro olio";
		Rifornimento r = new Rifornimento();
		r.setTipo(tipo);
		assertEquals(r.getTipo(),tipo);
	}

	@Test
	public void testSetDataRichiesta() {
		String dataRichiesta="2022-01-01";
		Rifornimento r = new Rifornimento();
		r.setDataRichiesta(dataRichiesta);
		assertEquals(r.getDataRichiesta(),dataRichiesta);
	}

	@Test
	public void testSetDataConsegna() {
		String dataConsegna="2022-02-01";
		Rifornimento r = new Rifornimento();
		r.setDataConsegna(dataConsegna);
		assertEquals(r.getDataConsegna(),dataConsegna);
	}

	@Test
	public void testSetNumeroPezzi() {
		int num_pezzi=10;
		Rifornimento r = new Rifornimento();
		r.setNumeroPezzi(num_pezzi);
		assertEquals(r.getNumeroPezzi(),num_pezzi);
	}

	@Test
	public void testSetUserDip() {
		String userDip="Mario";
		Rifornimento r = new Rifornimento();
		r.setUserDip(userDip);
		assertEquals(r.getUserDip(),userDip);
	}

}
