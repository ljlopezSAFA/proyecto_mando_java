package modelos.selecciones;

import java.util.Objects;

public class Liga {

    private String nombre;
    private Pais pais;

    public Liga() {
    }

    public Liga(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        Liga liga = (Liga) o;
        return Objects.equals(nombre, liga.nombre) && Objects.equals(pais, liga.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pais);
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nombre='" + nombre + '\'' +
                ", pais=" + pais +
                '}';
    }
}
