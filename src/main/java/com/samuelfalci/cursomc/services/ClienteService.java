package com.samuelfalci.cursomc.services;

import com.samuelfalci.cursomc.domain.Cliente;
import com.samuelfalci.cursomc.repositories.ClienteRepository;
import com.samuelfalci.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repo;
    
    public Cliente buscar(Integer id){
        Cliente obj = repo.findOne(id);
        if(obj == null){
            throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id +", Tipo: "+Cliente.class.getName());
        }
        return obj;
    }
}
