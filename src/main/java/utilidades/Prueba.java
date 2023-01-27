package utilidades;

import modelos.Mando;
import modelos.TipoTecla;

import java.util.List;

public class Prueba {


    public static void main(String[] args) {

        List<Mando> mandoList = GenerarDatos.generarMandoAleatorio(1);

        int numTeclas = UtilidadesMando.calcularNumeroDeTeclasPorTipo(mandoList.get(0), TipoTecla.ON_OFF);

        System.out.println(numTeclas);


        Mando mando = new Mando();




    }
}
