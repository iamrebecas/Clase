package com.clase.controller;

import com.clase.controller.domain.Cliente;
import com.clase.dao.ClienteDao;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j

@Controller
public class IndexController {
    
    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/")
    public String inicio(Model model) {

        log.info("ahora se usa arquitectura MVC");

        Cliente cliente = new Cliente("Rebeca", "Solano", "rsolano@abc.com", "88888888");
       //  Cliente cliente2 = new Cliente("Alejandro", "Chaves", "achaves@abc.com", "88888876");
        
       //  var clientes = Arrays.asList(cliente,cliente2);
       
       var clientes = clienteDao.findAll();

       model.addAttribute("cliente", cliente);
       model.addAttribute("clientes",clientes);

        return "index";
    }

}
