package modelos.selecciones;

import java.time.LocalDate;
import java.util.Objects;

public class Jugador {

    private String nombre;
    private LocalDate fechaNacimiento;
    private Posicion posicion;
    private Liga liga ;

    public Jugador(String nombre, LocalDate fechaNacimiento, Posicion posicion, Liga liga) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.posicion = posicion;
        this.liga = liga;
    }

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(nombre, jugador.nombre) && Objects.equals(fechaNacimiento, jugador.fechaNacimiento) && posicion == jugador.posicion && Objects.equals(liga, jugador.liga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaNacimiento, posicion, liga);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", posicion=" + posicion +
                ", liga=" + liga +
                '}';
    }
}
