package srp;

import java.util.List;
import java.util.stream.Collectors;

public class Recomendador {

	public List<Pelicula> recomendaciones (Cliente cliente) {
		
		List<Pelicula> recomendadas = FavoritasDAO.getRecomendaciones(cliente);

		return recomendadas;
	}
	
	public String recomendacionesCSV (Cliente cliente) {
		
		return recomendaciones(cliente).stream()
		      .map(p -> (p.getTitulo() + "," + p.getDirector() + "," + p.getGenero()))
		      .collect(Collectors.joining("\n"));
	}
}
