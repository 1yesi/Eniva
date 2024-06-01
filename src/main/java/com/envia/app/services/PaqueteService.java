package com.envia.app.services;

import com.envia.app.repositories.PaqueteRepository;
import com.envia.app.variables.Paquete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteService {
    @Autowired
    private PaqueteRepository paqueteRepository;

    public List<Paquete> getAllPaquetes() {
        return paqueteRepository.findAll();
    }

    public Paquete getPaqueteById(Integer id) {
        return paqueteRepository.findById(id).orElse(null);
    }

    public Paquete savePaquete(Paquete paquete) {
        return paqueteRepository.save(paquete);
    }

    public void deletePaquete(Integer id) {
        paqueteRepository.deleteById(id);
    }
}