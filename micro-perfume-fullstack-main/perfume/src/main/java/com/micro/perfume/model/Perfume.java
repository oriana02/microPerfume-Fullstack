package com.micro.perfume.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "perfumes")
public class Perfume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;
    
    private String nombre;
    private String marca;
    private Integer precio;
    private String imagen;
    private String genero;

    @ElementCollection
    @CollectionTable(name = "perfume_notas", joinColumns = @JoinColumn(name = "perfume_id"))
    @Column(name = "nota")
    private List<String> notas;

    @Column(length = 1000)
    private String descripcion;

    private boolean masVendido;
    private boolean nuevo;
    private boolean oferta;

}
