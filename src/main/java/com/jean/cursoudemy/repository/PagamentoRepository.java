package com.jean.cursoudemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jean.cursoudemy.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
