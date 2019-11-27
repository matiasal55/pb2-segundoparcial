package enunciado;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import enunciado.Vehiculo;
import enunciado.VehiculoNotFoundException;

public class AgenciaFlete {
	private Set<Vehiculo> flota;

	public AgenciaFlete() {
		this.flota = new HashSet<>();
	}

// Agrega Un veiculo a la flota
	public Boolean agregarVehiculo(Vehiculo vehiculo) {
		this.flota.add(vehiculo);
		return true;
	}

	// * Busca Un vehiculo por patente y si no lo encuentra devuelve
	// VehiculoNotFoundException
	public Vehiculo buscarVehiculo(String patente) throws VehiculoNotFoundException {
		for (Vehiculo lista : this.flota) {
			if (lista.getPatente().equals(patente))
				return lista;
		}
		throw new VehiculoNotFoundException();

	}

	public void descargarCargasVehiculo(String patente) throws VehiculoNotFoundException {
		Vehiculo vehiculo = this.buscarVehiculo(patente);
		if (!vehiculo.equals(null))
			vehiculo.getCargas().clear();
		else
			throw new VehiculoNotFoundException();

	}

	// Transfiere todas las carga de un vehiculo
	public Boolean moverCarcaDeUnVehiculoAOtro(String patenteOrigen, String patenteDestino)
			throws VehiculoNotFoundException, SobrepesoException {
		Vehiculo vehiculoOrigen = buscarVehiculo(patenteOrigen);
		Vehiculo vehiculoDestino = buscarVehiculo(patenteDestino);
		if (!(vehiculoOrigen.equals(null)) && !(vehiculoDestino.equals(null))) {
			Integer pesoDeOrigen = vehiculoOrigen.obtenerPesoCargado();
			Integer pesoDeDestino = vehiculoDestino.obtenerPesoCargado();
			if (pesoDeOrigen+pesoDeDestino <= vehiculoDestino.getPesoMaximo()) {
				List<Carga> cargaParaDestino = vehiculoOrigen.getCargas();
				List<Carga> cargaDeDestino = vehiculoDestino.getCargas();
				descargarCargasVehiculo(patenteOrigen);
				for(Carga cargar: cargaParaDestino)
					cargaDeDestino.add(cargar);
				return true;
			}
			throw new SobrepesoException();
		}
		throw new VehiculoNotFoundException();
	}

	// Devuelve una lista ordenada de los vehiculos. No modifica la lista Existente
	public TreeSet<Vehiculo> obtenerListaOrdenada(Comparator<Vehiculo> orden) {
		Set<Vehiculo> listaOrdenada = new TreeSet<>(orden);
		listaOrdenada.addAll(this.flota);
		return (TreeSet<Vehiculo>) listaOrdenada;
	}

}
