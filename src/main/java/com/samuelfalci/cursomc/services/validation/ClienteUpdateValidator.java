/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuelfalci.cursomc.services.validation;

import com.samuelfalci.cursomc.domain.Cliente;
import com.samuelfalci.cursomc.domain.enums.TipoCliente;
import com.samuelfalci.cursomc.dto.ClienteDTO;
import com.samuelfalci.cursomc.repositories.ClienteRepository;
import com.samuelfalci.cursomc.resources.exception.FieldMessage;
import com.samuelfalci.cursomc.services.validation.utils.BR;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private ClienteRepository repo;
    
    @Override
    public void initialize(ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
       
        Map<String, String> map = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));
        List<FieldMessage> list = new ArrayList<>();
                       
        Cliente aux = repo.findByEmail(objDto.getEmail());
        
        if(aux == null && !aux.getId().equals(uriId)){
            list.add(new FieldMessage("email", "Email já existente"));
        }
        
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
