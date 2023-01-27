package modelos;

import lombok.*;

import java.util.List;


@Data
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



}
