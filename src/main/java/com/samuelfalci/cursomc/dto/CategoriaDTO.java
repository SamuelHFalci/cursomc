package com.samuelfalci.cursomc.dto;

import com.samuelfalci.cursomc.domain.Categoria;
import java.io.Serializable;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class CategoriaDTO implements Serializable {

    private Integer id;
    @NotEmpty(message="preenchimento Obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ter de 5 a 80 caracteres.")
    private String nome;

    public CategoriaDTO() {
    }
    
    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
