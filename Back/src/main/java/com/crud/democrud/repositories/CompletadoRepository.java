package com.crud.democrud.repositories;


import com.crud.democrud.models.CompletadoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository

public interface CompletadoRepository  extends CrudRepository<CompletadoModel, Long>{
    
}
