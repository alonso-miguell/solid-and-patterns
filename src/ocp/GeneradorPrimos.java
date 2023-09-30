package ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//Tag can be optional
@FunctionalInterface
interface InterfazDeOrdenamiento {
	List<Integer> ordenacionMetodoInterfaz(List<Integer> lista);

}

public class GeneradorPrimos  {

	/*Usamos el tipo de interfaz como tipo de retorno para hacer la llamada a la interfaz funcional
	no es necesario apsar parametros el compilador detectara en automatico de acuerdo a nuestra expresion lambda
	a cual metodo estamos implementando
	 */
	public InterfazDeOrdenamiento ordenar(){
		return lista1 -> lista1.stream().sorted( (a,b) -> a>b?1:-1).collect(Collectors.toList());
	}

	public List<Integer> primos (int limit) {
		
		List<Integer> primos = new ArrayList<>();
		for (int i = 2; i < limit; i++) {
			if (esPrimo(i)) {
				primos.add(i);
			}
		}


		//Llamamos el metodo de nuestro tipo de interfaz declarada y accedemos al metodo que necesitamos en este caso ordenacion
		return ordenar().ordenacionMetodoInterfaz(primos);

	}

	private boolean esPrimo (int candidato) {
		for (int i = 2; i < candidato; i++) {
			if (candidato % i == 0) {
				return false;
			}
		}

		return true;
	}

}

class GeneradorHijo extends GeneradorPrimos{

	//Tag can be optional
	@Override
	public InterfazDeOrdenamiento ordenar(){
		return lista1 -> lista1.stream().sorted( (a,b) -> a>b?-1:1).collect(Collectors.toList());
	}

}
