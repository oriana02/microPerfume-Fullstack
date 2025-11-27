package com.micro.perfume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.perfume.model.Perfume;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Long> {

    List<Perfume> findByMarca(String marca);

    //buscar por nombre
    Perfume findByNombre(String nombre);

    //buscar por genero
    List<Perfume> findByGenero(String genero);

    //buscar por masVendido
    List<Perfume> findByMasVendidoTrue();

    //buscar por nuevo
    List<Perfume> findByNuevoTrue();

    //buscar por oferta
    List<Perfume> findByOfertaTrue();

    //buscar por notas
    List<Perfume> findByNotasIn(List<String> notas);

}
