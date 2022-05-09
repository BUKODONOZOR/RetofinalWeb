package com.crud.democrud.controllers;


import com.crud.democrud.models.CompletadoModel;
import com.crud.democrud.models.TareaModel;
import com.crud.democrud.services.CompletadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.OneToOne;

public class CompletadoController {

    @Autowired
    CompletadoService CompletadoService;

    @GetMapping("todose")
    public ArrayList<CompletadoModel> obtenerEstados() {
        return CompletadoService.obtenerEstados();
    }

    @OneToOne()
    private TareaModel tarea; 

    @PostMapping()
    public CompletadoModel guardarEstados(@RequestBody CompletadoModel tarea) {
        return this.CompletadoService.guardarEstados(tarea);
    }

    @GetMapping(path = "/{id}")
    public Optional<CompletadoModel> obtenerEstadoPorId(@PathVariable("id") Long id) {
        return this.CompletadoService.obtenerPorId(id);
    }


    @DeleteMapping(path = "/{id}")
    public String eliminarEstado(@PathVariable("id") Long id) {
        boolean ok = this.CompletadoService.eliminarEstado(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }
    
}
