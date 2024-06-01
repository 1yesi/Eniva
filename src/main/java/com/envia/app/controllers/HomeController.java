package com.envia.app.controllers;

import com.envia.app.services.ClienteService;
import com.envia.app.services.PaqueteService;
import com.envia.app.variables.Cliente;
import com.envia.app.variables.Paquete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PaqueteService paqueteService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public String index(Model model) {
        List<Paquete> paquetes = paqueteService.getAllPaquetes();
        List<Cliente> clientes = clienteService.getAllClientes();

        model.addAttribute("paquetes", paquetes);
        model.addAttribute("clientes", clientes);

        return "index";
    }
}
