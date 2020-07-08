package utilidades;

import java.util.ArrayList;

public class PromedioServicio {

	public static Float promedioServicioImp(ArrayList<Float> notas ) {
		
		float suma = notas.stream().reduce((a,b) -> a.floatValue()+b.floatValue()).get();
		//System.out.println(suma/notas.size());
		return suma/notas.size();
	}
}
