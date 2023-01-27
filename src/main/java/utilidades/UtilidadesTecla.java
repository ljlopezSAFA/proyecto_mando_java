package utilidades;

import modelos.Tecla;
import modelos.TipoTecla;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesTecla {


    public static Map<TipoTecla, List<Tecla>> agruparTeclasPorTipo(List<Tecla> teclas){

        Map<TipoTecla, List<Tecla>> mapa = new HashMap<>();
        mapa.put(TipoTecla.REDONDA, new ArrayList<>());
        mapa.put(TipoTecla.ON_OFF, new ArrayList<>());
        mapa.put(TipoTecla.CONTROL, new ArrayList<>());
        mapa.put(TipoTecla.CUADRADA, new ArrayList<>());
        mapa.put(TipoTecla.TRIANGULAR, new ArrayList<>());

        for(Tecla tecla : teclas){

            if(tecla.getTipoTecla().equals(TipoTecla.REDONDA)){
                mapa.get(TipoTecla.REDONDA).add(tecla);
            }else if(tecla.getTipoTecla().equals(TipoTecla.ON_OFF)){
                mapa.get(TipoTecla.ON_OFF).add(tecla);
            }else if(tecla.getTipoTecla().equals(TipoTecla.CONTROL)){
                mapa.get(TipoTecla.CONTROL).add(tecla);
            }else if(tecla.getTipoTecla().equals(TipoTecla.CUADRADA)){
                mapa.get(TipoTecla.CUADRADA).add(tecla);
            }else if(tecla.getTipoTecla().equals(TipoTecla.TRIANGULAR)){
                mapa.get(TipoTecla.TRIANGULAR).add(tecla);
            }

        }

        return mapa;

    }



    public static Map<TipoTecla, List<Tecla>> agruparTeclasPorTipoSwitch(List<Tecla> teclas){

        Map<TipoTecla, List<Tecla>> mapa = new HashMap<>();
        mapa.put(TipoTecla.REDONDA, new ArrayList<>());
        mapa.put(TipoTecla.ON_OFF, new ArrayList<>());
        mapa.put(TipoTecla.CONTROL, new ArrayList<>());
        mapa.put(TipoTecla.CUADRADA, new ArrayList<>());
        mapa.put(TipoTecla.TRIANGULAR, new ArrayList<>());

        for(Tecla tecla : teclas){

            switch (tecla.getTipoTecla()){
                case ON_OFF -> mapa.get(TipoTecla.ON_OFF).add(tecla);
                case REDONDA -> mapa.get(TipoTecla.REDONDA).add(tecla);
                case CONTROL -> mapa.get(TipoTecla.CONTROL).add(tecla);
                case CUADRADA -> mapa.get(TipoTecla.CUADRADA).add(tecla);
                case TRIANGULAR -> mapa.get(TipoTecla.TRIANGULAR).add(tecla);
            }

        }

        return mapa;

    }


    public static Map<TipoTecla, List<Tecla>> agruparTeclasPorTipoReducido(List<Tecla> teclas, List<TipoTecla> tipoTeclas ){

        Map<TipoTecla, List<Tecla>> mapa = new HashMap<>();

        //Recorrer los valores del enumerado como lista y añadirlo como claves al mapa
        for(TipoTecla tipo : tipoTeclas){
            mapa.put(tipo,new ArrayList<>());
        }

        for(Tecla tecla : teclas){
            if(tipoTeclas.contains(tecla.getTipoTecla())){
                mapa.get(tecla.getTipoTecla()).add(tecla);
            }
        }

        return mapa;

    }

    public static Map<TipoTecla, List<Tecla>> agruparTeclasPorTipoStream(List<Tecla> teclas, List<TipoTecla> tipoTeclas){

        return teclas.stream().filter(t-> tipoTeclas.contains(t.getTipoTecla())).collect(Collectors.groupingBy(t-> t.getTipoTecla()));

    }



    public static void main(String[] args) {

        List<Tecla> teclas = GenerarDatos.generarMandoAleatorio(1).get(0).getTeclas();

        System.out.println(agruparTeclasPorTipoSwitch(teclas));
    }


}
