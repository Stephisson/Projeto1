package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.dominio.Cidade;

public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {

}