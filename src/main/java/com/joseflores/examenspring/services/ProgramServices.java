package com.joseflores.examenspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseflores.examenspring.models.ProgramEntity;
import com.joseflores.examenspring.repository.ProgramRepository;

@Service
public class ProgramServices {
    @Autowired
    private ProgramRepository programRepository;
    
    public List<ProgramEntity> findall(){
        return (List<ProgramEntity>) programRepository.findAll();
    }
    public ProgramEntity CrearPrograma(ProgramEntity programa){
        return programRepository.save(programa);
    }
    public ProgramEntity findById(Long programaid){
        Optional<ProgramEntity> programa = programRepository.findById(programaid);
            return programa.isPresent() ? programa.get() : null;
    }
    public void delete(Long programaId){
        ProgramEntity programa = findById(programaId);
        if (programa != null) {
            programRepository.delete(programa);
        }
    }
}