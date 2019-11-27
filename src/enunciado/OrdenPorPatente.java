package enunciado;

import java.util.Comparator;

public class OrdenPorPatente implements Comparator<Vehiculo>{

	@Override
	public int compare(Vehiculo arg0, Vehiculo arg1) {
		return arg0.getPatente().compareTo(arg1.getPatente());
	}
	
	

}
