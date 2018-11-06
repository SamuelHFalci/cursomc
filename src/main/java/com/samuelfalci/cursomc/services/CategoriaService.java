package com.samuelfalci.cursomc.services;

import com.samuelfalci.cursomc.domain.Categoria;
import com.samuelfalci.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;
    
    public Categoria buscar(Integer id){
        Categoria obj = repo.findOne(id);
        return obj;
    }
}
