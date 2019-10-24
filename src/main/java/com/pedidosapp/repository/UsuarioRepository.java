package com.pedidosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.pedidosapp.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
