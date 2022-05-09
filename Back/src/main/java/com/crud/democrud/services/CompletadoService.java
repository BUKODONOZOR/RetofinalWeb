package com.crud.democrud.services;



import com.crud.democrud.models.CompletadoModel;
import com.crud.democrud.repositories.CompletadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CompletadoService {

    @Autowired
    CompletadoRepository CompletadoRepository;
    
    public ArrayList<CompletadoModel> obtenerEstados(){
        return (ArrayList<CompletadoModel>) CompletadoRepository.findAll();
    }


    public CompletadoModel guardarEstados(CompletadoModel completado){
        return CompletadoRepository.save(completado);
    }

    public Optional<CompletadoModel> obtenerPorId(Long id){
        return CompletadoRepository.findById(id);
    }


    public boolean eliminarEstado(Long id) {
        try{
            CompletadoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    
}
