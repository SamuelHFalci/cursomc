/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuelfalci.cursomc.repositories;

import com.samuelfalci.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Samuka
 */
@Repository
public interface CidadeRepository  extends JpaRepository<Cidade, Integer>{
    
}
