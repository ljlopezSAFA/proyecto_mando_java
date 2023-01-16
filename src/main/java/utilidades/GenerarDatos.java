package utilidades;

import com.github.javafaker.Faker;
import modelos.Mando;
import modelos.Tecla;
import modelos.TipoMando;
import modelos.TipoTecla;

import java.util.ArrayList;
import java.util.List;

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

            int numeroAleatorio = faker.number().numberBetween(1, 15);
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



}
