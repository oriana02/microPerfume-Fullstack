package com.micro.perfume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import com.micro.perfume.model.Perfume;
import com.micro.perfume.service.PerfumeService;
import com.micro.perfume.model.dto.PerfumeCrearDTO;

@RestController
@RequestMapping("/api/perfumes")
@CrossOrigin(origins = "*")
public class PerfumeController {

    @Autowired
    private PerfumeService perfumeService;

    @GetMapping
    @Operation(summary = "Obtener todos los perfumes")
    public List<Perfume> obtenerTodos() {
        return perfumeService.obtenerTodos();
    }

    @GetMapping("/{productoId}")
    @Operation(summary = "Obtener un perfume por ID")
    public ResponseEntity<Perfume> obtenerPorId(@PathVariable Long productoId) {
        Perfume perfume = perfumeService.obtenerPorId(productoId);
        return perfume != null ? ResponseEntity.ok(perfume) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo perfume")
    public Perfume crearPerfume(@RequestBody PerfumeCrearDTO dto) {
        return perfumeService.crearPerfume(dto);
    }

    @PutMapping("/{productoId}")
    @Operation(summary = "Actualizar un perfume existente")
    public ResponseEntity<Perfume> actualizar(
            @PathVariable Long productoId,
            @RequestBody Perfume perfume) {

        Perfume actualizado = perfumeService.actualizarPerfume(productoId, perfume);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{productoId}")
    @Operation(summary = "Eliminar un perfume por ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long productoId) {
        perfumeService.eliminarPerfume(productoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/marca/{marca}")
    @Operation(summary = "Buscar perfumes por marca")
    public List<Perfume> porMarca(@PathVariable String marca) {
        return perfumeService.obtenerPorMarca(marca);
    }

    @GetMapping("/genero/{genero}")
    @Operation(summary = "Buscar perfumes por género")
    public List<Perfume> porGenero(@PathVariable String genero) {
        return perfumeService.obtenerPorGenero(genero);
    }

    @GetMapping("/mas-vendidos")
    @Operation(summary = "Perfumes más vendidos")
    public List<Perfume> masVendidos() {
        return perfumeService.obtenerMasVendidos();
    }

    @GetMapping("/nuevos")
    @Operation(summary = "Perfumes nuevos")
    public List<Perfume> nuevos() {
        return perfumeService.obtenerNuevos();
    }

    @GetMapping("/ofertas")
    @Operation(summary = "Perfumes en oferta")
    public List<Perfume> ofertas() {
        return perfumeService.obtenerOfertas();
    }

}
