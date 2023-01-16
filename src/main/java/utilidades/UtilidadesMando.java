package utilidades;

import modelos.Mando;
import modelos.Tecla;
import modelos.TipoTecla;

public class UtilidadesMando {



    //Cuente el número de teclas que tiene un mando
    public Integer calcularNumeroTeclasMando(Mando mando){
        return  mando.getTeclas().size();
    }


    //Metodo que recibe un mando y el tipo de tecla que queremos contar y nos devuelve el número de teclas del tipo
    public static Integer calcularNumeroDeTeclasPorTipo(Mando mando , TipoTecla tipoTecla){

        Integer numTeclas = 0;

        //Recorrer las teclas del mando
        for(Tecla tecla: mando.getTeclas()){

            if(tecla.getTipoTecla().equals(tipoTecla)){
                numTeclas++;
            }

        }
        return  numTeclas;
    }

    public Integer calcularNumeroDeTeclasPorTipo2(Mando mando , TipoTecla tipoTecla){

        return mando.getTeclas().stream().filter(t -> t.getTipoTecla().equals(tipoTecla)).toList().size();

    }














}
