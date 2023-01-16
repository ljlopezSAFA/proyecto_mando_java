package modelos;

import java.util.Objects;

public class Tecla {

    private String simbolo;
    private Integer posicion;
    private TipoTecla tipoTecla;
    private String funcion;



    public Tecla(String simbolo, Integer posicion, TipoTecla tipoTecla, String funcion) {
        this.simbolo = simbolo;
        this.posicion = posicion;
        this.tipoTecla = tipoTecla;
        this.funcion = funcion;
    }

    public Tecla() {
    }


    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public TipoTecla getTipoTecla() {
        return tipoTecla;
    }

    public void setTipoTecla(TipoTecla tipoTecla) {
        this.tipoTecla = tipoTecla;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tecla tecla = (Tecla) o;
        return Objects.equals(simbolo, tecla.simbolo) && Objects.equals(posicion, tecla.posicion) && tipoTecla == tecla.tipoTecla && Objects.equals(funcion, tecla.funcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simbolo, posicion, tipoTecla, funcion);
    }

    @Override
    public String toString() {
        return "Tecla{" +
                "simbolo='" + simbolo + '\'' +
                ", posicion=" + posicion +
                ", tipoTecla=" + tipoTecla +
                ", funcion='" + funcion + '\'' +
                '}';
    }
}
