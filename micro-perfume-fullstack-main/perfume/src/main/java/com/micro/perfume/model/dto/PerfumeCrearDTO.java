package com.micro.perfume.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfumeCrearDTO {
    private String nombre;
    private String marca;
    private Integer precio;
    private String imagen;
    private String genero;
    private List<String> notas;
    private String descripcion;
    private boolean masVendido;
    private boolean nuevo;
    private boolean oferta;
}
