package utilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class EjerciciosMapas {

    public static void main(String[] args) {


        //EJE1
        Map<String, Integer> selecciones = new HashMap<>();
        selecciones.put("España", 2);
        selecciones.put("Brasil", 5);
        selecciones.put("Alemania", 4);
        selecciones.put("Francia", 2);


        //EJE2
        Map<String, List<String>> seleccionesConJugadores = new HashMap<>();
        seleccionesConJugadores.put("España",new ArrayList<>(List.of("Puyol", "Casillas")));
        seleccionesConJugadores.put("Alemania", List.of("Kross", "Muller", "Gotze"));
        seleccionesConJugadores.put("Brasil", List.of("Ronaldo", "Roberto Carlos", "Cafú"));
        seleccionesConJugadores.put("Francia", List.of("Zidane", "Blanc", "Cantona"));

        //EJE3
        int totalmundiales = 0;
        for(Integer mundialesporseleccion : selecciones.values()){
            totalmundiales += mundialesporseleccion;
        }

        System.out.println(selecciones.values().stream().mapToInt(num-> num).sum());
        System.out.println(totalmundiales);

        //EJE4
        Map<String, Integer> seleccionesNumJugadores = new HashMap<>();
        for(String seleccion : seleccionesConJugadores.keySet()){
            seleccionesNumJugadores.put(seleccion, seleccionesConJugadores.get(seleccion).size());
        }


        //EJE5
        Map<String , Map<String, List<String>>> mapaGrande = new HashMap<>();

        // new HashMap<>(Map.of("España", Map.of("DEL", List.of("Torres", "Villa")), ""));

        //España
        Map<String, List<String>> jugadoresEspanya = new HashMap<>();
        jugadoresEspanya.put("DEL", List.of("Torres", "Villa"));
        jugadoresEspanya.put("MC", List.of("Silva", "Fabregas", "Xavi"));
        jugadoresEspanya.put("DEF", List.of("Ramos", "Pique"));
        jugadoresEspanya.put("POR", List.of("Casillas"));

        //Brasil
        Map<String, List<String>> jugadoresBrasil = new HashMap<>();
        jugadoresBrasil.put("DEL", List.of("Ronaldo", "Ronaldinho"));
        jugadoresBrasil.put("MC", List.of("Kaká"));
        jugadoresBrasil.put("DEF", List.of("Roberto Carlos", "Cafú"));
        jugadoresBrasil.put("POR", List.of("Ederson"));

        mapaGrande.put("España", jugadoresEspanya);
        mapaGrande.put("Brasil", jugadoresBrasil);


        //EJE6
        for(String pais : mapaGrande.keySet()){
            System.out.println("------------" + pais + "-----------");
            for(String posicion: mapaGrande.get(pais).keySet()){
                System.out.println("***" + posicion + "***");
                System.out.println("número de jugadores -->" + mapaGrande.get(pais).get(posicion).size());
            }
        }

        //EJE7
        for(String pais : mapaGrande.keySet()){
            System.out.println("------------" + pais + "-----------");
            int totalJugadores = 0;
            for(String posicion: mapaGrande.get(pais).keySet()){
                totalJugadores +=  mapaGrande.get(pais).get(posicion).size();
            }
            System.out.println("Número total de jugadores --> " + totalJugadores);


        }














    }







}
