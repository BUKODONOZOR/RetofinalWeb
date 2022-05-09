package com.crud.democrud.controllers;

import com.crud.democrud.models.TareaModel;
import com.crud.democrud.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/tarea")
@CrossOrigin("*")
public class TareaController {
    @Autowired
    TareaService tareaService;

    @GetMapping("todos")
    public ArrayList<TareaModel> obtenerTareas() {
        return tareaService.obtenerTareas();
    }

    @PostMapping()
    public TareaModel guardarTarea(@RequestBody TareaModel tarea) {
        return this.tareaService.guardarTarea(tarea);
    }

    @GetMapping(path = "/{id}")
    public Optional<TareaModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.tareaService.obtenerPorId(id);
    }

    @PutMapping(path = "/{nombre}")
    public void update(@RequestBody TareaModel  tarea){
      TareaService.update(tarea);

    }


    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.tareaService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}