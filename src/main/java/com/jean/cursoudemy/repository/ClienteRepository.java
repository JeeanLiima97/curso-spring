package com.jean.cursoudemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jean.cursoudemy.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
