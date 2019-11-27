package enunciado;

import enunciado.Carga;
import enunciado.SobrepesoException;
import enunciado.Vehiculo;
import enunciado.VehiculoNotFoundException;

public class Camioneta extends Vehiculo {

	private Integer modelo;

	public Camioneta(String patente, String nombreTitular, String apellidoTitular, Integer pesoMaximo, Integer modelo) {
		super(patente, nombreTitular, apellidoTitular, pesoMaximo);

		this.modelo = modelo;
	}

	/*
	 * Agrega Una carga a la camioneta . En caso que que la carga a cargar supere el
	 * peso maximo retorna una excepcion SobrepesoException
	 */
	@Override
	public Boolean agregarCarga(Carga carga) throws SobrepesoException {
		Integer pesoCargado = obtenerPesoCargado();

		if (pesoCargado + carga.getPeso() <= getPesoMaximo()) {

			super.getCargas().add(carga);
			return true;
		}

		throw new SobrepesoException();
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

}
