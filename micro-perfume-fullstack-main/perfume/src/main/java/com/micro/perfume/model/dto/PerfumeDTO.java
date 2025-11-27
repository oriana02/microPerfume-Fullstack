package com.micro.perfume.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerfumeDTO {

    private Long productoId;
    private String nombre;
    private String marca;
    private Integer precio;
    //private Boolean masVendido;
    //private Boolean nuevo;
    //private Boolean oferta;
}
