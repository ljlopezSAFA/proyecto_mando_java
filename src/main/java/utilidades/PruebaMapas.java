package utilidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PruebaMapas {

    public static void main(String[] args) {


        //Crear mapas
        Map<String, Integer> puntuacionesDulces = new HashMap<>();

        //Insertar valores en un mapa
        puntuacionesDulces.put("Donuts", 6);
        puntuacionesDulces.put("Palmera", 8);
        puntuacionesDulces.put("Napolitana", 9);
        puntuacionesDulces.put("Gofre", 10);

        //Modificar elementos
        puntuacionesDulces.replace("Donuts", 7);


        //Eliminar elementos
        puntuacionesDulces.remove("Gofre");

        //Tamaño de un mapa
        System.out.println(puntuacionesDulces.size());


        //Obtener valor para un clave
        Integer puntuacionDonut = puntuacionesDulces.get("Donuts");


        //Saber si un mapa contiene un elemento
        System.out.println(puntuacionesDulces.containsKey("Donuts"));
        System.out.println(puntuacionesDulces.containsValue(10));

        List<String> sabores = List.of("Chocolate", "Huevo", "Kit Kat");


        sabores.forEach(System.out::println);

        for(String sabor : sabores){
            System.out.println(sabor);
        }


        System.out.println(puntuacionesDulces);

        puntuacionesDulces.forEach((dulce, puntuacion) -> System.out.println(dulce));



    }

}
