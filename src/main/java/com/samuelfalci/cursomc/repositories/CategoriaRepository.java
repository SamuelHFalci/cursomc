package com.samuelfalci.cursomc.repositories;

import com.samuelfalci.cursomc.domain.Categoria;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
