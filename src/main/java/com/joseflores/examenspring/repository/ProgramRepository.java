package com.joseflores.examenspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.joseflores.examenspring.models.ProgramEntity;

public interface ProgramRepository extends CrudRepository<ProgramEntity, Long>{
    
}
