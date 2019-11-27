package enunciado;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class Vehiculo {
	private String patente;
	private String apellidoTitular;
	private String nombreTitular;
	private List<Carga> cargas;
	private Integer pesoMaximo;

	public Vehiculo(String patente, String nombreTitular, String apellidoTitular, Integer pesoMaximo) {
		this.patente = patente;
		this.apellidoTitular = apellidoTitular;
		this.nombreTitular = nombreTitular;
		this.pesoMaximo = pesoMaximo;
		this.cargas = new ArrayList<>();
	}

	public abstract Boolean agregarCarga(Carga carga) throws SobrepesoException;

	public String getApellidoTitular() {
		return apellidoTitular;
	}

	public void setApellidoTitular(String apellidoTitular) {
		this.apellidoTitular = apellidoTitular;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	/*
	 * Obtiene el peso de lo cargado actualmente en el vehiculo
	 */
	public Integer obtenerPesoCargado() {
		Integer pesoTotal = 0;
		for (Carga lista : this.cargas)
			pesoTotal += lista.getPeso();
		return pesoTotal;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Integer getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(Integer pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public List<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", apellidoTitular=" + apellidoTitular + ", nombreTitular="
				+ nombreTitular + ", cargas=" + cargas + ", pesoMaximo=" + pesoMaximo + "]";
	}
	
	

}
