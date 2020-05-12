package com.jean.cursoudemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jean.cursoudemy.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
