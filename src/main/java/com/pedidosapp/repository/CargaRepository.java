package com.pedidosapp.repository;

import com.pedidosapp.models.Carga;
import com.pedidosapp.models.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface CargaRepository extends CrudRepository<Carga, String>{
	Iterable<Carga> findByPedido(Pedido pedido);
	Carga findById(String id);
}
