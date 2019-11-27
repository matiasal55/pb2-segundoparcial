package enunciado;

public class VehiculoNotFoundException extends Exception {
	public VehiculoNotFoundException() {
		super("El vehiculo no fue encontrado");
	}
}
