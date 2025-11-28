package com.micro.perfume.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.micro.perfume.model.Perfume;
import com.micro.perfume.model.dto.PerfumeCrearDTO;
import com.micro.perfume.repository.PerfumeRepository;

@Service
public class PerfumeService {

    private final PerfumeRepository perfumeRepository;

    public PerfumeService(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }

    //listar todos
    public List<Perfume> obtenerTodos() {
        return perfumeRepository.findAll();
    }

    //buscar por Id
    public Perfume obtenerPorId(Long productoId) {
        return perfumeRepository.findById(productoId).orElse(null);
    }

    //crear perfume
    public Perfume crearPerfume(PerfumeCrearDTO dto) {
        Perfume perfume = new Perfume();
        perfume.setProductoId(null);

        perfume.setNombre(dto.getNombre());
        perfume.setMarca(dto.getMarca());
        perfume.setPrecio(dto.getPrecio());
        perfume.setImagen(dto.getImagen());
        perfume.setGenero(dto.getGenero());
        perfume.setNotas(dto.getNotas());
        perfume.setDescripcion(dto.getDescripcion());
        perfume.setMasVendido(dto.isMasVendido());
        perfume.setNuevo(dto.isNuevo());
        perfume.setOferta(dto.isOferta());

        return perfumeRepository.save(perfume);
    }

    //actualizar perfume
    public Perfume actualizarPerfume(Long productoId, Perfume perfumeActualizado) {
        return perfumeRepository.findById(productoId).map(perfume -> {
            perfume.setNombre(perfumeActualizado.getNombre());
            perfume.setMarca(perfumeActualizado.getMarca());
            perfume.setPrecio(perfumeActualizado.getPrecio());
            perfume.setImagen(perfumeActualizado.getImagen());
            perfume.setGenero(perfumeActualizado.getGenero());
            perfume.setNotas(perfumeActualizado.getNotas());
            perfume.setDescripcion(perfumeActualizado.getDescripcion());
            perfume.setMasVendido(perfumeActualizado.isMasVendido());
            perfume.setNuevo(perfumeActualizado.isNuevo());
            perfume.setOferta(perfumeActualizado.isOferta());
            return perfumeRepository.save(perfume);
        }).orElse(null);
    }

    //eliminar perfume por id
    public void eliminarPerfume(Long productoId) {
        if (!perfumeRepository.existsById(productoId)) {
            throw new RuntimeException("Perfume no encontrado con ese id" + productoId);
        }
        perfumeRepository.deleteById(productoId);
    }

    // Buscar por marca
    public List<Perfume> obtenerPorMarca(String marca) {
        return perfumeRepository.findByMarca(marca);
    }

    // Buscar por nombre
    public Perfume obtenerPorNombre(String nombre) {
        Perfume perfume = perfumeRepository.findByNombre(nombre);
        if (perfume == null) {
            throw new RuntimeException("No se encontró un perfume con nombre: " + nombre);
        }
        return perfume;
    }

    // Buscar por género
    public List<Perfume> obtenerPorGenero(String genero) {
        return perfumeRepository.findByGenero(genero);
    }

    // Buscar perfumes más vendidos
    public List<Perfume> obtenerMasVendidos() {
        return perfumeRepository.findByMasVendidoTrue();
    }

    // Buscar perfumes nuevos
    public List<Perfume> obtenerNuevos() {
        return perfumeRepository.findByNuevoTrue();
    }

    // Buscar perfumes en oferta
    public List<Perfume> obtenerOfertas() {
        return perfumeRepository.findByOfertaTrue();
    }

    // Buscar por notas (que contengan alguna de las notas)
    public List<Perfume> obtenerPorNotas(List<String> notas) {
        return perfumeRepository.findByNotasIn(notas);
    }

}
