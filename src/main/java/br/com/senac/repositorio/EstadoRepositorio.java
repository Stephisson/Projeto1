package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Estado;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Integer>{

}