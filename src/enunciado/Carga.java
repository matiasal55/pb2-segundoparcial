package enunciado;

public class Carga {

	private String descripcion;
	private Integer peso;

	public Carga(String descripcion, Integer peso) {

		this.descripcion = descripcion;
		this.peso = peso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

}
