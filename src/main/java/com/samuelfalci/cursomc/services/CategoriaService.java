package com.samuelfalci.cursomc.services;

import com.samuelfalci.cursomc.domain.Categoria;
import com.samuelfalci.cursomc.repositories.CategoriaRepository;
import com.samuelfalci.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;
    
    public Categoria buscar(Integer id){
        Categoria obj = repo.findOne(id);
        if(obj == null){
            throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id +", Tipo: "+Categoria.class.getName());
        }
        return obj;
    }
    
    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }
}
