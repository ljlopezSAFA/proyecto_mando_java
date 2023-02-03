package utilidades;

import com.github.javafaker.Faker;
import modelos.Mando;
import modelos.Tecla;
import modelos.TipoMando;
import modelos.TipoTecla;
import modelos.selecciones.*;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GenerarDatos {

    private static Faker faker = new Faker();


    public static List<Mando> generarMandoAleatorio(int numMandos){

        List<Mando> mandoList = new ArrayList<>();

        for(int i = 0 ; i < numMandos; i++) {

            Mando mando = new Mando();
            mando.setColor(faker.color().name());
            mando.setForma(faker.animal().name());
            mando.setMarca(faker.beer().name());
            mando.setNumBotones(faker.number().numberBetween(5, 50));
            mando.setTienePanelTactil(faker.bool().bool());
            mando.setTipo(TipoMando.values()[faker.number().numberBetween(0, 5)]);
            mando.setTienePilas(faker.bool().bool());
            mando.setTeclas(new ArrayList<>());

            int numeroAleatorio = faker.number().numberBetween(10, 20);
            for (int x = 0; x < numeroAleatorio; x++) {

                Tecla tecla = new Tecla();
                tecla.setSimbolo(faker.music().instrument());
                tecla.setFuncion(faker.chuckNorris().fact());
                tecla.setPosicion(faker.number().numberBetween(5, 50));
                tecla.setTipoTecla(TipoTecla.values()[faker.number().numberBetween(0, 4)]);
                mando.getTeclas().add(tecla);

            }

            mandoList.add(mando);
        }

        return mandoList;
    }


    public static List<Seleccion> crearSelecciones(int num){

        List<Seleccion> selecciones = new ArrayList<>();

        for (int x = 0; x < num; x++) {
            Seleccion seleccion = new Seleccion();
            String country = faker.nation().nationality();
            seleccion.setContinente(Continente.values()[faker.number().numberBetween(0, 4)]);
            seleccion.setNombre(country);
            seleccion.setPais(new Pais(country));
            selecciones.add(seleccion);
        }

        return selecciones;

    }



    public static List<Jugador> generarJugadores(int num, Seleccion seleccion){

        List<Jugador> jugadores = new ArrayList<>();

        for(int x = 0; x < num; x++) {
            Jugador jugador = new Jugador();
            String nation = faker.nation().capitalCity();
            jugador.setNombre(faker.funnyName().name());
            jugador.setPosicion(Posicion.values()[faker.number().numberBetween(0, 3)]);
            jugador.setFechaNacimiento(faker.date().past(5000, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            jugador.setLiga(new Liga(nation, new Pais(seleccion.getPais().getNombre())));
            jugadores.add(jugador);
        }

        return jugadores;
    }



}
