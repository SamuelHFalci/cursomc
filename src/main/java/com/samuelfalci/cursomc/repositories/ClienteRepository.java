package com.samuelfalci.cursomc.repositories;

import com.samuelfalci.cursomc.domain.Cliente;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
