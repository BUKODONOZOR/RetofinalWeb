package com.crud.democrud.services;

import com.crud.democrud.models.TareaModel;
import com.crud.democrud.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TareaService {
    @Autowired
    TareaRepository TareaRepository;
    
    public ArrayList<TareaModel> obtenerTareas(){
        return (ArrayList<TareaModel>) TareaRepository.findAll();
    }

    public TareaModel guardarTarea(TareaModel tarea){
        return TareaRepository.save(tarea);
    }

    public Optional<TareaModel> obtenerPorId(Long id){
        return TareaRepository.findById(id);
    }


    public boolean eliminarUsuario(Long id) {
        try{
            TareaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public static void update(TareaModel tarea) {
        
    }


    
}