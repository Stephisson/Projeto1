package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Cidade;

@Repository
public interface CidadeRepositorio extends JpaRepository<Cidade, Integer>{

}
