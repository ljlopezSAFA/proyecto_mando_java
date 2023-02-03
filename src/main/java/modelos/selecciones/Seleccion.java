package modelos.selecciones;

import java.util.Objects;

public class Seleccion {

    private String nombre;
    private Continente continente;
    private Pais pais;

    public Seleccion(String nombre, Continente continente, Pais pais) {
        this.nombre = nombre;
        this.continente = continente;
        this.pais = pais;
    }

    public Seleccion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seleccion seleccion = (Seleccion) o;
        return Objects.equals(nombre, seleccion.nombre) && continente == seleccion.continente && Objects.equals(pais, seleccion.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, continente, pais);
    }

    @Override
    public String toString() {
        return "Seleccion{" +
                "nombre='" + nombre + '\'' +
                ", continente=" + continente +
                ", pais=" + pais +
                '}';
    }
}
