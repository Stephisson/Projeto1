package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.dominio.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {
	
	Usuario findByEmail(String email);

}