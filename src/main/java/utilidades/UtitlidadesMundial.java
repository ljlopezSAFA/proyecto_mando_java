package utilidades;

import modelos.selecciones.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class UtitlidadesMundial {


    /**
     * Ejercicio 1
     */
    public static Map<Seleccion, List<Jugador>> crearMapa(){
        Map<Seleccion, List<Jugador>> mapa = new HashMap<>();
        for (int x = 0; x < 10; x++) {
            Seleccion seleccion = GenerarDatos.crearSelecciones(1).get(0);
            List<Jugador> jugadors = GenerarDatos.generarJugadores(11, seleccion);
            mapa.put(seleccion, jugadors);
        }
        return mapa;
    }


    /**
     * Ejercicio 2
     */
    public static  List<Jugador> getJugadoresCoincedentes(Map<Seleccion, List<Jugador>> mapa,
                                                          Pais pais, Posicion posicion){
        List<Jugador> jugadores = new ArrayList<>();

        for(Seleccion seleccion:  mapa.keySet()){
            if(seleccion.getPais().equals(pais)){
                List<Jugador> jugadoresSeleccion = mapa.get(seleccion);
                for(Jugador jugador: jugadoresSeleccion){
                    if(jugador.getPosicion().equals(posicion)){
                        jugadores.add(jugador);
                    }
                }
            }
        }
        return jugadores;
    }

    public static  List<Jugador> Simplifacado(Map<Seleccion, List<Jugador>> mapa,
                                                          Pais pais, Posicion posicion){
        List<Jugador> jugadores = new ArrayList<>();
        mapa.keySet().forEach(seleccion->{
            if(seleccion.getPais().equals(pais)){
                mapa.get(seleccion).forEach( jugador -> {
                    if(jugador.getPosicion().equals(posicion)){
                        jugadores.add(jugador);
                    }
                });
            }
        });

        return jugadores;
    }

    public static  List<Jugador> getJugadoresCoincedentesStream(Map<Seleccion, List<Jugador>> mapa,
                                                          Pais pais, Posicion posicion){
        return mapa.keySet()
                .stream()
                .filter(s -> s.getPais().equals(pais))
                .flatMap(s-> mapa.get(s).stream())
                .filter(j-> j.getPosicion().equals(posicion))
                .collect(Collectors.toList());

    }

    /**
     *
     * Ejercicio  3
     */
    public static  Map<Pais, List<Seleccion>> getSeleccionPais(Map<Seleccion, List<Jugador>> mapa){

        Map<Pais, List<Seleccion>> mapaSolucion = new HashMap<>();
        //MapaSolucion --> España -> [Selección Andaluza, Seleccion Madrid]
        //                 Francia -> [Seleccion Paris]

        //Seleccion Paris --> Francia
        for(Seleccion seleccion : mapa.keySet()){

            //MapaSolucion tiene -> Francia
            if(mapaSolucion.containsKey(seleccion.getPais())){


                mapaSolucion.get(seleccion.getPais()).add(seleccion);
            }else{

               //MapaSolucion -> Francia -> []
                mapaSolucion.put(seleccion.getPais(), new ArrayList<>());

                //MapaSolucion -> Francia -> [Seleccion Paris]
                mapaSolucion.get(seleccion.getPais()).add(seleccion);
            }
        }

        return mapaSolucion;
    }


    public static  Map<Pais, List<Seleccion>> getSeleccionPaisStream(Map<Seleccion, List<Jugador>> mapa){

        return mapa.keySet()
                .stream()
                .collect(Collectors.groupingBy(Seleccion::getPais));
    }


    /**
     * Ejercicio  4
     */
    public static Map<Continente, List<Liga>> getLigaPorContinente(Map<Seleccion, List<Jugador>> mapa) {

        // Selección Francia --> EUROPA / Francia
        // Hugo LLoris --> Premier League / Inglaterra
        // Mbape -> Ligue 1 / Francia

        // Selección Inglesa --> EUROPA / Inglaterra
        // Harry Kane --> Premier League / Inglaterra

        // Selección Brasil --> AMERICA / Brasil
        // Neymar -->  Ligue 1 / Francia
        // Vinicius --> Liga Santander / España

        // EUROPA -> [Francia , Inglaterra]
        // AMERICA ->  [Brasil]
        Map<Continente, List<Pais>> paisesPorContinente = new HashMap<>();

        //Obtenemos el Mapa de Paises Por Continente
        for (Seleccion seleccion : mapa.keySet()) {
            if (paisesPorContinente.containsKey(seleccion.getContinente())) {
                paisesPorContinente.get(seleccion.getContinente()).add(seleccion.getPais());
            } else {
                paisesPorContinente.put(seleccion.getContinente(), new ArrayList<>());
                paisesPorContinente.get(seleccion.getContinente()).add(seleccion.getPais());
            }
        }

        //EUROPA -> [] -> add(Premier League)
        //AMERICA -> []
        Map<Continente, List<Liga>> mapaSolucion = new HashMap<>();
        paisesPorContinente.keySet().forEach(continente -> mapaSolucion.put(continente, new ArrayList<>()));


        // Selección Francia --> EUROPA / Francia
        // Hugo LLoris --> Premier League / Inglaterra
        // Mbape -> Ligue 1 / Francia


        for (Seleccion seleccion : mapa.keySet()) {

            // Hugo LLoris --> Premier League / Inglaterra
            for (Jugador jugador : mapa.get(seleccion)) {

                //Saber la liga del jugador
                // Premier League / Inglaterra
                Liga liga = jugador.getLiga();


                // EUROPA -> [Francia , Inglaterra]
                // AMERICA ->  [Brasil]

                // EUROPA -> [Francia , Inglaterra]
                for (Continente continente : paisesPorContinente.keySet()) {

                    // EUROPA -> [Francia , Inglaterra]-> contine (Inglaterra)
                    if (paisesPorContinente.get(continente).contains(liga.getPais())) {

                        //EUROPA -> [] -> add(Premier League)
                        mapaSolucion.get(continente).add(liga);
                    }
                }
            }
        }


        return mapaSolucion;


    }





    /**
     *
     * Método Main para probar los métodos
     *
     * @param args
     */

    public static void main(String[] args) {
        Map<Seleccion , List<Jugador>> mapa = crearMapa();
        mapa.keySet().forEach(k-> System.out.println(k.getNombre() + "--> " + mapa.get(k).stream().map(Jugador::getNombre).toList()));

        getLigaPorContinente(mapa);
    }



}
