package tomasVilla.dds.cases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tomasVilla.dds.entities.Articulo;
import tomasVilla.dds.entities.Compra;
import tomasVilla.dds.entities.Remito;
import tomasVilla.dds.entities.Servicio;
import tomasVilla.dds.exceptions.ErrorGenerarRemito;

public class Tp0TestCase {
	
	Compra compra1, compra2;
	Articulo articulo1, articulo2;
	Servicio servicio1;


	@Before
	public void setUp(){
		compra1 = new Compra();
		compra2 = new Compra();
		
		articulo1 = new Articulo();
		articulo2 = new Articulo();
		
		servicio1 = new Servicio();
		
		articulo1.setDescripcion("Pelota");
		articulo1.setValor(250);
		
		articulo2.setDescripcion("Botines");
		articulo2.setValor(1000);
		
		compra1.agregarItem(articulo1);
		compra1.agregarItem(articulo2);
		
		servicio1.setDescripcion("Cuota");
		servicio1.setValor(150);
		
		compra2.agregarItem(articulo1);
		compra2.agregarItem(servicio1);
		
	}

	@After
	public void tearDown() throws Exception {
		compra1 = null;
		compra2 = null;
	}

	@Test
	public void testGenerarRemitoCompra1() {
		Remito remito = new Remito();
		try {
			remito = compra1.generarRemito();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(1, remito.getTipo());
		assertEquals(2222, remito.getNumero());
		
	}
	
	@Test
	public void testCalcularValorCompra1() {
		assertEquals(1250, compra1.calcularValor());
	}
	
	@Test(expected = ErrorGenerarRemito.class)
	public void testGenerarRemitoCompra2() throws Exception{
		Remito remito = new Remito();
				
		try {
			remito = compra2.generarRemito();
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Test
	public void testCalcularValorCompra2() {
		assertEquals(400, compra2.calcularValor());
	}

}
