package enunciado;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;


public class TestFletes {
	
	Vehiculo camioneta1=new Camioneta("MAZ885", "Matias", "Alarcon", 200, 1);
	Vehiculo camioneta2=new Camioneta("DSS254", "Lautaro", "Funes", 200, 2);
	Vehiculo camioneta3=new Camioneta("MAZ885", "Matias", "Alarcon", 200, 1);
	AgenciaFlete miAgencia=new AgenciaFlete();
	OrdenPorPatente orden=new OrdenPorPatente();
	Vehiculo camion1=new Camion("FDA432", "Damian", "Baran", 5000, false);
	Carga carga1=new Carga("Motores", 6000);
	Carga carga2=new Carga("Galletitas",60);
	Carga carga3=new Carga("Snacks",60);
	Carga carga4=new Carga("Muebles", 3000);
	
	@Test
	public void testQueAgregoUnaCargaCamioneta() {
		miAgencia.agregarVehiculo(camioneta1);
		try {
			assertTrue(camioneta1.agregarCarga(carga2));
		} catch (SobrepesoException e) {
			e.printStackTrace();
		}	
	}
	
	@Test (expected=SobrepesoException.class)
	public void testQueNoAgregoUnaCargaCamionPorSobrepeso() throws SobrepesoException {
		miAgencia.agregarVehiculo(camion1);
		camion1.agregarCarga(carga1);
	}
	@Test
	public void testQueTransfieraUnaCargaDeUnVehiculoAOtro() throws SobrepesoException, VehiculoNotFoundException {
		miAgencia.agregarVehiculo(camioneta1);
		miAgencia.agregarVehiculo(camioneta2);
		camioneta1.agregarCarga(carga2);
		camioneta2.agregarCarga(carga3);
		assertTrue(miAgencia.moverCarcaDeUnVehiculoAOtro(camioneta1.getPatente(), camioneta2.getPatente()));	
	}
	@Test (expected=SobrepesoException.class)
	public void testQueNoPermitaTransfieraUnaCargaAUnVehiculoDestinoPorNooportarElPesoDeLasCargas()
			throws SobrepesoException, VehiculoNotFoundException {
		miAgencia.agregarVehiculo(camioneta1);
		miAgencia.agregarVehiculo(camioneta2);
		camioneta1.agregarCarga(carga2);
		camioneta2.agregarCarga(carga4);
		miAgencia.moverCarcaDeUnVehiculoAOtro(camioneta1.getPatente(), camioneta2.getPatente());
	}
	@Test
	public void testQueObtieneUnaListaOrdenadaPorPatentes() throws SobrepesoException {
		miAgencia.agregarVehiculo(camion1);
		miAgencia.agregarVehiculo(camioneta1);
		miAgencia.agregarVehiculo(camioneta2);
		Set<Vehiculo> listaOrdenadaEsperada=new TreeSet<>(orden);
		listaOrdenadaEsperada.add(camion1);
		listaOrdenadaEsperada.add(camioneta1);
		listaOrdenadaEsperada.add(camioneta2);
		Set<Vehiculo> listaOrdenadaObtenida=miAgencia.obtenerListaOrdenada(orden);
		assertEquals(listaOrdenadaEsperada, listaOrdenadaObtenida);
	}
}
