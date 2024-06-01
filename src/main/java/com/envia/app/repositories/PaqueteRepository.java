package com.envia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.envia.app.variables.Paquete;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {}