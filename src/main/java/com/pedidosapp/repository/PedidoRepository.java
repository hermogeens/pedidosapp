package com.pedidosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.pedidosapp.models.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, String>{
	Pedido findByCodigo(long codigo);
}
