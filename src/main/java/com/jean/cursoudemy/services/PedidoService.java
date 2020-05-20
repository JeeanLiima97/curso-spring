package com.jean.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.cursoudemy.domain.Pedido;
import com.jean.cursoudemy.repository.PedidoRepository;
import com.jean.cursoudemy.services.exception.ObjectNotFoundException;


@Service
public class PedidoService  {
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}
}
