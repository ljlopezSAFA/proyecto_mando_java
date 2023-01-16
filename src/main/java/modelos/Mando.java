package modelos;

import java.util.List;
import java.util.Objects;

public class Mando {

    //---------Atributos----------------
    private String color;
    private String forma;
    private String marca;
    private Integer numBotones;
    private Boolean tienePilas;
    private Boolean tienePanelTactil;
    private TipoMando tipo;
    private List<Tecla> teclas;


    public Mando(String color, String forma, String marca, Integer numBotones, Boolean tienePilas, Boolean tienePanelTactil, TipoMando tipo, List<Tecla> teclas) {
        this.color = color;
        this.forma = forma;
        this.marca = marca;
        this.numBotones = numBotones;
        this.tienePilas = tienePilas;
        this.tienePanelTactil = tienePanelTactil;
        this.tipo = tipo;
        this.teclas = teclas;
    }

    public Mando(String color, String forma, String marca, TipoMando tipo){
        this.color = color;
        this.forma = forma;
        this.marca = marca;
        this.tipo = tipo;
    }

    public Mando() {

    }

    public String getColor(){
        return  this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getNumBotones() {
        return numBotones;
    }

    public void setNumBotones(Integer numBotones) {
        this.numBotones = numBotones;
    }

    public Boolean getTienePilas() {
        return tienePilas;
    }

    public void setTienePilas(Boolean tienePilas) {
        this.tienePilas = tienePilas;
    }

    public Boolean getTienePanelTactil() {
        return tienePanelTactil;
    }

    public void setTienePanelTactil(Boolean tienePanelTactil) {
        this.tienePanelTactil = tienePanelTactil;
    }

    public TipoMando getTipo() {
        return tipo;
    }

    public void setTipo(TipoMando tipo) {
        this.tipo = tipo;
    }

    public List<Tecla> getTeclas() {
        return teclas;
    }

    public void setTeclas(List<Tecla> teclas) {
        this.teclas = teclas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mando mando = (Mando) o;
        return Objects.equals(color, mando.color) &&
                Objects.equals(forma, mando.forma) &&
                Objects.equals(marca, mando.marca) &&
                Objects.equals(numBotones, mando.numBotones) &&
                Objects.equals(tienePilas, mando.tienePilas) &&
                Objects.equals(tienePanelTactil, mando.tienePanelTactil) && tipo == mando.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, forma, marca, numBotones, tienePilas, tienePanelTactil, tipo);
    }

    @Override
    public String toString() {
        return "Mando{" +
                "color='" + color + '\'' +
                ", forma='" + forma + '\'' +
                ", marca='" + marca + '\'' +
                ", numBotones=" + numBotones +
                ", tienePilas=" + tienePilas +
                ", tienePanelTactil=" + tienePanelTactil +
                ", tipo=" + tipo +
                '}';
    }
}
