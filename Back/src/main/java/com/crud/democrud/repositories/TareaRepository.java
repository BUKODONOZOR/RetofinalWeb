package com.crud.democrud.repositories;

import com.crud.democrud.models.TareaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TareaRepository extends CrudRepository<TareaModel, Long> {
    

}