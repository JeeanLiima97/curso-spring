package com.jean.cursoudemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jean.cursoudemy.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
