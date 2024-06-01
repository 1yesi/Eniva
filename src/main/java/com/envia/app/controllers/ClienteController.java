package com.envia.app.controllers;

import com.envia.app.repositories.ClienteRepository;
import com.envia.app.variables.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "index";
    }

    @GetMapping("/form")
    public String mostrarFormularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-form";
    }

    @GetMapping("/form/{id}")
    public String mostrarFormularioCliente(@PathVariable Integer id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        model.addAttribute("cliente", cliente);
        return "cliente-form";
    }

    @PostMapping
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @DeleteMapping("/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes";
    }
}
