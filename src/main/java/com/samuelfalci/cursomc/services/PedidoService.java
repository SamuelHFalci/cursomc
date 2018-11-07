package com.samuelfalci.cursomc.services;

import com.samuelfalci.cursomc.domain.Pedido;
import com.samuelfalci.cursomc.repositories.PedidoRepository;
import com.samuelfalci.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;
    
    public Pedido buscar(Integer id){
        Pedido obj = repo.findOne(id);
        if(obj == null){
            throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id +", Tipo: "+Pedido.class.getName());
        }
        return obj;
    }
}
