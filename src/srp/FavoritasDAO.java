package srp;

import java.util.ArrayList;
import java.util.List;

public class FavoritasDAO {

    public static List<Pelicula> getRecomendaciones(Cliente cliente){
        List<Pelicula> recomendadas=new ArrayList<>();
        for (Pelicula favorita: cliente.getFavoritas()) {
            recomendadas.addAll(BBDD.PELIS_POR_DIRECTOR.get(favorita.getDirector()));
        }
        recomendadas.removeAll(cliente.getFavoritas());

        return recomendadas;
    }
}
