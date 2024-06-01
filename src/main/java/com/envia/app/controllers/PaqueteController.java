package com.envia.app.controllers;

import com.envia.app.repositories.PaqueteRepository;
import com.envia.app.repositories.ClienteRepository;
import com.envia.app.variables.Paquete;
import com.envia.app.variables.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paquetes")
public class PaqueteController {

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String listarPaquetes(Model model) {
        model.addAttribute("paquetes", paqueteRepository.findAll());
        return "index";
    }

    @GetMapping("/form")
    public String mostrarFormularioPaquete(Model model) {
        model.addAttribute("paquete", new Paquete());
        model.addAttribute("clientes", clienteRepository.findAll());
        return "paquete-form";
    }

    @GetMapping("/form/{id}")
    public String mostrarFormularioPaquete(@PathVariable Integer id, Model model) {
        Paquete paquete = paqueteRepository.findById(id).orElse(null);
        model.addAttribute("paquete", paquete);
        model.addAttribute("clientes", clienteRepository.findAll());
        return "paquete-form";
    }

    @PostMapping
    public String guardarPaquete(@ModelAttribute Paquete paquete) {
        paqueteRepository.save(paquete);
        return "redirect:/paquetes";
    }

    @DeleteMapping("/{id}")
    public String eliminarPaquete(@PathVariable Integer id) {
        paqueteRepository.deleteById(id);
        return "redirect:/paquetes";
    }
}
